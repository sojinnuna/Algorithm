import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for(int i=0; i<orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }
        
        ArrayList<String> list = new ArrayList<>();
        for(int c : course){
            map.clear();
            
            for(String o : orders){
                if(o.length() >= c){
                    dfs(c, o, "", 0);
                }
            }
            
            int max = 2;
            for(int m : map.values()){
                if(m > max){
                    max = m;
                }
            }
            
            for(String s : map.keySet()){
                if(map.get(s)==max){
                    list.add(s);
                }
            }
        }
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
    
    private void dfs(int c, String o, String a, int b){
        if(a.length() == c){
            map.put(a, map.getOrDefault(a, 0)+1);
            return;
        }
        
        for(int i=b; i<o.length(); i++){
            dfs(c, o, a+o.charAt(i), i+1);
        }
    }
}