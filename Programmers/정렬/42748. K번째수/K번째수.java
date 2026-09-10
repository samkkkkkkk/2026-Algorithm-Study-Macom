import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int commandIndex = 0; commandIndex < commands.length; commandIndex++) {
            int start = commands[commandIndex][0];
            int end = commands[commandIndex][1];
            int target = commands[commandIndex][2];
            
            int[] sliced = Arrays.copyOfRange(array, start - 1, end);
            
            Arrays.sort(sliced);
            
            answer[commandIndex] = sliced[target - 1];
        }
        
        return answer;
    }
}