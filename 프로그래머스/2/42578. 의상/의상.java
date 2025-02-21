import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            String cur = clothes[i][1];
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }
        
        if(map.size() == 1) {
            answer = map.get(clothes[0][1]);
        } else {
            for(int i : map.values()) {
                answer *= (i+1);
            }
            answer-=1;
        }
        return answer;
    }
}