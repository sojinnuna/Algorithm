import java.util.*;

class Solution {
    String[][] box;
    int strx;
    int stry;
    int endx;
    int endy;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        box = new String[board.length][board[0].length()];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length(); j++) {
                box[i][j] = board[i].substring(j, j+1);
                if(box[i][j].equals("G")) {
                    endx = i;
                    endy = j;
                }
                
                if(box[i][j].equals("R")) {
                    strx = i;
                    stry = j;
                }
            }
        }
        
        int answer = bfs(box);
        return answer;
    }
    
    private int bfs(String[][] box) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{strx, stry, 0});
        boolean[][] visited = new boolean[box.length][box[0].length];
        visited[strx][stry] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];
            int len = cur[2];
            System.out.println(a);
            
            if(a==endx && b==endy) {
                return len;
            }
            
            for(int i=0; i<4; i++) {
                int na = a;
                int nb = b;
                
                while(na>=0 && na<box.length && nb>=0 && nb<box[0].length && !box[na][nb].equals("D")) {
                    na += dx[i];
                    nb += dy[i];
                }
                
                na-=dx[i];
                nb-=dy[i];
                
                if(visited[na][nb] || (na==a&&nb==b)) {
                    continue;
                }
                
                visited[na][nb] = true;
                q.add(new int[]{na, nb, len+1});
            }
        }
        return -1;
    }
}