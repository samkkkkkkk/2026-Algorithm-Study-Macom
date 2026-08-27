import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        
        long minTime = Arrays.stream(times)
                .min()
                .getAsInt();
        
        long left = minTime;
        long right = minTime * n;
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;

            for (int time : times) {
                count += mid / time;

                if (count >= n) {
                    break;
                }
            }

            if (count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}