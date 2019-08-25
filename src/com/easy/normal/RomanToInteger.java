package com.easy.normal;

/**
 * LeetCode No.13. Roman to Integer
 *
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * 题解：
 *      这个很简单，就是比较当前位和后一位的大小，如果当前位比后一位小，则将当前位加上的值置为负数
 *      或者比较当前位和前一位的大小，如果比前一位大，就将当前位的值减去前一位的值
 */
public class RomanToInteger {


    public int romanToIntFast(String s) {
        int totalValue = 0;
        int nextValue = 0;
        int currentValue = 0 ;

        for (int i=0; i < s.length()-1; i++){
            currentValue = getValueOfTheLetter(s.charAt(i));
            nextValue = getValueOfTheLetter(s.charAt(i+1));

            if(nextValue > currentValue){
                currentValue *= (-1);
            }
            totalValue += currentValue;
        }


        return totalValue + getValueOfTheLetter(s.charAt(s.length()-1));
    }

    /**
     * The "letter" s roman numeral value is returned as int
     * @param letter
     * @return
     */

    public int getValueOfTheLetter(char letter){
        switch (letter) {
            case 'I':
                return  1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        throw new IllegalArgumentException("This letter is not a roman numeral");
    }


    public static int romanToInt(String s) {
        int num = 0;
        char[] ch = s.toCharArray();
        for (int i = 0;i <= ch.length - 1; i++) {
            if (i == 0) {
              switch (ch[i]) {
                  case 'I':
                      num += 1;
                      continue;
                  case 'V':
                      num += 5;
                      continue;
                  case 'X':
                      num += 10;
                      continue;
                  case 'L':
                      num += 50;
                      continue;
                  case 'C':
                      num += 100;
                      continue;
                  case 'D':
                      num += 500;
                      continue;
                  case 'M':
                      num += 1000;
                      continue;
                  default:
              }
            } else {
                switch (ch[i]) {
                    case 'I':
                        num += 1;
                        continue;
                    case 'V':
                        if (ch[i - 1] == 'I') {
                            num += 3;
                        } else {
                            num += 5;
                        }
                        continue;
                    case 'X':
                        if (ch[i - 1] == 'I') {
                            num += 8;
                        } else {
                            num += 10;
                        }
                        continue;
                    case 'L':
                        if (ch[i - 1] == 'X') {
                            num += 30;
                        } else {
                            num += 50;
                        }
                        continue;
                    case 'C':
                        if (ch[i - 1] == 'X') {
                            num += 80;
                        } else {
                            num += 100;
                        }
                        continue;
                    case 'D':
                        if (ch[i - 1] == 'C') {
                            num += 300;
                        } else {
                            num += 500;
                        }
                        continue;
                    case 'M':
                        if (ch[i - 1] == 'C') {
                            num += 800;
                        } else {
                            num += 1000;
                        }
                        continue;
                    default:
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
