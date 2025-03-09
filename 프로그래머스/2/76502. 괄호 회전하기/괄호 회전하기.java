import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            String sing = s.substring(i) + s.substring(0, i);
            if(check(sing)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean check(String cur) {
        Stack<Character> s = new Stack<>();
        char[] c = cur.toCharArray();
        for(char cing : c) {
            if(cing == '[' || cing == '{' || cing == '(') {
                s.push(cing);
            } else {
                if(!s.isEmpty()) {
                    char a = s.pop();
                    if((a == '['&& cing==']') || (a == '{'&& cing=='}') || (a == '('&& cing==')')) {
                     continue;
                    } else {
                     return false;
                    }
                } else {
                    return false;
                }
            }
        }
        
        return s.isEmpty();
    }
}