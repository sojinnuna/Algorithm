import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer  = 0;
        
        int cur = 1;
        int idx = 0;
        //이분탐색?
        while(cur <= n) {
            if(idx < stations.length && cur >= stations[idx]-w) {
                cur = stations[idx]+w+1;
                idx++;
            } else {
                answer++;
                cur += (w*2)+1;
            }
        }
        
        return answer;
    }
}