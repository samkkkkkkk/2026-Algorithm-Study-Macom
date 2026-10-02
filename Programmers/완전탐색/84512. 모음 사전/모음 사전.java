class Solution {

    private final char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    private int count = 0;
    private int answer = 0;
    
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    
    private void dfs (String current, String word) {
        
        if (!current.isEmpty()) {
            count++;
        }
        
        if (current.equals(word)) {
            answer = count;
            return;
        }
        
        if (current.length() == 5) {
            return;
        }
        
        for (char vowel : vowels) {
            dfs(current + vowel, word);
        }
    }
}