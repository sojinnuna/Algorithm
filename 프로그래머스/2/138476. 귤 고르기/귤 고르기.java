import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int m : map.values()) {
            list.add(m);
        }
        Collections.sort(list, Collections.reverseOrder());
        for(int i : list) {
            if(k <= 0) {
                return answer;
            } else {
                answer ++;
                k -= i;
            }
        }
        
        return answer;
    }
}