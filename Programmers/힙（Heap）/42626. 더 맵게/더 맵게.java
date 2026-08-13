import java.util.PriorityQueue;

class Solution{
    public int solution(int[] scoville, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int value : scoville) {
            pq.offer((long) value);
        }
        
        int count = 0;
        
        while (pq.peek() < k) {
            if (pq.size() < 2) {
                return -1;
            } 
            
            long first = pq.poll();
            long second = pq.poll();
            
            long mixed = first + second * 2;
            pq.offer(mixed);
            
            count++;
        }
        
        return count;
        
    }
}