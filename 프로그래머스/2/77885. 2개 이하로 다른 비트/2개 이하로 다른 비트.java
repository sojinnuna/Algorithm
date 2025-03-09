class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            answer[i] = check(numbers[i]);
        }
        
        return answer;
    }
    
    private long check(long cur) {
        if(cur%2 == 0 || cur < 2) {
            return cur+1;
        } else {
            String a = Long.toString(cur, 2);
            
            if(a.contains("0")) {
                int c = a.lastIndexOf("0");
                a = a.substring(0, c) + "10" + a.substring(c+2);
            } else {
                a = "10" + a.substring(1);
            }
            
            return Long.parseLong(a, 2);
        }
    }
}