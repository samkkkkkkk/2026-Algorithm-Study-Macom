
class Solution {
    public int[] solution(int[] answers) {
                
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            
            if (person1[i % person1.length] == answers[i]) {
                scores[0] += 1;
            }
            
            if (person2[i % person2.length] == answers[i]) {
                scores[1] += 1;
            }
            
            if (person3[i % person3.length] == answers[i]) {
                scores[2] += 1;
            }
        }
        
        int maxScore = scores[0];
        
        for (int score : scores) {
            maxScore = Math.max(maxScore, score);
        }
        
        int answerSize = 0;
        
        for (int score : scores) {
            if (score == maxScore) answerSize++;
        }
        
        int[] answer = new int[answerSize];
        
        int answerIndex = 0;
        
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer[answerIndex] = i + 1;
                answerIndex++;
            }
        }
        
        return answer;

    }
}