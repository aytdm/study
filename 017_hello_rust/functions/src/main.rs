fn main() {
    let _x = 5;

    let y = {
        let x = 3;
        x + 1
    };

    println!("The value of y is: {}", y);

    let result = plus_one(5);

    println!("The value of result is: {}", result);
}

fn plus_one(x: i32) -> i32 {
    x + 1
}
