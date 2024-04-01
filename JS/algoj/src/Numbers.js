function smallestBiggest(){
	let n =5
	let m = 3
	let arr = [1,2,3,4,8,9];
	console.log(Math.min(...arr))
	console.log(Math.max(...arr))
	
	let smallest = "1"
	let biggest = ""
	let b = 9;
	let a = 0;
	for(let i =0; i < n;i++){
		if (i === 0) {
			for(let j =0; j <= n-m;j++){
				biggest = biggest +b.toString()
			}
			b--;
		} else if(i === 1){
			for(let j =0; j <= n-m;j++){
				if(smallest.length < n){
					smallest = smallest +String(a)
					
				}
			}
			biggest = biggest + String(b)
			a+=2
			b--
		} else {
			if(smallest.length < n){
				smallest = smallest +String(a)
				
			}
			if(biggest.length < n){
				biggest = biggest +String(b)
				
			}
			b--
			a++
		}
	}
	console.log(Math.pow(2, 39) - 1)
}

