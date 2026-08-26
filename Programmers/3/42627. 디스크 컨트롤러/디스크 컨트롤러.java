import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public int solution(int[][] jobs) {

        // task[0] = 작업 번호
        // task[1] = 요청 시각
        // task[2] = 소요 시간
        int[][] tasks = new int[jobs.length][3];

        for (int i = 0; i < jobs.length; i++) {
            tasks[i][0] = i;
            tasks[i][1] = jobs[i][0];
            tasks[i][2] = jobs[i][1];
        }

        // 요청 시각 기준으로 정렬
        Arrays.sort(tasks, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        // 대기 큐
        // 1. 소요 시간
        // 2. 요청 시각
        // 3. 작업 번호
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) {
                return Integer.compare(a[2], b[2]);
            } else if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int currentTime = 0;
        int index = 0;
        int completed = 0;

        long total = 0;

        while (completed < tasks.length) {

            // 현재 시각까지 요청된 모든 작업을 대기 큐에 추가
            while (index < tasks.length
                    && tasks[index][1] <= currentTime) {

                pq.offer(tasks[index]);
                index++;
            }

            // 현재 처리 가능한 작업이 없는 경우
            // 다음 작업 요청 시각으로 이동
            if (pq.isEmpty()) {
                currentTime = tasks[index][1];
                continue;
            }

            // 가장 우선순위가 높은 작업 실행
            int[] currentJob = pq.poll();

            int requestTime = currentJob[1];
            int duration = currentJob[2];

            // 작업 종료 시각으로 이동
            currentTime += duration;

            // 반환 시간 = 작업 종료 시각 - 요청 시각
            total += currentTime - requestTime;

            completed++;
        }

        return (int) (total / jobs.length);
    }
}