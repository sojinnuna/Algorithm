import java.util.*;

class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    private void dfs(int a, int count, int[] numbers, int target){
        if(count >= numbers.length){
            if(a == target){
                answer++;
            }
           return;
        }
        
        dfs(a+numbers[count], count+1, numbers, target);
        dfs(a-numbers[count], count+1, numbers, target);
    }
}