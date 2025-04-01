import java.util.*;

class Solution {
    HashSet<Integer> set;
    
    public int solution(int[] elements) {
        set = new HashSet<>();
        
        int[] e = new int[elements.length*2];
        for(int i=0; i<elements.length; i++) {
            e[i] = elements[i];
            e[i+elements.length] = elements[i];
        }
        
        for(int i=1; i<=elements.length; i++) {
            count(i, e);
        }
            
        return set.size();
    }
    
    private void count(int a, int[] e) {
        for(int i=0; i<e.length/2; i++) {
            int cur = 0;
            for(int j=0; j<a; j++) {
                cur+=e[i+j];
            }
            set.add(cur);
        }
    }
}