import java.util.*;

public class Main {
    static long N, P, Q;
    static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        P = sc.nextLong();
        Q = sc.nextLong();
        sc.close();

        System.out.println(getValue(N));
    }

    static long getValue(long i) {
        if (i == 0) return 1; // A0 = 1
        if (memo.containsKey(i)) return memo.get(i); // 이미 계산된 값이면 반환

        // 점화식 적용: Ai = A⌊i/P⌋ + A⌊i/Q⌋
        long value = getValue(i / P) + getValue(i / Q);
        memo.put(i, value); // 계산 결과 저장
        return value;
    }
}
