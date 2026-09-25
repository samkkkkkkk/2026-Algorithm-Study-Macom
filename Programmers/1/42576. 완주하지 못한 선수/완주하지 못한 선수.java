import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String s : completion) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) - 1);
            }
        }
        for (String s : map.keySet()) {
            if (map.get(s) > 0) {
                return s;
            }
        }
        return null;
    }
}