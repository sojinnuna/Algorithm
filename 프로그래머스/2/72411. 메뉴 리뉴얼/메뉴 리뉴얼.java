import java.util.*;

class Solution {
    ArrayList<String> list = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        //문자열 알파벳 순서대로
        for(int i=0; i<orders.length; i++) {
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = new String(c);
        }
        
        for(int c : course) {
            map.clear();
            for(String o : orders) {
                if(o.length() >= c){
                    dfs(o, c, "", 0);
                }
            }
            int max = 2;
            for(int cur : map.values()) {
                max = Math.max(cur, max);
            }
            
            for(String cur : map.keySet()) {
                if(map.get(cur) == max){
                    list.add(cur);
                }
            }
        }
        Collections.sort(list);
        return list.toArray(new String[0]);
        
    }
    
    private void dfs(String o, int c, String cur, int len) {
        //예외 처리
        if(cur.length() == c) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }
        
        //dfs
        for(int i=len; i<o.length(); i++) {
            dfs(o, c, cur+o.charAt(i), i+1);
        }
    }
}