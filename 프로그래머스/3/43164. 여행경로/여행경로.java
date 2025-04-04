import java.util.*;

class Solution {
    ArrayList<String> list = new ArrayList<>();
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        // for(int i=0; i<tickets.length; i++) {
        //     String a = tickets[i][0];
        //     String b = tickets[i][1];
        //     map.put(a, map.getOrDefault(a, "")+" "+b);
        // }
        
        visited = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        return answer;
    }
    
    private void dfs(String str, String cur, String[][] tickets, int idx) {
        
        if(idx == tickets.length) {
            list.add(cur);
            return;
        }
        
        //백트래킹
        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(str)) {
                visited[i] = true;
                dfs(tickets[i][1], cur+" "+tickets[i][1], tickets, idx+1);
                visited[i] = false;
            }
        }
        
    }
}