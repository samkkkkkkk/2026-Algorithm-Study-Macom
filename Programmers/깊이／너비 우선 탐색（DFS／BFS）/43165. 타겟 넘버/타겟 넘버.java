class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
        private int dfs(int[] numbers, int target, int idx, int total) {
        // 기저 조건
        if (idx == numbers.length) {
            // 누적된 합이 타겟 넘버와 같다면 1, 다르면 0
            return total == target ? 1 : 0;
        }

        // 현재 숫자를 더하는 경우
        int addCase = dfs(numbers, target, idx + 1, total + numbers[idx]);

        // 현재 숫자를 빼는 경우
        int subCase = dfs(numbers, target, idx + 1, total - numbers[idx]);

        // 두 경우의 수 합산
        return addCase + subCase;
    }
}