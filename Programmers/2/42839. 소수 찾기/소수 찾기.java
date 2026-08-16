import java.util.HashSet;

class Solution {

    // 만들어진 숫자의 중복 제거
    HashSet<Integer> set = new HashSet<>();

    // 종이 조각 사용 여부 관리
    boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];

        // DFS + 백트래킹으로 만들 수 있는 모든 숫자 생성
        dfs(numbers, 0);

        // 생성된 숫자를 순회하며 소수 개수 계산
        int count = 0;
        for (int i : set) {
            if (isPrime(i)) count++;
        }

        return count;

    }

    // 현재까지 만든 숫자(current)에 
    // 사용하지 않은 숫자를 하나씩 붙여 모든 경우 탐색
    private void dfs(String numbers, int current) {

        for (int i = 0; i < numbers.length(); i++) {
            // 이미 사용한 종이 조각이면 건너뛰기
            if (visited[i]) continue;

            // 현재 종이 조각 사용 처리
            visited[i] = true;
            
            // 현재 숫자 뒤에 선택한 숫자를 붙여 새로운 숫자 생성
            // 재귀 호출이 끝난 뒤에 다른 경우를 탐색할 때
            // 부모 호출의 current 값을 유지해야 되기 때문에 current를 직접 변경하지 않음
            int next = current * 10 + (numbers.charAt(i) - '0');

            // set에 저장해서 중복 제거
            set.add(next);

            // 현재 숫자에서 다음 종이 조각 선택
            dfs(numbers, next);

            // 백트래킹
            visited[i] = false;
            
        }
    }

    private boolean isPrime(int number) {

        // 0, 1 처리하기
        if (number < 2) return false;

        // 소수 판별
        // 모든 약수를 점검할 필요 없이 제곱근까지만 점검
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}