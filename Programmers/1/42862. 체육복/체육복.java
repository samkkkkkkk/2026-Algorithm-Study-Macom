import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    reserve[j] = 0;
                    lost[i] = 0;
                    break;
                }
            }
        }
        
        for (int i = 0; i < reserve.length; i++) {
            if (reserve[i] == 0) {
                continue;
            }
            for (int j = 0; j < lost.length; j++) {
                if (lost[j] == 0) {
                    continue;
                }
                
                if (reserve[i] - 1 == lost[j]) {
                    answer++;
                    reserve[i] = 0;
                    lost[j] = 0;
                    break;
                }
                
                if (reserve[i] + 1 == lost[j]) {
                    answer++;
                    reserve[i] = 0;
                    lost[j] = 0;
                    break;
                }
                
                
            }
        }
        
        return answer;
    }
}