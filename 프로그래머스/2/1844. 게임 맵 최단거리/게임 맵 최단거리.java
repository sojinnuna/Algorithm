import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        
        int answer= bfs(maps);
        if(answer == 0) {
            return -1;
        } else {
            return answer;
        }
    }
    
    private int bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        int answer = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int len = cur[2];
            
            if(x == maps.length-1 && y == maps[0].length-1) {
                answer = len;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length) {
                    if(!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, len+1});
                    }
                }
            }
        }
        return answer;
    }
}