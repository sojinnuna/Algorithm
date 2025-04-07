import java.util.*;

class Solution {
    ArrayList<Integer>[] list;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList[n+1];
        int answer = Integer.MAX_VALUE;
        
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int[] w : wires) {
            int a = w[0];
            int b = w[1];
            
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
            
            visited = new boolean[n+1];
            int size1 = count(a);
            int size2 = n-size1;
            answer = Math.min(answer, Math.abs(size1-size2));
            
            list[a].add(b);
            list[b].add(a);
        }
        
        return answer;
    }
    
    private int count(int a) {
        visited[a] = true;
        int c = 1;
        
        for(int i : list[a]) {
            if(!visited[i]) {
                c += count(i);
            }
        }
        
        return c;
    }
}