import java.util.Arrays;


class Solution {
    public String solution(int[] numbers) {
        String[] numToString = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numToString[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numToString, (a, b) -> (b + a).compareTo(a + b));

        if (numToString[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : numToString) {
            sb.append(s);
        }

        return sb.toString();
    }

}