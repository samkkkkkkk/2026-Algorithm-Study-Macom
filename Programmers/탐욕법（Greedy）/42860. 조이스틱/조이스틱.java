class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;
        int minMove = n - 1;
        
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
            
            int next = i + 1;
            
            while (next < n &&
                    name.charAt(next) == 'A') {
                next++;
            }
            
            minMove = Math.min(minMove, Math.min(2 * i + n - next, i + 2 * (n - next)));
        }
        
        return answer + minMove;
    }
}