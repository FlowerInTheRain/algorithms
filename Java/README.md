## Solved 

<style>
e {color:#807fcd;}
</style>

[Binary Gap](https://app.codility.com/programmers/lessons/1-iterations/binary_gap/)



<e> A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones 
at both ends in the binary representation of N.</e>  
<br/>
<br/>



<e> For example, number 9 has binary representation 1001 and contains a binary gap of length 2.</e>

<e>The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of 
length 3. </e>

<e>The number 20 has binary representation 10100 and contains one binary gap of length 1.</e>

<e>The number 15 has binary representation 1111 and has no binary gaps. </e>

<e>The number 32 has binary representation 100000 and has no binary gaps.</e>

### Write a function:

> class Solution { public int solution(int N); }

<e>that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N 
</e> 

<e>doesn't contain a binary gap. </e>

<e>For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so  
</e> 

<e>its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary 
representation '100000' and thus no binary gaps.</e>

Write an efficient algorithm for the following assumptions:

> N is an integer within the range [1..2,147,483,647]


[Cyclic rotation](https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/)



<e>An array A consisting of N integers is given. </e>

<e>Rotation of the array means that each element is shifted right by one index, and the last element of the array is 
moved to the first place. </e>

<e>For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one 
index and 6 is moved to the first place).</e>

<e>The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.</e>

### Write a function:

> class Solution { public int[] solution(int[] A, int K); }

<e>that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.</e>

<e>For example, given</e>

<e>A = [3, 8, 9, 7, 6]</e>

<e>K = 3</e>

<e>the function should return [9, 7, 6, 3, 8]. Three rotations were made:</e>

<e>[3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]</e>

<e>[6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]</e>

<e>[7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]</e>


<e>For another example, given</e>

<e>A = [0, 0, 0]</e>

<e>K = 1</e>

<e>the function should return </e>

<e>[0, 0, 0]</e>

<e>Given</e>

<e>A = [1, 2, 3, 4]</e>

<e>K = 4</e>

<e>the function should return [1, 2, 3, 4]</e>

<e>Assume that:</e>


> N and K are integers within the range [0..100];
> each element of array A is an integer within the range [−1,000..1,000].