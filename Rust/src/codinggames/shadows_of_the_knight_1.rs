#![allow(warnings,unused)]
mod shadows_of_the_night {
    use std::collections::HashMap;
    use std::io;
    macro_rules! parse_input {
    ($x:expr, $t:ident) => ($x.trim().parse::<$t>().unwrap())
}
    struct Position {
        x: i32,
        y: i32
    }
    pub fn solve(h_w_input: String, turns: String, base_position: String, directions:Vec<String>) ->String{
        let mut input_line = String::new();
        //io::stdin().read_line(&mut input_line).unwrap();
        let inputs = h_w_input.split(" ").collect::<Vec<_>>();
        let w = parse_input!(inputs[0], i32); // width of the building.
        let h = parse_input!(inputs[1], i32); // height of the building.
        input_line = String::new();
        //io::stdin().read_line(&mut input_line).unwrap();
        let _n = parse_input!(turns, i32); // maximum number of turns before game over.
        input_line = String::new();
        //io::stdin().read_line(&mut input_line).unwrap();
        let inputs = base_position.split(" ").collect::<Vec<_>>();
        let mut x0 = parse_input!(inputs[0], i32);
        let mut y0 = parse_input!(inputs[1], i32);
        let mut instructions: HashMap<String, Position> = HashMap::new();
        instructions.insert("U".to_string(), Position {x:0,y:-1});
        instructions.insert("UL".to_string(), Position {x:-1,y:-1});
        instructions.insert("UR".to_string(), Position {x:1,y:-1});
        instructions.insert("R".to_string(), Position {x:1,y:0});
        instructions.insert("DR".to_string(), Position {x:1,y:1});
        instructions.insert("D".to_string(), Position {x:0,y:1});
        instructions.insert("DL".to_string(), Position {x:-1,y:1});
        instructions.insert("L".to_string(), Position {x:-1,y:0});
        let mut min_y=0;
        let mut max_y=h;
        let mut min_x=0;
        let mut max_x=w;
        let _ffloat = 0.1;
        let mut index = 0;
        loop {
            let mut input_line = String::new();
            io::stdin().read_line(&mut input_line).unwrap();
            //let bomb_dir = input_line.trim().to_string();
            let bomb_dir = directions.get(index).unwrap();
            index += 1;
            let base_x_modifier = instructions.get(bomb_dir).unwrap().y;
            let base_y_modifier = instructions.get(bomb_dir).unwrap().x;
            if bomb_dir.starts_with("D"){
                min_y = y0;
                y0 = y0 + (base_x_modifier * ((max_y - y0)/2));
            } else if bomb_dir.starts_with("U") {
                max_y = y0;
                y0 = (y0 +min_y)/2;
            } else {
                y0 = y0;
            }
            if bomb_dir.ends_with("R") {
                min_x = x0;
                x0 = x0 + (base_y_modifier * (max_x - x0)/2);
            } else if bomb_dir.ends_with("L") {
                max_x = x0;
                x0 = x0 + (base_y_modifier *(((x0 - min_x)/2 )+ 1) );
            } else {
                x0 = x0;
            }
            format!("{} {}", base_y_modifier, base_x_modifier);
        }
    }

}
