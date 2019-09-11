package com.medium.bit;

/**
 * {LeetCode No.137. Single Number II}
 *
 *
 *
 * 题解：
 *      在给定的数组中找两个只出现一次的数字<p>
 *      通过两次遍历数组求解
 *      在第一次遍历中，对数组中所有元素做异或操作(XOR),最终得到需要找出的两个数的xor操作结果
 *      由于找出的两个数是不同的，因此他们的xor结果中必有一组1，找出任意一位设置1，如最右侧
 *      在第二次遍历过程中，将所有数组划分成两组，一组使用上面设置过1的数字，另一组未设置，
 *      这样两个不同的数字即可最终在两个不同的分组中找出
 */
public class RomanToInteger {

    public int[] singleNumber(int[] nums) {
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
