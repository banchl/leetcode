import java.util.Arrays;
import java.util.List;

class Subsequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int first = 0;
        if(array.size() < sequence.size()) {
            return false;
        }
        for(int i = 0; i<array.size();i++) {
            if(array.get(i) == sequence.get(first)) {
                first++;
                if(first == sequence.size()) {
                    return true;
                }
            }
        }
        return first == sequence.size();
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, -1, 10);
        System.out.println(isValidSubsequence(array, sequence));
    }
}

  