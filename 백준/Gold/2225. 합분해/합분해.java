import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        int[][] dp = new int[K + 1][N + 1];
 
        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int k = 2; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                for (int j = 0; j <= n; j++) {
                    dp[k][n] = (dp[k][n] + dp[k - 1][j]) % MOD;
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}
