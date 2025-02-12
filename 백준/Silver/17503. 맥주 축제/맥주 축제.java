import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0; 
        for (int i = 0; i < k; i++) {
            pq.add(arr[i][0]);
            sum += arr[i][0];

            if (pq.size() > n) sum -= pq.poll();
            if (pq.size() == n && sum >= m) {
                System.out.println(arr[i][1]);
                return;
            }
        }
        System.out.println(-1);
    }
}