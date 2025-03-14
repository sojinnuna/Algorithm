import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (x, y) -> x[1] - y[1]);
        
        int cur = 0;
        for(int i=0; i<targets.length; i++){
            if(cur <= targets[i][0]){
                cur = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}
