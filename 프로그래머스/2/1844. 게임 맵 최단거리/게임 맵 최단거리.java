import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    int answer;
    
    public int solution(int[][] maps) {
        answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        bfs(maps);
        if(answer == 0) return -1;
        return answer;
    }
    
    private void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];
            int len = cur[2];
            
            if(a == maps.length-1 && b == maps[0].length-1) {
                answer = len;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int na = a+dx[i];
                int nb = b+dy[i];
                
                if(na>=0 && na<maps.length && nb>=0 && nb<maps[0].length) {
                    if(!visited[na][nb] && maps[na][nb] == 1) {
                        visited[na][nb] = true;
                        q.add(new int[]{na, nb, len+1});
                    }
                }
            }
        }
    }
}