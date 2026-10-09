import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(1);
        dist[1] = 0;
        
        int maxDist = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph.get(current)) {
                
                if (dist[next] != -1) {
                    continue;
                }
                
                dist[next] = dist[current] + 1;
                maxDist = Math.max(maxDist, dist[next]);
                
                queue.offer(next);
            }
        }
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) {
                answer++;
            }
        }
        
        return answer;
        
    }
}