import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int[] cut : wires) {
            
            int cutA = cut[0];
            int cutB = cut[1];
            
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new ArrayDeque<>();
            
            queue.offer(cutA);
            visited[cutA] = true;
            
            int count = 0;
            
            while (!queue.isEmpty()) {
                int current = queue.poll();
                count++;
                
                for (int next : graph.get(current)) {
                    if ((current == cutA && next == cutB)
                            || (current == cutB && next == cutA)) {
                        continue;
                    }
                    
                    if (visited[next]) {
                        continue;
                    }
                    
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            
            int otherCount = n - count;
            int diff = Math.abs(count - otherCount);
            
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
}