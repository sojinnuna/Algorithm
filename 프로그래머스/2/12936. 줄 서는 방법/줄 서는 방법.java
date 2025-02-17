import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(i);

        int[] answer = new int[n];
        long fact = 1;

        // (n-1)! 팩토리얼 계산
        for (int i = 1; i < n; i++) fact *= i;

        k--; // 인덱스 보정
        for (int i = 0; i < n; i++) {
            int index = (int) (k / fact);
            answer[i] = numbers.get(index);
            numbers.remove(index);

            if (i < n - 1) {
                k %= fact;
                fact /= (n - 1 - i);
            }
        }

        return answer;
    }
}
