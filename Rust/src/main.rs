use std::env;


fn main() {
    println!("{}", env::consts::OS);
    let mut line = String::new();
    println!("Enter your name :");
    let b1 = std::io::stdin().read_line(&mut line).unwrap();
    let v = [1,2,3,4,-2,-5].iter().map(|x| x).p;
        if !v.is_empty(){
            let arr:Vec<i32> = v.into_iter().fold([0,0], |mut res, item| {if item > 0 { res[0]+= 1; res } else { res[1] += item; res}}).into();
            println!("{:?}", arr);
        } else {
            println!("{:?}", Vec::<i32>::new())
        }
}