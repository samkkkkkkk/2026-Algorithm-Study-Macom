import java.util.Arrays;

public class Solution {
    public int[] solution(int []arr) {
        int[] result = new int[arr.length];
        int size = 0;
        
        result[0] = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (result[size] != arr[i]) {
                result[size + 1] = arr[i];
                size++;
            }
        }
        
        return Arrays.copyOf(result, size + 1);
    }
}