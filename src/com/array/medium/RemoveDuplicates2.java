package com.array.medium;

/**
 * 80. Remove Duplicates from Sorted Array II
 */
public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        // int left = 0;
        // int right = 0;
        int n = nums.length;
        if(nums.length <= 2) {
          return n;
        }
        // while(right < nums.length - 1) {
        //   if(nums[right] == nums[left]) {
        //     if(right - left <= 2) {
        //       nums[++left] = nums[right];
        //     }
        //   }
        //   right++;
        // } 
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
      }
}
