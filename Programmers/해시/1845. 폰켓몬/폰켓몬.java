import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> types = new HashSet<>();
        
        for (int n : nums) {
            types.add(n);
        }
        
        return Math.min(nums.length / 2, types.size());
    }
}