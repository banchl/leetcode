package com.easy.normal;

/**
 * {LeetCode No.136. Single Number}
 *
 *
 *
 * 题解：
 *      在给定的数组中找只出现一次的数字<p>
 *      这里主要使用xor运算符，异或运算内容为以下<p>
 *      1.0 ^ N = N
 *      2.N ^ N = 0
 *      因此在循环一遍数组之后即可找出唯一一个出现一次的数字<p>
 *      
 */
public class RomanToInteger {

    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0;i<nums.length;i++) {
            result ^= nums[i];
        }
        return result;
    }
}
