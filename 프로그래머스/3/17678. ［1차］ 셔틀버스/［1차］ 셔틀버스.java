import java.util.*;

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        for(int i=0; i<timetable.length; i++) {
            pq.add(check(timetable[i]));
        }
        
        int last = 0;
        int index = 0;
        for(int i=0; i<n; i++) {
            int curTime =540 + t*i;
            index = 0;
            
            while(!pq.isEmpty() && pq.peek()<=curTime && index<m) {
                last = pq.poll();
                index++;
            }
            
            if(i == n-1) {
                if(index < m) {
                    last = curTime;
                } else {
                    last -= 1;
                }
            }
        }

        return check2(last);
    }
    
    private int check(String t) {
        String[] time = t.split(":");
        return Integer.valueOf(time[0])*60+Integer.valueOf(time[1]);
    }
    
    private String check2(int t) {
        String a = String.valueOf(t/60);
        if(a.length() == 1) {
            a = "0"+a;
        }
        
        String b = String.valueOf(t%60);
        if(b.length() == 1) {
            b = "0"+b;
        }
        
        return a+":"+b;
    }
}