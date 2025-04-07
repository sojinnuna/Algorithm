import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int time = 0;
        int idx = 0; // jobs 인덱스
        int totalTime = 0;
        int count = 0; // 완료한 작업 수

        while (count < jobs.length) {
            // 현재 시간까지 들어온 모든 job을 큐에 넣음
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx]);
                idx++;
            }

            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                time += job[1];
                totalTime += (time - job[0]);
                count++;
            }
        }

        return totalTime / jobs.length;
    }
}
