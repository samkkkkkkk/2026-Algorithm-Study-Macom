import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static int solution(int N, int number) {

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        int connected = 0;

        for (int i = 1; i <= 8; i++) {

            connected = connected * 10 + N;
            dp.get(i).add(connected);

            for (int j = 1; j < i; j++) {

                Set<Integer> left = dp.get(j);
                Set<Integer> right = dp.get(i - j);

                for (int a : left) {
                    for (int b : right) {

                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);

                        if (b != 0) {
                            dp.get(i).add(a / b);
                        }
                    }
                }

            }

            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}