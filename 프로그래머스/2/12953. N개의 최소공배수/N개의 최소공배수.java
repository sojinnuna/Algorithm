import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        answer = arr[0];
        
        if(arr.length == 1) {
            return answer;
        }
        
        for(int i=1; i<arr.length; i++) {
            answer = gcp(answer, arr[i]);
        }
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
    
    private int gcp(int a, int b) {
        int na = gcd(a, b);
        int dap = (a*b)/na;
        return dap;
    }
}