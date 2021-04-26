import java.util.Arrays;

public class ShipWithinDays {
    

    public static int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while(left < right) {
            int middle = (left + right)/2;
            int need = 1;
            int curr = 0;
            for (int i = 0; i < weights.length; i++) {
                if(curr + weights[i] > middle) {
                    ++need;
                    curr = 0;
                }
                curr += weights[i];
            }
            if(need <= D) {
                right = middle;
            } else { 
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] weigts = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(weigts, 5));
    }
}
