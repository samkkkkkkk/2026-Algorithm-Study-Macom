import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[][] tickets) {
        
        Deque<String> stack = new ArrayDeque<>();
        Deque<String> route = new ArrayDeque<>();
        
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
    
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(
                ticket[0],
                k -> new PriorityQueue<>()
            ).offer(ticket[1]);
        }

        stack.offerLast("ICN");
        
        while (!stack.isEmpty()) {
            String current = stack.peekLast();
            PriorityQueue<String> nextAirports = graph.get(current);
            
            if (nextAirports == null || nextAirports.isEmpty()) {
                stack.pollLast();
                route.offerFirst(current); 
            } else {
                stack.offerLast(nextAirports.poll());
            }
        }
        
        return route.toArray(new String[0]);
    }
}