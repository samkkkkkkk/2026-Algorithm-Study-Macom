import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        
        boolean[] visited = new boolean[n];
        
        Deque<Integer> dungeonStack = new ArrayDeque<>();
        Deque<Integer> fatigueStack = new ArrayDeque<>();
        Deque<Integer> indexStack = new ArrayDeque<>();
        
        dungeonStack.offerLast(-1);
        fatigueStack.offerLast(k);
        indexStack.offerLast(0);
        
        int answer = 0;
        
        while (!dungeonStack.isEmpty()) {
            
            int dungeon = dungeonStack.peekLast();
            int fatigue = fatigueStack.peekLast();
            int index = indexStack.pollLast();
            
            // 현재 깊이에서 모든 던전 확인 완료
            if (index == n) {
                
                dungeonStack.pollLast();
                fatigueStack.pollLast();
                
                // 탐색 종료 후 방문 상태 복원
                if (dungeon != -1) {
                    visited[dungeon] = false;
                }
                
                continue;
            }
            
            // 다음에 확인할 던전 번호 저장
            indexStack.offerLast(index + 1);
            
            if (visited[index]) {
                continue;
            }
            
            if (fatigue < dungeons[index][0]) {
                continue;
            }
            
            // 던전 방문
            visited[index] = true;
            
            dungeonStack.offerLast(index);
            fatigueStack.offerLast(
                fatigue - dungeons[index][1]
            );
            indexStack.offerLast(0);
            
            answer = Math.max(answer, dungeonStack.size() - 1);
            
        
        }
        
        return answer;
    }
}