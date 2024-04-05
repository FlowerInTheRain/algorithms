## Solved 
<style>
c {color:#807fcd;}
</style>
[Buzzle](https://www.codingame.com/ide/puzzle/buzzle)

<c> Buzzle is a funny little math game about multiples.</c>

<c>Here were added some difficulty levels which add more rules and make it more complex.</c>

[Frog By The River](https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/)

<c>A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river 
(position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

<c>You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

<c>The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

<c>For example, you are given integer X = 5 and array A such that:

A[0] = 1

A[1] = 3

A[2] = 1

A[3] = 4

A[4] = 2

A[5] = 3

A[6] = 5

A[7] = 4

<c>In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

<c>Write a function:

    class Solution { public int solution(int X, int[] A); }

<c>that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

<c>If the frog is never able to jump to the other side of the river, the function should return −1.

<c>For example, given X = 5 and array A such that:
A[0] = 1
A[1] = 3
A[2] = 1
A[3] = 4
A[4] = 2
A[5] = 3
A[6] = 5
A[7] = 4

<c>the function should return 6, as explained above.

<c>Write an efficient algorithm for the following assumptions:

        N and X are integers within the range [1..100,000];
        each element of array A is an integer within the range [1..X].

[LightBulbs](https://www.codingame.com/training/medium/light-bulbs)

<c>You are given a row of N light bulbs, represented by a string of 0 or 1, totally N characters in the string.
0 means the light bulb is OFF.
1 means the light bulb is ON.

<c>The left-most character is light bulb 1.
The right-most character is light bulb N.

<c>Each light bulb has an independent switch allowing you to switch it ON or OFF.

<c>To switch ON/OFF any light bulb, there are two rules:

<c>Rule 1 You can change the state of light bulb i if i+1 is ON AND i+2, i+3,... N are OFF.
Rule 2 Rule 1 does not apply to light bulb N, which can be switched ON/OFF at will.

<c>The game starts with a given lighting pattern.
You will also have a target lighting pattern.

<c>Find the minimum number of switches needed to change the pattern from start to target.</c>

