import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] costs) {
        
        int[] parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(
            costs,
            (a, b) -> Integer.compare(a[2], b[2])
        );
        
        int answer = 0;
        int count = 0;
        
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int bridge = cost[2];
            
            int rootA = a;
            while (parent[rootA] != rootA) {
                rootA = parent[rootA];
            }
            
            int rootB = b;
            while (parent[rootB] != rootB) {
                rootB = parent[rootB];
            }
            
            if (rootA == rootB) {
                continue;
            }
            
            parent[rootB] = rootA;
            
            answer += bridge;
            count++;
            
            if (count == n - 1) {
                break;
            }
        }
        
        return answer;
        
    }
}