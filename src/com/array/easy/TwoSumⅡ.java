package com.array.easy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * {@code LeetCode No167. Two Sum II - Input array is sorted}
 * <p>
 * 
 * 题解:<p>
 * 
 *      在升序的数组中找出两个下标值相加等于给定值<p>
 *      由于是升序数组，因此最简单的做法就是采取渐进法，取左右两边值相加<p>
 *      如果出现值大的情况则缩小右边的下标，反之则增加左边的下标直至找到所求
 */
public class TwoSumⅡ {

    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 0) return new int[2];
        int[] result = new int[2];
        int a = 0, b=numbers.length -1;
        while(a < b) {
            int num = numbers[a]+numbers[b];
            if(num == target) {
                result[0] = a + 1;
                result[1] = b + 1;
                break;
            } else if(num > target) {
                b--;
            } else {
                a++;
            }
        }
        return result;
    }
}
