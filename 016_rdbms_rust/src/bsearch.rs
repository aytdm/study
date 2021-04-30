use std::cmp::Ordering::{self, Greater, Less};

/*
 * This is originated in Rust core library:
 * https://github.com/rust-lang/rust/blob/b01026de465d5a5ef51e32c1012c43927d2a111c/library/core/src/slice/mod.rs#L2186
 *
 * Permission is hereby granted, free of charge, to any
 * person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the
 * Software without restriction, including without
 * limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following
 * conditions:
 * The above copyright notice and this permission notice
 * shall be included in all copies or substantial portions
 * of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF
 * ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT
 * SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
pub fn binary_search_by<F>(mut size: usize, mut f: F) -> Result<usize, usize>
where
  F: FnMut(usize) -> Ordering,
{
  let mut left = 0;
  let mut right = size;
  while left < right {
    let mid = left + size / 2;
    let cmp = f(mid);
    if cmp == Less {
      left = mid + 1;
    } else if cmp == Greater {
      right = mid;
    } else {
      return Ok(mid);
    }
    size = right - left;
  }
  Err(left)
}
