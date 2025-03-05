class Solution {
    public long solution(int w, int h) {
        long a = da(w, h);
        // System.out.println(a);
        long answer = (long)w*h - (long)(w+h-a);
        return answer;
    }
    
    private long da(int w, int h) {
        if(h == 0) return w;
        return da(h, w%h);
    }
}