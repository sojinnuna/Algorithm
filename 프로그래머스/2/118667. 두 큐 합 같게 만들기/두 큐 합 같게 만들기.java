import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        long s1 = 0;
        long s2 = 0;
        
        Deque<Integer> q1 = new ArrayDeque<>();
        for(int q : queue1) {
            q1.add(q);
        }
        
        Deque<Integer> q2 = new ArrayDeque<>();
        for(int q : queue2) {
            q2.add(q);
        }
        
        for(int q : queue1) {
            s1 += q;
        }
        
        for(int q : queue2) {
            s2 += q;
        }
        
        while(count <= queue1.length*3) {
            if(s1 > s2) {
                int cur = q1.pop();
                s1 -= cur;
                s2 += cur;
                q2.add(cur);
                count++;
            } else if(s2 > s1) {
                int cur = q2.pop();
                s2 -= cur;
                s1 += cur;
                q1.add(cur);
                count++;
            } else {
                break;
            }
        }
        
        if(s1 == s2) {
            return count;
        } else {
            return -1;
        }
    }
}