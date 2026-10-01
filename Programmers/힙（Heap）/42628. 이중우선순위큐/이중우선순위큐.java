import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        boolean[] visited = new boolean[operations.length];

        for (int i = 0; i < operations.length; i++) {
            String[] op = operations[i].split(" ");
            int n = Integer.parseInt(op[1]);

            if (op[0].equals("I")) {
                int[] node = {n, i};
                min.offer(node);
                max.offer(node);
            } else {
                PriorityQueue<int[]> heap = n == 1 ? max : min;

                clean(heap, visited);

                if (!heap.isEmpty()) {
                    visited[heap.poll()[1]] = true;
                }
            }
        }

        clean(min, visited);
        clean(max, visited);

        return min.isEmpty()
            ? new int[]{0, 0}
            : new int[]{max.peek()[0], min.peek()[0]};
    }

    private void clean(PriorityQueue<int[]> heap, boolean[] visited) {
        while (!heap.isEmpty() && visited[heap.peek()[1]]) {
            heap.poll();
        }
    }
}