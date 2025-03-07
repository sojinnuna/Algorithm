import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long di = d;
        long ki = k;

        for(long i=0; i<=d; i+=ki) {
            long cur = (long)Math.sqrt(di*di-i*i);
            answer += (cur/k)+1;
        }
        
        return answer;
    }
}