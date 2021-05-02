use anyhow::Result;

use rdbms_rust::btree::{BTree, SearchMode};
use rdbms_rust::buffer::{BufferPool, BufferPoolManager};
use rdbms_rust::disk::{DiskManager, PageId};

fn main() -> Result<()> {
  // open B+Tree
  let btree = BTree::new(PageId(0));
  // search
  let mut iter = btree.search(&mut bufmgr, SearchMode::Key(b"Hyogo".to_vec()))?;
  // fetch value
  let (key, value) = iter.next(&mut bufmgr)?.unwrap();

  println!("{:02x?} = {:02x?}", key, value);
  Ok(())
}
