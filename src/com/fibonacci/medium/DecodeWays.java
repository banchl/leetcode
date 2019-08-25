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
 * ��⣺
 *      ��n���Ŀ����ַ�����ϵ��ڵ�n-1�����ַ�����ϼ��ϵ�n-2���ַ������
 *      Ҳ���� numDecodings(n, i) = numDecodings(n, i -1) + numDecodings(n, i - 2);
 *      �����������ж�������
 *      1.numDecodings(n, i-1)���ִ�����ֵ��1��9֮�䣬����Ϊ0������Ϊ0
 *      2.numDecodings(n, i-2)���ִ�����ֵ��10��26֮�䣬����Ϊ0
 *      ͬʱ���쳲��������еĻ���Ҫ�ж�n=1ʱ�ַ����Ƿ�Ϊ0����Ϊ0��ֵͨ��Ϊ0��
 *      1��0/1��1/2��1/3...ͬʱ�ڼ����м���ʱ��Ҫ�ж��ִ��Ƿ�Ϊ0���Ƿ����26
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
