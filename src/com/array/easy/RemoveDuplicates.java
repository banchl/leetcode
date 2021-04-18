package com.array.easy;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){ return 0;}
        int left = 0;
        for(int i = 1; i < nums.length; i++) {
          if(nums[i] != nums[left]) {
            nums[++left] = nums[i];
          }
        }
        return ++left;
    }
}
