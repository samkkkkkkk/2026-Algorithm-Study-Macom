import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new ArrayDeque<>();       
        boolean[] visited = new boolean[words.length];
        int dist = 0;
        
        queue.offer(begin);        
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
               String current = queue.poll();
                
                if (current.equals(target)) {
                    return dist;
                }
                
                for (int j = 0; j < words.length; j++) {
                    if (visited[j]) continue;
                    
                    int diffCount = 0;
                    
                    for (int k = 0; k < current.length(); k++) {
                        if (current.charAt(k) != words[j].charAt(k)) diffCount++;
                        if (diffCount > 1) break;
                    }
                    
                    if (diffCount == 1) {
                        visited[j] = true;
                        queue.offer(words[j]);
                    }
                    
                }
                
            }
            
            dist++;
        }
        
        return 0;
             
    }
}