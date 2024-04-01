use std::env;


fn main() {
    println!("{}", env::consts::OS);
    let mut line = String::new();
    println!("Enter your name :");
    let b1 = std::io::stdin().read_line(&mut line).unwrap();
}