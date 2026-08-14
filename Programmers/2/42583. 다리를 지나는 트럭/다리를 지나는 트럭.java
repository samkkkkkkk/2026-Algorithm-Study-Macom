import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new ArrayDeque<>();
        
        int time = 0;
        int currentWeight = 0;
        int truckIndex = 0;
        
        while (truckIndex < truck_weights.length || !bridge.isEmpty()) {
            time++;
            
            // 다리에서 나갈 트럭 확인
            if (!bridge.isEmpty() && bridge.peek()[1] == time) {
                int[] truck = bridge.poll();
                currentWeight -= truck[0];
            }
            
            // 다음 트럭이 올라올 수 있는지 확인
            if (truckIndex < truck_weights.length) {
                int nextTruck = truck_weights[truckIndex];
                
                if (currentWeight + nextTruck <= weight) {
                    currentWeight += nextTruck;
                    
                                    
                    bridge.offer(new int[]{nextTruck, time + bridge_length});
                    truckIndex++;
                
                }

            }
        }
        return time;
    }
    
}
