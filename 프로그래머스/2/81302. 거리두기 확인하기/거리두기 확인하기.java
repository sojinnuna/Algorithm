import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++) {
            String[] cur = places[i];
            
            if(check(cur)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private boolean check(String[] cur) {
        for(int i=0; i<cur.length; i++) {
            for(int j=0; j<cur[0].length(); j++) {
                if(cur[i].substring(j, j+1).equals("P")) {
                    if(check2(cur, i, j)) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean check2(String[] cur, int a, int b) {
        for(int i=0; i<4; i++) {
            int na = a+dx[i];
            int nb = b+dy[i];
            
            if(na>=0 && na<cur.length && nb>=0 && nb<cur[0].length()) {
                
                if(cur[na].substring(nb, nb+1).equals("P")) {
                    return false;
                }
                
                if(cur[na].substring(nb, nb+1).equals("O")) {
                    if(dx[i] == 0) {
                        int nb2 = nb+dy[i];
                        if(nb2>=0 && nb2<cur[0].length()) {
                            if(cur[na].substring(nb2, nb2+1).equals("P")) {
                                return false;
                            }
                        }
                        
                        int na2 = na -1;
                        if(na2>=0 && na2<cur.length) {
                            if(cur[na2].substring(nb, nb+1).equals("P")) {
                                return false;
                            }
                        }
                        
                        int na3 = na +1;
                        if(na3>=0 && na3<cur.length) {
                            if(cur[na3].substring(nb, nb+1).equals("P")) {
                                return false;
                            }
                        }
                        
                    } else if(dy[i] == 0) {
                        
                        int na2 = na+dx[i];
                        if(na2>=0 && na2<cur.length) {
                            if(cur[na2].substring(nb, nb+1).equals("P")) {
                                return false;
                            }
                        }
                        
                        int nb2 = nb -1;
                        if(nb2>=0 && nb2<cur[0].length()) {
                            if(cur[na].substring(nb2, nb2+1).equals("P")) {
                                return false;
                            }
                        }
                        
                        int nb3 = nb +1;
                        if(nb2>=0 && nb2<cur[0].length()) {
                            if(cur[na].substring(nb2, nb2+1).equals("P")) {
                                return false;
                            }
                        }
                        
                    }
                }
            }
        }
        
        return true;
    }
}