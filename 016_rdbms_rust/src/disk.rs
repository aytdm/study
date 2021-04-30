use std::convert::TryInto;
use std::fs::{File, OpenOptions};
use std::io::{self, prelude::*, SeekFrom};
use std::path::Path;

use zerocopy::{AsBytes, FromBytes};

pub const PAGE_SIZE: usize = 4096;

#[derive(Debug, Clone, Copy, Eq, PartialEq, Hash, FromBytes, AsBytes)]
#[repr(C)]
pub struct PageId(pub u64);
impl PageId {
  pub const INVALID_PAGE_ID: PageId = PageId(u64::MAX);

  pub fn valid(self) -> Option<PageId> {
    if self == Self::INVALID_PAGE_ID {
      None
    } else {
      Some(self)
    }
  }

  pub fn to_u64(self) -> u64 {
    self.0
  }
}

impl Default for PageId {
  fn default() -> Self {
    Self::INVALID_PAGE_ID
  }
}

impl From<Option<PageId>> for PageId {
  fn from(page_id: Option<PageId>) -> Self {
    page_id.unwrap_or_default()
  }
}

impl From<&[u8]> for PageId {
  fn from(bytes: &[u8]) -> Self {
    let arr = bytes.try_into().unwrap();
    PageId(u64::from_ne_bytes(arr))
  }
}

pub struct DiskManager {
  // file descriptor for heap file
  heap_file: File,
  // counter for page id
  next_page_id: u64,
}

impl DiskManager {
  // constructor
  pub fn new(heap_file: File) -> io::Result<Self> {
    // get file size
    let heap_file_size = heap_file.metadata()?.len();
    let next_page_id = heap_file_size / PAGE_SIZE as u64;
    Ok(Self {
      heap_file,
      next_page_id,
    })
  }

  // open file
  pub fn open(heap_file_path: impl AsRef<Path>) -> io::Result<Self> {
    let heap_file = OpenOptions::new()
                      .read(true)
                      .write(true)
                      .create(true)
                      .open(heap_file_path)?;
    Self::new(heap_file)
  }

  // allocate page id
  pub fn allocate_page(&mut self) -> PageId {
    let page_id = self.next_page_id;
    self.next_page_id += 1;
    PageId(page_id)
  }

  // read page data
  pub fn read_page_data(
    &mut self,
    page_id: PageId,
    data: &mut [u8]
  ) -> io::Result<()> {
    //calc offset
    let offset = PAGE_SIZE as u64 * page_id.to_u64();
    // seek for page head
    self.heap_file.seek(SeekFrom::Start(offset))?;
    // read
    self.heap_file.read_exact(data)
  }

  // write data to page
  pub fn write_page_data(
    &mut self,
    page_id: PageId,
    data: &[u8]
  ) -> io::Result<()> {
    // calc offset
    let offset = PAGE_SIZE as u64 * page_id.to_u64();
    // seek for page head
    self.heap_file.seek(SeekFrom::Start(offset))?;
    // write
    self.heap_file.write_all(data)
  }

  pub fn sync(&mut self) -> io::Result<()> {
    self.heap_file.flush()?;
    self.heap_file.sync_all()
  }
}
