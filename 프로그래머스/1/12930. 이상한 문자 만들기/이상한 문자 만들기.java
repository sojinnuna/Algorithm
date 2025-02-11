import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                count = 0;
                sb.append(' ');
                continue;
            }
            
            if(count == 0 || count%2 == 0){
                char a = Character.toUpperCase(c);
                sb.append(a);
                count++;
            }else{
                char a = Character.toLowerCase(c);
                sb.append(a);
                count++;
            }
        }
        return sb.toString();
    }
}