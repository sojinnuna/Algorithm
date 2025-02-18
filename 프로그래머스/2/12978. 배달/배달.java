import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        ArrayList<int[]>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int len = road[i][2];
            
            graph[start].add(new int[]{end, len});
            graph[end].add(new int[]{start, len});
        }
        int[] len = new int[N+1];
        Arrays.fill(len, Integer.MAX_VALUE);
        len[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int[] i : graph[1]) {
            int a = i[0];
            int b = i[1];
            len[a] = Math.min(len[a], b);
            q.add(a);
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int[] i : graph[cur]) {
                int a = i[0];
                int b = i[1];
                if(len[a] > len[cur]+b) {
                    len[a] = len[cur]+b;
                    q.add(a);
                }
            }
        }
        int answer = 0;
        for(int i=0; i<len.length; i++) {
            if(len[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}