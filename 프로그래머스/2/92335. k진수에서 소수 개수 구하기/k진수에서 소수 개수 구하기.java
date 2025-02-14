import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String cur = Integer.toString(n, k);
        int answer = 0;
        
        StringBuilder a = new StringBuilder();
        for(int i = 0; i < cur.length(); i++){
            if(cur.charAt(i) == '0'){
                if(a.length() > 0){
                    if(isPrime(Long.parseLong(a.toString()))){
                        answer++;
                    }
                    a.setLength(0); // StringBuilder 초기화
                }
            } else {
                a.append(cur.charAt(i));
            }
        }
        if(a.length() > 0 && isPrime(Long.parseLong(a.toString()))){
            answer++;
        }
        return answer;
    }
    
    private boolean isPrime(long a){
        if(a<2) return false;
        for(long i=2; i<=Math.sqrt(a); i++){
            if(a%i == 0){
                return false;
            }
        }
        return true;
    }
}