import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int min = 0;
        int max = 200000000;
        int count = 0;
        while(min <= max) {
            int mid = (min+max)/2;
            count = 0;

            if(check(stones, mid, 0, k)) {
                answer = Math.max(answer, mid);
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
        return answer;
    }
    
    private boolean check(int[] stones, int cur, int count, int k) {
        for(int s : stones) {
            if(s < cur) {
                count++;
            } else {
                count = 0;
            }
            
            if(count == k) {
                return false;
            }
        }
        return true;
    }
}
    