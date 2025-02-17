import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp = new int[41][2];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;
        
        for (int i = 2; i <= 40; i++) { // 미리 피보나치 값 저장
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
        }

        System.out.println(sb);
    }
}
