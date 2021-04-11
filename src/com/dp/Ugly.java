import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Ugly {
    public static void main(String[] args) {
        System.out.println(uply2Solution(10));
    }

    public static int uply2Solution(int n) {
        int[] factors = {2,3,5};
        Set<Long> set = new HashSet<>();    
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.offer(1L);
        int uply = 0;
        for(int i = 0; i<n; i++){
            long curr = heap.poll();
            uply = (int) curr;
            for(int j : factors) {
                if(set.add(j*curr)) {
                    heap.offer(j*curr);
                }
            }
        }
        return uply;
    }

    public static int ugly2Solution2(int n) {
        int[] array=new int[n+1];
        array[1] = 1;
        int p2 = 1,p3 = 1,p5 = 1;
        for(int i = 2; i <= n; i++){
            int sum2 = 2*array[p2], sum3 = 3*array[p3], sum5 = 5*array[p5];
            // dp[n] = min(dp[p2]*2, dp[p3]*3, dp[p5]*5)
            array[i] = Math.min(Math.min(sum2, sum3), sum5);
            // dp[n] == dp[p2]*2 p2++ || dp[n] == dp[p3] * 3 p3++ || dp[n] = dp[p5]*5 p5++
            if(array[i] == sum2) {
                p2++;
            }
            if(array[i] == sum3) {
                p3++;
            }
            if(array[i] == sum5) {
                p5++;
            }
        }
        return array[n];
    }
}