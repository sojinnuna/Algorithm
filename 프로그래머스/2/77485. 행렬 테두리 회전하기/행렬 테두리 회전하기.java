import java.util.*;

class Solution {
    int[][] map;
    ArrayList<Integer> list = new ArrayList<>();
    
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        int index = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                map[i][j] = index++;
            }
        }
        
        for(int i=0; i<queries.length; i++) {
            int sx = queries[i][0]-1;
            int ex = queries[i][2]-1;
            
            int sy = queries[i][1]-1;
            int ey = queries[i][3]-1;
            
            dfs(sx, ex, sy, ey);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
    
    private void dfs(int sx, int ex, int sy, int ey) {
        int cur = map[sx][sy];
        int min = cur;
        
        for(int i=sx; i<ex; i++) {
            map[i][sy] = map[i+1][sy];
            min = Math.min(min, map[i][sy]);
        }
        
        for(int i=sy; i<ey; i++) {
            map[ex][i] = map[ex][i+1];
            min = Math.min(min, map[ex][i]);
        }
        
        for(int i=ex; i>sx; i--) {
            map[i][ey] = map[i-1][ey];
            min = Math.min(min, map[i][ey]);
        }
        
        for(int i=ey; i>sy; i--) {
            map[sx][i] = map[sx][i-1];
            min = Math.min(min, map[sx][i]);
        }
        
        map[sx][sy+1] = cur;
        list.add(min);
    }
}