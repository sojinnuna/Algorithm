import java.util.*;

class Solution {
    ArrayList<int[]> list;
    
    public int[][] solution(int n) {
        list = new ArrayList<>();
        count(n, 1, 3, 2);
        int[][] answer = new int[list.size()][2];
        
        for(int i=0; i<list.size(); i++) {
            int[] cur = list.get(i);
            answer[i][0] = cur[0];
            answer[i][1] = cur[1];
        }
        
        return answer;
    }
    //s: start, e:end, m: middle
    private void count(int num, int s, int e, int m) {
        //예외 처리
        int[] go = new int[]{s, e};
        
        if(num == 1) {
            list.add(go);
        } else {
            count(num-1, s, m, e);
            list.add(go);
            count(num-1, m, e, s);
        }
    }
}