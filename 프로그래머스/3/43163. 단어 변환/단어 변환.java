import java.util.*;

class Solution {
    boolean[] visited;
    int answer;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    
    private void dfs(String begin, String target, String[] words, int count) {

        if(begin.equals(target)) {
            answer = count;
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(!visited[i]) {
                int k = 0;
                String cur = words[i];
            
                for(int j=0; j<cur.length(); j++){
                    if(begin.charAt(j) == cur.charAt(j)) {
                        k++;
                    }   
                }
                
                if(k==begin.length()-1) {
                    visited[i] = true;
                    dfs(words[i], target, words, count+1);
                    visited[i] = false;
                }
            }
        }
        
    }
}