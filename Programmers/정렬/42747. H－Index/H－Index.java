import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // 논문 인용 횟수 오름차순 정렬
        // i 번째 이후의 논문은 citations[i] 이상 인용 되었음을 보장
        Arrays.sort(citations);

        int n = citations.length;
        
     
        for (int i = 0; i < n; i++) {
            // 현재 논문 포함 남아있는 논문 수 h
            int h = n - i; 
            
            // 오름차순 정렬되어 있으므로 현제 인덱스의 인용 횟수가 h이상 되는 순간 최댓값
            if (citations[i] >= h) {
                return h; 
            }
        }

        return 0;
    }
}