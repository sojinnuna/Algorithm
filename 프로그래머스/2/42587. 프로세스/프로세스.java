import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : priorities) {
            q.add(i);
        }
        
        //i는 본래 인덱스
        while(!q.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                if(priorities[i] == q.peek()) {
                    q.remove();
                    answer++;
                    if(i == location) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}