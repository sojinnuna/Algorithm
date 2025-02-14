import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim()); // 회의 개수 입력

        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        System.out.println(minMeetingRooms(meetings));
    }

    public static int minMeetingRooms(int[][] meetings) {
        if (meetings.length == 0) return 0;

        // 시작 시간을 기준으로 정렬
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // 종료 시간을 저장할 우선순위 큐 (작은 값이 우선)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] meeting : meetings) {
            // 현재 회의의 시작 시간이 기존 회의 중 가장 빨리 끝나는 시간 이후라면 재사용
            if (!pq.isEmpty() && pq.peek() <= meeting[0]) {
                pq.poll(); // 기존 회의실 재사용
            }
            pq.offer(meeting[1]); // 새 회의 종료 시간 추가
        }

        return pq.size(); // 필요한 최소 회의실 개수
    }
}
