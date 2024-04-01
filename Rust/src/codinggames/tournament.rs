#![allow(warnings,unused)]
macro_rules! parse_input {
    ($x:expr, $t:ident) => ($x.trim().parse::<$t>().unwrap())
}

pub mod solver {
    use std::collections::HashMap;

    #[derive(Debug,Clone)]
    struct Player {
        sign : String,
        num:i32,
        defeated:String
    }

    pub fn solve(participants: Vec<&str>) -> HashMap<i32,String> {
        //let mut input_line = String::new();
        //io::stdin().read_line(&mut input_line).unwrap();
        let mut winners : Vec<Player> = Vec::new();
        let mut winner  = 0;
        let mut num_player_1:i32 = 0;
        let mut num_player_2:i32 = 0;
        let mut sign_player_1: String = "L".to_string();
        let mut sign_player_2;
        let n = participants.len() as i32;
        //let n = parse_input!(input_line, i32);
        let round_amount = n / 2;
        for j in 0..round_amount {
            if j == 0 {
                for i in 0..n {
                    //let mut input_line = String::new();dd
                    //io::stdin().read_line(&mut input_line).unwrap();
                    //let inputs = input_line.split(" ").collect::<Vec<_>>();
                    let inputs = participants[i as usize].split(" ").collect::<Vec<_>>();
                    if i % 2 == 1 {
                        num_player_2 = parse_input!(inputs[0], i32);
                        sign_player_2 = inputs[1].trim().to_string();
                        if sign_player_2 == "S"{
                            match sign_player_1.as_str() {
                                "C"|"R" => {
                                    create_and_add_non_existing_player(&mut winners,  &mut winner,  num_player_1,  num_player_2, sign_player_2.clone());
                                }
                                "L"|"P" => {
                                    create_and_add_non_existing_player(&mut winners, &mut winner,  num_player_2,  num_player_1, sign_player_1.clone());
                                }
                                "S" => {
                                    equality_handling('c',&mut winners,  &mut winner,  num_player_1,  num_player_2, sign_player_1.clone(), sign_player_2, i - 1, i)
                                }
                                _ => {
                                }
                            }
                        } else if sign_player_2 == "C" {
                            match sign_player_1.as_str() {
                                "P"|"L" => {
                                    create_and_add_non_existing_player(&mut winners,  &mut winner,  num_player_1,  num_player_2, sign_player_2);
                                }
                                "R"|"S" => {
                                    create_and_add_non_existing_player(&mut winners,&mut  winner,  num_player_2,  num_player_1, sign_player_1.clone());
                                }
                                "C" => {
                                    equality_handling('c',&mut winners,  &mut winner,  num_player_1,  num_player_2,  sign_player_1.clone(),  sign_player_2, i - 1, i)
                                }
                                _ => {
                                }
                            }
                        } else if sign_player_2 == "L" {
                            match sign_player_1.as_str() {
                                "S"|"P" => {
                                    create_and_add_non_existing_player(&mut winners,  &mut winner,  num_player_1,  num_player_2, sign_player_2.clone());
                                }
                                "C"|"R" => {
                                    create_and_add_non_existing_player(&mut winners, &mut winner,  num_player_2,  num_player_1, sign_player_1.clone());
                                }
                                "L" => {
                                    equality_handling('c', &mut winners, &mut winner,  num_player_1,  num_player_2,  sign_player_1.clone(),  sign_player_2,  i- 1, i)
                                }
                                _ => {
                                }
                            }
                        } else if sign_player_2 == "P" {
                            match sign_player_1.as_str() {
                                "S"|"R" => {
                                    create_and_add_non_existing_player(&mut winners,  &mut winner,  num_player_1,  num_player_2, sign_player_2);
                                }
                                "L"|"C" => {
                                    create_and_add_non_existing_player(&mut winners, &mut  winner,  num_player_2,  num_player_1, sign_player_1.clone());
                                }
                                "P" => {
                                    equality_handling('c', &mut winners,  &mut winner,  num_player_1,  num_player_2,  sign_player_1.clone(),  sign_player_2, i - 1 , i)
                                }
                                _ => {
                                }
                            }
                        } else {
                            match sign_player_1.as_str() {
                                "L"|"C" => {
                                    create_and_add_non_existing_player(&mut winners, &mut winner,  num_player_1,  num_player_2, sign_player_2);
                                }
                                "S"|"P" => {
                                    create_and_add_non_existing_player(&mut winners,  &mut winner,  num_player_2,  num_player_1, sign_player_1.clone());
                                }
                                "R" => {
                                    equality_handling('c', &mut winners,  &mut winner, num_player_1, num_player_2, sign_player_1.clone(), sign_player_2, i - 1 , i)
                                }
                                _ => {
                                }
                            }
                        }
                    } else {
                        num_player_1 = parse_input!(inputs[0], i32);
                        sign_player_1 = inputs[1].trim().to_string();

                    }
                }
            } else {

                for i in 0..winners.len() {
                    if i % 2 == 1 {
                        let player2 : Player;
                        let player1: Player;

                        let mut index= 0;
                        if  i < 2{
                            index = i;
                        } else if i >= 2 {
                            index = i/2 + 1;
                        }
                        player2 = winners.get(index).unwrap().clone();
                        player1= winners.get(index -  1).unwrap().clone();
                        let indexplayer1 = index-1;
                        let indexplayer2 = index;
                        num_player_1 = player1.num.clone();
                        sign_player_1 = player1.sign.clone();
                        num_player_2 = player2.num.clone();
                        sign_player_2 = player2.sign.clone();
                        if sign_player_2 == "S"{
                            match sign_player_1.as_str() {
                                "C"|"R" => {
                                    set_winner_remove_loser(&mut winners,  &mut winner, num_player_1, index as i32, index as i32 - 1);

                                }
                                "L"|"P" => {
                                    set_winner_remove_loser(&mut winners, &mut  winner, num_player_2, indexplayer1 as i32 , indexplayer2 as i32)
                                }
                                "S" => {
                                    equality_handling('u', &mut winners,  &mut winner,  num_player_1,  num_player_2,  sign_player_1.clone(),  sign_player_2,indexplayer1 as i32, indexplayer2 as i32);
                                }
                                _ => {
                                }

                            }
                        } else if sign_player_2 == "C" {
                            match sign_player_1.as_str() {
                                "P"|"L" => {
                                    set_winner_remove_loser(&mut winners, &mut  winner, num_player_1, indexplayer2 as i32, indexplayer1 as i32)
                                }
                                "R"|"S" => {
                                    set_winner_remove_loser(&mut winners,  &mut winner, num_player_2, indexplayer1 as i32, indexplayer2 as i32)
                                }
                                "C" => {
                                    equality_handling('u', &mut winners,  &mut winner,  num_player_1,  num_player_2,  sign_player_1.clone(),  sign_player_2,indexplayer1 as i32, indexplayer2 as i32);
                                }
                                _ => {
                                }
                            }
                        } else if sign_player_2 == "L" {
                            match sign_player_1.as_str() {
                                "S"|"P" => {
                                    set_winner_remove_loser(&mut winners,&mut winner, num_player_1, indexplayer2 as i32, indexplayer1 as i32)
                                }
                                "C"|"R" => {
                                    set_winner_remove_loser(&mut winners,&mut winner, num_player_2, indexplayer1 as i32, indexplayer2 as i32)
                                }
                                "L" => {
                                    equality_handling('u', &mut winners, &mut winner,  num_player_1,  num_player_2,  sign_player_1.clone(),  sign_player_2,indexplayer1 as i32, indexplayer2 as i32);
                                }
                                _ => {
                                }
                            }
                        } else if sign_player_2 == "P" {
                            match sign_player_1.as_str() {
                                "S"|"R" => {
                                    set_winner_remove_loser(&mut winners, &mut  winner, num_player_1, indexplayer2 as i32  , indexplayer1 as i32);
                                },
                                "L"|"C" => {
                                    set_winner_remove_loser(&mut winners,&mut winner, num_player_2, indexplayer1 as i32, indexplayer2 as i32);
                                },
                                "P" => {

                                    equality_handling('u', &mut winners,&mut winner,  num_player_1,  num_player_2,  sign_player_1.clone(),  sign_player_2,indexplayer1 as i32, indexplayer2 as i32);
                                },
                                _ => {
                                }
                            }
                        } else {
                            match sign_player_1.as_str() {
                                "L"|"C" => {
                                    set_winner_remove_loser(&mut winners,  &mut winner, num_player_1, indexplayer2 as i32, indexplayer1 as i32);
                                },
                                "S"|"P" => {
                                    set_winner_remove_loser(&mut winners, &mut winner, num_player_2, indexplayer1 as i32, indexplayer2 as i32);
                                },
                                "R" => {
                                    equality_handling('u', &mut winners, &mut winner,  num_player_1,  num_player_2,  sign_player_1.clone(),  sign_player_2,indexplayer1 as i32, indexplayer2 as i32);
                                },
                                _ => {
                                }
                            }
                        }
                    }

                }
            }
        }
        let mut book_reviews = HashMap::new();

        book_reviews.insert(
            winner,
            winners.get(0).unwrap().defeated.to_string()
        );
        println!("{:?}", book_reviews);
        book_reviews
    }

