import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken()); // 서류 등수
                arr[i][1] = Integer.parseInt(st.nextToken()); // 면접 등수
            }

            Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
            int count = 1; // 첫 번째 지원자는 무조건 선발
            int min = arr[0][1];
            
            for (int i = 1; i < N; i++) {
                if (arr[i][1] < min) {
                    count++; // 면접 순위가 현재까지 본 사람들보다 낮다면 선발 가능
                    min = arr[i][1];
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
