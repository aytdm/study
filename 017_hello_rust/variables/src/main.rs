use std::io;

fn main() {
    let mut x = 5;
    println!("The value of x is: {}", x);

    x = 6;
    println!("The value of x is: {}", x);

    let guess: u32 = "42".parse().expect("Not a number!");
    println!("{}", guess);

    // addition
    let _sum = 5 + 10;

    // subtraction
    let _difference = 95.5 - 4.3;

    // multiplication
    let _product = 4 * 30;

    // division
    let _quotient = 56.7 / 32.2;

    // remainder
    let _remainder = 43 % 5;

    let tup: (i32, f64, u8) = (500, 6.4, 1);
    let (_x, y, _z) = tup;
    println!("The value of y is: {}", y);

    let five_hundred = tup.0;
    println!("The value of five_hundred is: {}", five_hundred);

    let six_point_four = tup.1;
    println!("The value of six_point_four is: {}", six_point_four);

    let one = tup.2;
    println!("The value of one is: {}", one);

    let _a = [1, 2, 3, 4, 5];

    let _months = ["January", "February", "March", "April", "May", "June", "July",
              "August", "September", "October", "November", "December"];

    let array: [i32; 5] = [1, 2, 3, 4, 5];
    println!("{:?}", array);

    let a = [3; 5];
    println!("{:?}", a);

    arrayFunction();
}

fn arrayFunction() {
    let a = [1, 2, 3, 4, 5];

    println!("Please enter an array index.");

    let mut index = String::new();

    io::stdin()
        .read_line(&mut index)
        .expect("Failed to read line");

    let index: usize = index
        .trim()
        .parse()
        .expect("Index entered was not a number");

    let element = a[index];

    println!(
        "The value of the element at index {} is: {}",
        index, element
    );
}