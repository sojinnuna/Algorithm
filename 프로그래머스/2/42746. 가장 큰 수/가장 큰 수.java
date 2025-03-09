import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] ans = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            ans[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(ans, (x, y) -> (y+x).compareTo(x+y));
        
        for(String a : ans){
            answer += a;
        }
        
        if(answer.charAt(0) == '0') {
            answer = String.valueOf(0);
        }
        
        
        return answer;
    }
}