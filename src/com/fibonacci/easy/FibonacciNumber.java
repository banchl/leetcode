package com.fibonacci.easy;


/**
 * 509. Fibonacci Number
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 *
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * 题解：
 *      简单的斐波那契数列,通项公式为：
 *      F(N) = F(N-1) + F(N-2)
 *      可以通过递归或者遍历的方式得出
 */
public class FibonacciNumber {

    public int fib(int N) {
        int i = 0;
        int j = 1;
        int sum = 0;
        for(int k = 0; k<N;k++) {
            sum = i + j;
            j=i;
            i=sum;
        }
        return sum;
    }

    public int fibReursive(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        return fibReursive(N-1) +fibReursive(N-2);
    }

    /**
     * 尾递归的方式
     * 初值为1，0，1，m
     */
    public int climbStairs(int n, int i, int j, int m) {
        if(m<=1) return n;
        n = i + j;
        m--;
        return climbStairs(n, n, i, m);
    }

}
