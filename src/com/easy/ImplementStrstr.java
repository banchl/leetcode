public class ImplementStrstr {
    public static int strStr(String haystack, String needle) {
        if("".equals(needle)) {
            return 0;
        }
        if(needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        int left = 0;
        int start = -1;
        int fast = 0;
        for(int i = fast; i < haystack.length();) {
            if(haystack.charAt(i) == needle.charAt(left)) {
                if(start == -1) {
                    start = i;
                } 
                left++;
                if(left == needle.length()) {
                    return start;
                }
                i++;
            } else {
                if(start != -1) {
                    start = -1;
                    left = 0;
                    fast++;
                    i = fast;
                } else {
                    i++;
                }
            }
        }
        if(left != needle.length()) {
            return -1;
        }
        return start;
    }

    /**
     * Knuth-Morris-Pratt 算法的核心为前缀函数，记作 \pi(i)π(i)，其定义如下：
     * 对于长度为 mm 的字符串 ss，其前缀函数 \pi(i)(0 \leq i < m)π(i)(0≤i<m) 表示 ss 的子串 s[0:i]s[0:i] 的最长的相等的真前缀与真后缀的长度。
     * 特别地，如果不存在符合条件的前后缀，那么 \pi(i) = 0π(i)=0。其中真前缀与真后缀的定义为不等于自身的的前缀与后缀。
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
 

    
    public static void main(String[] args) {
        String a = "mississippi";
        String b = "issip";
        System.out.println(strStr(a, b));
    }
}