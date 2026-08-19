import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        // 의상 종류별 개수 계산
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int answer = 1;

        // 각 종류마다 해당 종류를 입는 경우 + 입지 않는 경우를 계산
        for (int count : map.values()) {
            answer *= (count + 1);
        }

        // 아무 의상도 입지 않는 경우 제외
        return answer - 1;
    }
    
}