    fn equality_handling(c_or_u: char, mut winners: &mut Vec<Player>,  winner:&mut i32,  num_player_1: i32, num_player_2:  i32,  sign_player_1:  String,  sign_player_2:String, index_player_1:i32, index_player_2:i32) {
        if c_or_u == 'c' {
            if num_player_2 < num_player_1 {
                create_and_add_non_existing_player(&mut winners,  winner,  num_player_1, num_player_2, sign_player_2.clone());
            } else {
                create_and_add_non_existing_player(&mut winners,  winner,  num_player_2, num_player_1, sign_player_1.clone());
            }

        } else {
            if num_player_2 < num_player_1 {
                set_winner_remove_loser(&mut winners, winner, num_player_1, index_player_2, index_player_1)
            } else {
                set_winner_remove_loser(&mut winners,  winner, num_player_2, index_player_1, index_player_2)
            }
        }
    }

    fn create_and_add_non_existing_player(winners: &mut Vec<Player>,  winner: &mut i32, loser_number:  i32, num_winner: i32, sign_winner: String) {
        let round_winner = Player {
            sign: sign_winner,
            num: num_winner.clone(),
            defeated: loser_number.to_string()
        };
        *winner =  num_winner.clone();
        winners.push(round_winner);

    }

    fn set_winner_remove_loser( winners: &mut Vec<Player>, winner:  &mut i32, round_loser: i32, index_player: i32, index_to_remove: i32) {
        let player: &Player = winners.get(index_player as usize).unwrap();
        let new_defeated = format!("{} {}",player.defeated, round_loser);
        let new_player = Player {
            sign: player.sign.clone(),
            num: player.num.clone(),
            defeated: new_defeated
        };
        if index_player < index_to_remove {
            winners.remove(index_to_remove as usize);
            winners[index_player as usize] = new_player.clone();
        } else {
            winners[(index_player) as usize] = new_player.clone();
            winners.remove(index_to_remove as usize);
        }
        *winner =  new_player.num.clone();
    }
}


