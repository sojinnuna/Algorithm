import java.util.*;

class Solution {
    String[] word = new String[]{"A", "E", "I", "O", "U"};
    ArrayList<String> list = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        dfs("");
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
    
    private void dfs(String cur) {
        if(cur.length() > 5) {
            return;
        }
        
        if(cur.length() > 0) {
            list.add(cur);
        }
        
        for(int i=0; i<5; i++) {
            cur += word[i];
            dfs(cur);
            cur = cur.substring(0, cur.length()-1);
        }
    }
}