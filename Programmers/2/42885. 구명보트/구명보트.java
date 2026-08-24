import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        
        int left = 0;
        int right = people.length - 1;
        int cnt = 0; 
        
        Arrays.sort(people);

        while (left <= right) {
            
            cnt++;
            int weight = people[left] + people[right];

            if (weight <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            
        }
        
        return cnt;
    }
}