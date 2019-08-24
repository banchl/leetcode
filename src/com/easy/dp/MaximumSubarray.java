package com.easy.dp;

/**
 * LeetCode No53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 *  
 * 题解:
 *      采用动态规划，可以得出到数组中i处的值的和为
 *      截至到i位置的数值的和和0进行比较后加上A[i]，也就是如下公式    
 *      maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i];
 *      这样即可以得出到i处的和就是拿比较得出的值加上了A[i]的值
 *      然后再和之前的最大值进行比较遍历即可得出结果
 *
 *      https://leetcode.com/problems/maximum-subarray/discuss/20193/dp-solution-some-thoughts
 */
public class MaximumSubarray {


    public int maxSubArray1(int[] nums) {
        int maxEnterHere = nums[0], max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxEnterHere = Math.max(maxEnterHere + nums[i], nums[i]);
            max = Math.max(max, maxEnterHere);
        }
        return max;
    }


    public int maxSubArray2(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
