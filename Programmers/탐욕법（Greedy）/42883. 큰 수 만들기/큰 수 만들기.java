import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {

            char c = number.charAt(i);

            // deque의 마지막 숫자와 현재 숫자를 비교해서
            // 현재 숫자가 더 크다면 deque에서 제거
            while (k > 0 && !deque.isEmpty() && deque.peekLast() < c) {
                deque.pollLast();
                k--;
            }

            deque.offerLast(c);
        }

        // 숫자가 내림차순으로 정렬되어 있으면 제거 횟수가 남을 수 있으므로,
        // 뒤쪽 숫자부터 제거한다.
        while (k > 0) {
            deque.pollLast();
            k--;
        }

        for (char c : deque) {
            sb.append(c);
        }

        return sb.toString();
    }
    
}