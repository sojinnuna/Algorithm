import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        Stack<Integer> s = new Stack<>();
        for(int i=len-1; i>=0; i--) {
            int cur = 100-progresses[i];
            int a = cur/speeds[i];
            int b = cur%speeds[i];
            if(b > 0) {
                s.push(a+1);
            }else {
                s.push(a);
            }
        }

        int count = 1;
        int cur = s.pop();
        while(!s.isEmpty()) {
            if(cur >= s.peek()) {
                count++;
                s.pop();
            } else {
                list.add(count);
                cur = s.pop();
                count = 1;
            }
        }
        if(count >= 1) {
            list.add(count);
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}