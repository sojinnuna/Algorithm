import java.util.*;

class Solution {
    HashMap<String, Integer> SIN = new HashMap<>(); // 입차 기록
    HashMap<String, Integer> SP = new HashMap<>(); // 가격 기록
    
    public int[] solution(int[] fees, String[] records) {
        for(int i=0; i<records.length; i++) {
            String[] r = records[i].split(" ");
            int a = count(r[0]);
            String b = r[1];
            String c = r[2];
            
            if(c.equals("IN")) {
                SIN.put(b, a);
            } else {
                int in = SIN.remove(b);
                int gae = a-in;
                SP.put(b, SP.getOrDefault(b, 0)+gae);
            }
        }
        
        if(SIN.size() > 0) {
            for(String i : SIN.keySet()) {
                int in = SIN.get(i);
                int gae = 23*60+59-in;
                SP.put(i, SP.getOrDefault(i, 0)+gae);
            }
        }
        
        ArrayList<String> list = new ArrayList<>(SP.keySet());
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = check(SP.get(list.get(i)), fees);
        }
        
        return answer;
    }
    
    private int count(String a) {
        String[] ing = a.split(":");
        return Integer.valueOf(ing[0])*60+Integer.valueOf(ing[1]);
    }
    
    private int check(int a, int[] fees) {
        int cur = 0;
        if(a <= fees[0]) {
            cur = fees[1];
        } else {
            if((a-fees[0])%fees[2] == 0) {
                cur = fees[1]+(((a-fees[0])/fees[2]))*fees[3];
            } else {
                cur = fees[1]+(((a-fees[0])/fees[2])+1)*fees[3];
            }
        }
        
        return cur;
    }
}
