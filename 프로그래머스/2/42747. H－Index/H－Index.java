import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        int min = 0;
        int max = citations[citations.length-1];
        while(min <= max) {
            int mid = (min+max)/2;
            int count = 0;
            
            for(int i=citations.length-1; i>=0; i--) {
                if(citations[i] >= mid) {
                    count++;
                } else {
                    break;
                }
            }
            
            if(count >= mid) {
                answer = Math.max(answer, mid);
                min = mid+1;
            } else{
                max = mid-1;
            }
        }
        
        return answer;
    }
}