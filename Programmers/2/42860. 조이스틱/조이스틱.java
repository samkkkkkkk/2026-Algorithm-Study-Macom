class Solution {
    public int solution(String name) {
        int n = name.length();
        int minMove = n - 1;
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int next = i + 1;
            
            while (next < n &&
                    name.charAt(next) == 'A') {
                next++;
            }
            
            minMove = Math.min(minMove, Math.min(i * 2 + n - next, i + 2 * (n - next)));
        }
        
        answer += minMove;
        return answer;
    }
}