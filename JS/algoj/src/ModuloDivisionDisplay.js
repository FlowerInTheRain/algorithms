arrayModulo()

function arrayModulo(){
	const height = 4;
	const width = 14;
	const symbol = "*";
	const strStartsWithSymbol = "True";
// Write an answer using console.log()
// To debug: console.error('Debug messages...');
	let res = [];
	let line = "";
	for(let i = 0; i < height;i++){
		if(strStartsWithSymbol === "True"){
			if(i%2===0){
				for(let j = 0; j < Math.ceil(width/2);j++){
					line = `${symbol} `+ line;
				}
			} else {
				for(let j = 0; j < Math.floor(width/2);j++){
					line = ` ${symbol}`+ line;
				}
			}
		} else {
			if(i%2===0){
				for(let j = 0; j < Math.floor(width/2);j++){
					line = ` ${symbol}`+ line;
				}
			} else {
				for(let j = 0; j < Math.ceil(width/2);j++){
					line = `${symbol} `+ line;
				}
			}
		}
		res.push(line)
		line = ""
	}
	console.error(res)
}