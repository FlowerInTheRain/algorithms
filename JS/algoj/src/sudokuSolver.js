
const inputs =
    [
        [
            "1 2 3 4 5 6 7 8 9",
            "4 5 6 7 8 9 1 2 3",
            "7 8 9 1 2 3 4 5 6",
            "9 1 2 3 4 5 6 7 8",
            "3 4 5 6 7 8 9 1 2",
            "6 7 8 9 1 2 3 4 5",
            "8 9 1 2 3 4 5 6 7",
            "2 3 4 5 6 7 8 9 1",
            "5 6 7 8 9 1 2 3 4"
        ],
        [
            "4 3 5 2 6 9 7 8 1",
            "6 8 2 5 7 1 4 9 3",
            "1 9 7 8 3 4 5 6 2",
            "8 2 6 1 9 5 3 4 7",
            "3 7 4 6 8 2 9 1 5",
            "9 5 1 7 4 3 6 2 8",
            "5 1 9 3 2 6 8 7 4",
            "2 4 8 9 5 7 1 3 6",
            "7 6 3 4 1 8 2 5 9"
        ],
        [
            "4 3 2 2 6 9 7 8 1",
            "6 8 5 5 7 1 4 9 3",
            "1 9 7 8 3 4 5 6 2",
            "8 2 6 1 9 5 3 4 7",
            "3 7 4 6 8 2 9 1 5",
            "9 5 1 7 4 3 6 2 8",
            "5 1 9 3 2 6 8 7 4",
            "2 4 8 9 5 7 1 3 6",
            "7 6 3 4 1 8 2 5 9"
        ],
        [
            "4 3 5 2 6 9 7 8 1",
            "6 8 2 5 7 1 4 9 3",
            "8 9 7 1 3 4 5 6 2",
            "1 2 6 8 9 5 3 4 7",
            "3 7 4 6 8 2 9 1 5",
            "9 5 1 7 4 3 6 2 8",
            "5 1 9 3 2 6 8 7 4",
            "2 4 8 9 5 7 1 3 6",
            "7 6 3 4 1 8 2 5 9"
        ]

    ];

for(let ind = 0; ind < inputs.length;ind++){
    solve(inputs[ind])
}

 export function solve(inputs){
    let grid = [];
    for (let i = 0; i < 9; i++) {
        var input = inputs[i].split(" ");
        grid.push(input);
    }

    let ans = true;
    let res_column = 0;
    let res_row = 0;
     let countRow = 0;
    let countCols = 0;

    for(let i= 0; i < grid.length; i ++){
        for (let j = 0; j < 9; j++) {
            const r = Number(grid[i][j]);
            const c = Number(grid[j][i]);
            res_row += r;
            res_column += c;
            if(j === 8 ){
                if(res_row === 45){
                    countRow++;
                } else {
                    ans = false;
                }
                res_row = 0;
                if(res_column === 45){
                    countCols++;
                } else {
                    ans = false;
                }
                    res_column = 0;
            }
        }
    }

     let areas = new Array(9).fill([]);
     grid.forEach((numbers, idx)=> {
         let segment = Math.floor(idx / 3);
         areas[segment]      = [...areas[segment],     ...grid[idx].slice(0, 3)];
         areas[segment + 3]  = [...areas[segment + 3], ...grid[idx].slice(3, 6)];
         areas[segment + 6]  = [...areas[segment + 6], ...grid[idx].slice(6, 9)];

     })
      areas.forEach(area => {
         ans = ((area.filter((item, index) => area.indexOf(item) !== index).length) !== 0);
         ans = area.reduce((accumulator, currentValue) => {
             return accumulator + Number(currentValue)
         },0) === 45
     });
        return ans;
}
const compute = {
    solve: solve
}