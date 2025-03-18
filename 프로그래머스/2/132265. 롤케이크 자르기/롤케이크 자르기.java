import java.util.*;

class Solution {
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    
    public int solution(int[] topping) {
        int answer = 0;
        for(int i=0; i<topping.length; i++) {
            map2.put(topping[i], map2.getOrDefault(topping[i], 0)+1);
        }
        
        for(int i=0; i<topping.length; i++) {
            if(map2.get(topping[i]) == 1) {
                map2.remove(topping[i]);
            } else {
                map2.put(topping[i], map2.get(topping[i])-1);
            }
            map1.put(topping[i], map1.getOrDefault(topping[i], 0)+1);
            
            if(map1.size() == map2.size()) {
                answer++;
            }
        }
        return answer;
    }
}