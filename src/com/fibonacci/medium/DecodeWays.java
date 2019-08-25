package com.fibonacci.medium;

/**
 * 91. Decode Ways
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * 题解：
 *      到n处的可能字符串组合等于到n-1处的字符串组合加上到n-2处字符串组合
 *      也就是 numDecodings(n, i) = numDecodings(n, i -1) + numDecodings(n, i - 2);
 *      但是有两个判断条件是
 *      1.numDecodings(n, i-1)中字串的数值在1到9之间，不能为0，否则为0
 *      2.numDecodings(n, i-2)中字串的数值在10到26之间，否则为0
 *      同时类比斐波那契数列的话需要判断n=1时字符串是否为0，若为0则值通项为0即
 *      1，0/1，1/2，1/3...同时在计算中间项时需要判断字串是否为0和是否大于26
 */
public class DecodeWays {

    public static int numDecodings1(String s) {
        if (s == null) return 0;
        int[] num = new int[s.length()+1];
        num[0] = 1;
        num[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i=2; i<=s.length();i++) {
            int c = Integer.valueOf(s.substring(i- 1, i));
            int l = Integer.valueOf(s.substring(i -2, i));
            if (c>=1 && c <=9) {
                num[i] += num[i-1];
            }
            if (l>=10 && l<=26) {
                num[i] += num[i-2];
            }
        }
        return num[s.length()];
    }

    public int numDecodings2(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int n0 = 1;
        int n1 = 1;
        for (int i = 1; i < s.length(); i++) {
            int n2 = 0;
            if (s.charAt(i) != '0') {
                n2 += n1;
            }
            int cur = Integer.parseInt(s.substring(i-1, i+1));
            if (10 <= cur && cur <= 26) {
                n2 += n0;
            }
            n0 = n1;
            n1 = n2;
        }
        return n1;
    }

    public static void main(String[] args) {
        int num = numDecodings1("226");
        System.out.println(num);
    }
}
