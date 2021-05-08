use std::ops::Deref;

enum List {
    Cons(i32, Rc<List>),
    Nil,
}

use crate::List::{Cons, Nil};
use std::rc::Rc;

impl<T> Deref for MyBox<T> {
    type Target = T;

    fn deref(&self) -> &T {
        &self.0
    }
}

struct MyBox<T>(T);

impl<T> MyBox<T> {
    fn new(x: T) -> MyBox<T> {
        MyBox(x)
    }
}

struct CustomSmartPointer {
    data: String,
}

impl Drop for CustomSmartPointer {
    fn drop(&mut self) {
        println!("Dropping CustomSmartPointer with data `{}`", self.data);
    }
}

fn hello(name: &str) {
    println!("Hello, {}", name);
}

fn main() {
    let b = Box::new(5);
    println!("Hello, world!\nb = {}", b);

    /* --------------- */
    let x = 5;
    let y = Box::new(x);

    assert_eq!(5, x);
    assert_eq!(5, *y);

    /* --------------- */
    let z = 5;
    let w = MyBox::new(x);

    assert_eq!(5, z);
    assert_eq!(5, *w);

    /* --------------- */
    let m = MyBox::new(String::from("Rust"));
    hello(&m);

    /* --------------- */
    let m = MyBox::new(String::from("rust"));
    hello(&(*m)[..]);

    /* --------------- */
    let _c = CustomSmartPointer {
        data: String::from("my stuff"),
    };
    let _d = CustomSmartPointer {
        data: String::from("other stuff"),
    };
    let f = CustomSmartPointer {
        data: String::from("some stuff"),
    };
    println!("CustomSmartPointers created.");

    drop(f);
    println!("CustomSmartPointer dropped before the end of main.");

    /* 15-4 --------------- */
    let a = Rc::new(Cons(5, Rc::new(Cons(10, Rc::new(Nil)))));
    println!("count after creating a = {}", Rc::strong_count(&a));
    let _b = Cons(3, Rc::clone(&a));
    println!("count after creating b = {}", Rc::strong_count(&a));
    {
        let _c = Cons(4, Rc::clone(&a));
        println!("count after creating c = {}", Rc::strong_count(&a));
    }
    println!("count after c goes out of scope = {}", Rc::strong_count(&a));
}
