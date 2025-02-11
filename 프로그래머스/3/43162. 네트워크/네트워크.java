import java.util.*;

class Solution {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        graph = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<computers.length-1; i++){
            for(int j=i+1; j<computers[0].length; j++){
                int cur = computers[i][j];
                if(cur == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i, n);
                answer++;
            }
        }
        return answer;
    }
    
    private void bfs(int i, int n){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        visited[i] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int a : graph[cur]){
                if(!visited[a]){
                    visited[a] = true;
                    q.add(a);
                }
            }
        }
    }
}