import java.util.*;

class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int cur, int count){
        //예외 처리
        if(count >= numbers.length){
            if(cur == target){
                answer++;
            }
            return;
        }
        
        dfs(numbers, target, cur+numbers[count], count+1);
        dfs(numbers, target, cur-numbers[count], count+1);
        
    }
}