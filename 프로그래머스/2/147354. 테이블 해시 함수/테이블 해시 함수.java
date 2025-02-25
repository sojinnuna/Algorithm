import java.util.*;

class Solution {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        for(int i=0; i<data.length-1; i++) {
            for(int j=i+1; j<data.length; j++) {
                if(data[i][col-1] > data[j][col-1]) {
                    int[] cur = data[i];
                    data[i] = data[j];
                    data[j] = cur;
                } else if(data[i][col-1] == data[j][col-1]) {
                    if(data[i][0] < data[j][0]) {
                        int[] cur = data[i];
                        data[i] = data[j];
                        data[j] = cur;
                    } 
                }
            }
        }
        
        for(int i=row_begin-1; i<row_end; i++) {
            int[] cur = data[i];
            int curt = 0;
            for(int j=0; j<cur.length; j++) {
                curt += cur[j]%(i+1);
            }
            answer ^= curt;
        }
        
        
        return answer;
    }
}