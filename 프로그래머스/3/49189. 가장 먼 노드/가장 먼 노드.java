import java.util.*;

class Solution {
    ArrayList<Integer>[] list;
    boolean[] visited;
    int[] distance;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        distance = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++) {
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        bfs();
        
        int max = 0;
        for(int i : distance) {
            max = Math.max(max, i);
        }
        
        for(int i: distance) {
            if(i == max) answer++; 
        }
        
        return answer;
    }
    
    private void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        distance[1] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i : list[cur]) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    distance[i] = distance[cur]+1;
                }
            }
        } 
    }
}