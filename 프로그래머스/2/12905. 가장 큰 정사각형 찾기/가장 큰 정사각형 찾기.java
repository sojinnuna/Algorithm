class Solution{
    public int solution(int [][]board){
        int answer = 0;
        int[][] box = new int[board.length+1][board[0].length+1];
        
        for(int i=1; i<=board.length; i++) {
            for(int j=1; j<=board[0].length; j++){
                if(board[i-1][j-1] != 0) {
                    int min = Math.min(box[i-1][j], Math.min(box[i][j-1], box[i-1][j-1]));
                    box[i][j] = min+1;
                    answer = Math.max(answer, min+1);
                }
            }
        }
    
        return answer*answer;
    }
}