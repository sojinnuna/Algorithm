class Solution {
    boolean[] visited;
    int answer;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int cur, int[][] computers) {
        if(cur == computers.length) {
            return;
        }
        
        for(int i=0; i<computers.length; i++) {
            if(!visited[i] && computers[cur][i] == 1) {
                visited[i] = true;
                dfs(i, computers);
            }
        }
    }
}