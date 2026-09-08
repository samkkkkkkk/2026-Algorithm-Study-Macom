import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() &&
                    prices[i] < prices[stack.peekLast()]) {
                int prevIdx = stack.pollLast();
                answer[prevIdx] = i - prevIdx;
            }
            
            stack.offerLast(i);
        }
        
        for (int remainIdx : stack) {
            answer[remainIdx] = prices.length - 1 - remainIdx;
        }
        
        return answer;
    }
}