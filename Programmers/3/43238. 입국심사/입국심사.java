
class Solution {
    public long solution(int n, int[] times) {
        int minTime = times[0];
        
        for (int i = 0; i < times.length; i++) {
            if (times[i] < minTime) {
                minTime = times[i];
            }
        }
        
        long right = (long) minTime * n;
        long left = 1;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long processed = 0;
            
            for (int i = 0; i < times.length; i++) {
                processed += mid / times[i];
                
                if (processed >= n) break;
            }
            
            if (processed >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
        
    }
}