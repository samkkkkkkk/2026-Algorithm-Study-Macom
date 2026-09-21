import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int k, int[][] dungeons) {
        
        Deque<List<Integer>> pathStack = new ArrayDeque<>();
        Deque<Integer> fatigueStack = new ArrayDeque<>();
        
        pathStack.offerLast(new ArrayList<>());
        fatigueStack.offerLast(k);
        
        int answer = 0;
        
        while (!pathStack.isEmpty()) {
            
            List<Integer> current = pathStack.pollLast();
            int fatigue = fatigueStack.pollLast();
            
            answer = Math.max(answer, current.size());
            
            for (int i = dungeons.length - 1; i >= 0; i--) {
                if (current.contains(i)) {
                    continue;
                }
                
                if (fatigue < dungeons[i][0]) {
                    continue;
                }
                
                List<Integer> next = new ArrayList<>(current);
                next.add(i);
                pathStack.offerLast(next);
                
                fatigueStack.offerLast(
                    fatigue - dungeons[i][1]
                );
            }
        }
        
        return answer;
    }
}