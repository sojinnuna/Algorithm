import java.util.*;

class Solution {
    ArrayList<String> list = new ArrayList<>();
    String[] s = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        dfs("");
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    private void dfs(String cur) {
        //예외 처리
        list.add(cur);
        
        if(cur.length() == 5) {
            return;
        }
        
        for(int i=0; i<s.length; i++) {
            dfs(cur+s[i]);
        }
    }
}