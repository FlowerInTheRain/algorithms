fn main(){
    let mut winner: i32 = 0;
    update_winner(&mut winner);
    println!("{}", winner);
}
fn update_winner(w: &mut i32){
    *w= *w + 2;
}