class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int min = 0;
        int max = 200000000;
        while(min <= max) {
            int mid = (min+max)/2;
            if(check(stones, k, mid)) {
                answer = Math.max(answer, mid);
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
        
        return answer;
    }
    
    private boolean check(int[] stones, int k, int cur) {
        int count = 0;
        for(int i : stones) {
            if(i < cur) {
                count++;
            } else {
                count = 0;
            }
            
            if(count == k) {
                return false;
            }
        }
        
        return true;
    }
}