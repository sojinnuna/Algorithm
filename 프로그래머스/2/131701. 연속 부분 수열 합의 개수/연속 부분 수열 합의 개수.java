import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] ele = new int[elements.length*2];
        
        for(int i=0; i<elements.length; i++) {
            ele[i] = elements[i];
            ele[i+elements.length] = elements[i];
        }
        
        for(int i=0; i<elements.length; i++) {
            int a = elements[i];
            set.add(a);
            for(int j=i+1; j<elements.length+i; j++) {
                a+=ele[j];
                set.add(a);
            }
        }
        
        return set.size();
    }
}