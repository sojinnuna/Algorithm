class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        
        int idx = 0;
        for(long i=left; i<=right; i++) {
            long a = (i/n+1);
            long b = (i%n+1);
            answer[idx] = (int)Math.max(a, b);
            idx++;
        }
        
        return answer;
    }
}