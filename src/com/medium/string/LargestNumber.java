package leetcode.src.com.medium.string;

import java.util.Arrays;

public class LargestNumber {

    public static String largestNumber(int[] nums) {
        String[] numS = new String[nums.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            numS[i] = "" + nums[i];
        }
        Arrays.sort(numS, (a, b) -> (b + a).compareTo(a + b));
        if (numS[0].equals("0")) {
            return "0";
        }
        for (int i = 0; i < numS.length; i++) {
            sb.append(numS[i]);
        }
        return sb.toString();
    }


    public static String largestNumber2(int[] nums) {
        int n = nums.length;
        Integer[] numIntegers = new Integer[n];
        for(int i = 0; i < n; i++) {
            numIntegers[i] = nums[i];
        }
        // 
        Arrays.sort(numIntegers, (a, b) -> {
            long sx = 10, sy = 10;
            while(sx  <= a) {
                sx *= 10;
            }
            while(sy <= b) {
                sy *= 10;
            }
            // sy * a + b > sx * b + a
            return (int)(-sy * a - b + sx * b + a);
        });
        if(numIntegers[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int num : numIntegers) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 30, 34, 5, 9 };
        System.out.println(largestNumber(nums));
    }
}
