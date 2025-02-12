class Solution {
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        visited = new boolean[dungeons.length];
        answer = dfs(k, dungeons, 0);
        return answer;
    }
    public int dfs(int k, int[][] dungeons, int count){
        int total = count;
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                total = Math.max(total, dfs(k-dungeons[i][1], dungeons, count+1));
                visited[i] = false;
            }
        }
        return total;
    }
}