#[cfg(test)]
mod tests {
    use std::collections::HashMap;
    use crate::tournament;

    #[test]
    fn exploration() {
        let participants = vec!["28 R",
                                "3 R",
                                "13 L",
                                "6 P",
                                "32 C",
                                "5 R",
                                "11 S",
                                "27 S",
                                "22 L",
                                "31 R",
                                "30 R",
                                "10 P",
                                "18 R",
                                "23 R",
                                "8 R",
                                "20 S",
                                "7 P",
                                "19 P",
                                "26 P",
                                "4 R",
                                "16 C",
                                "21 P",
                                "1 C",
                                "14 C",
                                "29 R",
                                "9 P",
                                "25 C",
                                "24 P",
                                "15 R",
                                "2 L",
                                "12 L",
                                "17 S"];
        let mut answer:HashMap<i32,String> = HashMap::new();
        answer.insert(10,"30 31 20 11 15".to_string());
        assert_eq!(answer, tournament::solver::solve(participants));
        assert_eq!(2+2, 4);

    }
    #[test]
    fn exploration2() {
        let participants = vec![
            "4 R",
            "1 P",
            "8 P",
            "3 R",
            "7 C",
            "5 S",
            "6 L",
            "2 L"];
        let mut answer:HashMap<i32,String> = HashMap::new();
        answer.insert(2,"6 5 1".to_string());
        assert_eq!(answer, tournament::solver::solve(participants));
        assert_eq!(2+2, 4);

    }
}
