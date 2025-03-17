import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> s = new Stack<>();
        
        for(int i=numbers.length-1; i>=0; i--) {
            int cur = numbers[i];
            if(s.isEmpty()) {
                answer[i] = -1;
                s.push(numbers[i]);
            } else {
                while(!s.isEmpty()) {
                    int sing = s.peek();
                    if(cur < sing) {
                        answer[i] = sing;
                        s.push(cur);
                        break;
                    } else {
                        s.pop();
                    }
                }
                if(s.isEmpty()) {
                    s.push(cur);
                    answer[i] = -1;
                }
            }
        }
        
        return answer;
    }
}