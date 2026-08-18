import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;

        // priorities를 queue로 변환 -> 우선순위와 원래 위치를 함께 저장
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }

        // queue의 맨 앞 프로세스를 꺼낸다.
        // 대기중인 프로세스 중 우선순위가 높은 프로세스가 있는지 확인
        // 높은 우선순위가 있다 -> 현재 프로세스를 queue 뒤에 다시 삽입
        // 높은 우선순위가 없다 -> 현재 프로세스를 실행 -> count++
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean flag = false;

            for (int[] process : queue) {
                if (current[0] < process[0]) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                queue.offer(current);
            } else {
                count++;
                
                // 실행한 프로세스의 원래 위치가 location과 일치하면 count 반환
                if (current[1] == location) {
                    return count;
                }
            }
        }
        
        return count;

    }
    
}