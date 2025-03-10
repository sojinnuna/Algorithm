class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] count = new long[n];
        
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }
        
        count[0] = 1;
        count[1] = 2;

        for(int i=2; i<n; i++) {
            count[i] = (count[i-2] + count[i-1])%1234567;
        }
        
        return count[n-1];
    }
}