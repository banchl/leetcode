package com.easy.fibonacci;

/**
 * 70. Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * 题解:
 *      到达台阶N的步数有两种方法，一种为从N-1级台阶跨一步，一种为从N-2级台阶跨两步
 *      于是可以将其划分成两个问题即：
 *      1.到N-1级台阶有多少种走法
 *      2.到N-2级台阶有多少种走法
 *      于是其通项公式很像斐波那契数列即：
 *      F(N)=F(N-1)+F(N-2)
 *      但是因为在第二步有两种走法因此，他的N=2为2
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }


    public int climbStairsLoop(int n) {

        if(n<=1) return 1;
        int i = 1;
        int j = 1;
        int result = 0;
        for (int k = 0;k < n; k++) {
            result = i + j;
            j = i;
            i = result;
        }
        return result;

    }
}
