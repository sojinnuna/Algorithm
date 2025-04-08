import java.util.*;

class Solution {
    ArrayList<int[]>[] graph;
    int[] visited;
    
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N+1];
        visited = new int[N+1];
        int answer = 0;
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }
        
        visited[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int[] g : graph[1]) {
            int a = g[0];
            int b = g[1];
            visited[a] = Math.min(visited[a], b);
            q.add(a);
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int[] c : graph[cur]) {
                int a = c[0];
                int b = c[1];
                
                if(visited[a] > visited[cur]+b) {
                    visited[a] = visited[cur]+b;
                    q.add(a);
                }
            }
        }
        
        for(int i=0; i<visited.length; i++) {
            if(visited[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}