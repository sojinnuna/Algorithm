import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, 0};
        
        HashSet<String> set = new HashSet<>();
        for(String g : gems) {
            set.add(g);
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int start = 0;
        int len = Integer.MAX_VALUE;
        for(int i=0; i<gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) +1);
            
            while(map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start])-1);
                start++;
            }
            
            if(set.size() == map.size() && len > i-start) {
                answer[0] = start+1;
                answer[1] = i+1;
                len = i-start;
            }
        }
        
        return answer;
    }
}