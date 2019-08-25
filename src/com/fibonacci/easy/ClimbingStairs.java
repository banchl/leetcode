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
 * ���:
 *      ����̨��N�Ĳ��������ַ�����һ��Ϊ��N-1��̨�׿�һ����һ��Ϊ��N-2��̨�׿�����
 *      ���ǿ��Խ��仮�ֳ��������⼴��
 *      1.��N-1��̨���ж������߷�
 *      2.��N-2��̨���ж������߷�
 *      ������ͨ�ʽ����쳲��������м���
 *      F(N)=F(N-1)+F(N-2)
 *      ������Ϊ�ڵڶ����������߷���ˣ�����N=2Ϊ2
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
