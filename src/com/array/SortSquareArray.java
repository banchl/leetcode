public class SortSquareArray {
    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        if(array == null || array.length == 0) {
            return new int[] {};
        }
        int left = 0;
        int right = array.length - 1;
        for(int i = array.length - 1; i >= 0; i--) {
            int small = array[left];
            int large = array[right];
            // compare array[left] and array[right] because there maybe a negative value
            if(Math.abs(small) > Math.abs(large)){
                result[i] = small * small;
                left++;
            } else {
                result[i] = large * large;
                right--;
            }
        }
        return result;
    }
}
