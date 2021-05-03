/**
 * 7. Reverse Integer
 */
public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
          int tmp = x % 10;
          if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && tmp > 7)) {
            return 0;
          }
          if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 && tmp > 8)) {
            return 0;
          }
          res = res*10 + tmp;
          x = x / 10;
        }
        return res;
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
