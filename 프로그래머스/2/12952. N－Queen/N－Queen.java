import java.util.*;

class Solution {
    int[] board;
    int answer;
    
    public int solution(int n) {
        answer = 0;
        
        board = new int[n];
        
        dfs(n, 0);
        
        return answer;
    }
    
    //백트래킹
    private void dfs(int n, int cur) {
        //예외 처리
        if(n == cur) {
            answer++;
            return;
        }
        
        //확인
        for(int i=0; i<n; i++) {
            board[cur] = i;
            if(is(cur)) {
                dfs(n, cur+1);
            }
        }
    }
    
    //가능한지
    private boolean is(int cur) {
        for(int j=0; j<cur; j++) {
            if(board[cur] == board[j]) return false;
            if(Math.abs(cur-j) == Math.abs(board[cur]-board[j])) return false;
        }
        
        return true;
    }
}