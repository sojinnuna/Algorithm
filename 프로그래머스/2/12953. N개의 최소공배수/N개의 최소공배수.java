import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        if(arr.length == 1) {
            return answer;
        }
        
        for(int i=1; i<arr.length; i++) {
            answer = find(answer, arr[i]);
        }
        
        return answer;
    }
    
    
    private int check(int a, int b) {
        //예외 처리
        if(b == 0) {
            return a;
        }
        return check(b, a%b);
    }
    
    private int find(int a, int b) {
        int aa = check(a, b);
        return (a*b)/aa;
    }
}