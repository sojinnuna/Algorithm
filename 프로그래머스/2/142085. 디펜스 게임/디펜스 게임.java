import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            q.add(enemy[i]);

            if (n < 0) { 
                if (k > 0) {
                    k--;
                    n += q.poll();
                } else {  
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}
