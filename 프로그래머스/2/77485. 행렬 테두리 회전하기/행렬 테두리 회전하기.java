import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] box = new int[rows][columns];
        int[] answer = new int[queries.length];
        
        // 2차원 배열 초기화
        for (int i = 0, num = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                box[i][j] = num++;
            }
        }
        
        for (int q = 0; q < queries.length; q++) {
            int x1 = queries[q][0] - 1;
            int y1 = queries[q][1] - 1;
            int x2 = queries[q][2] - 1;
            int y2 = queries[q][3] - 1;
            
            int temp = box[x1][y1]; // 첫 번째 값 임시 저장
            int minVal = temp;

            // ← 왼쪽 (위쪽 가로줄)
            for (int i = x1; i < x2; i++) {
                box[i][y1] = box[i + 1][y1];
                minVal = Math.min(minVal, box[i][y1]);
            }

            // ↓ 아래쪽 (오른쪽 세로줄)
            for (int i = y1; i < y2; i++) {
                box[x2][i] = box[x2][i + 1];
                minVal = Math.min(minVal, box[x2][i]);
            }

            // → 오른쪽 (아래쪽 가로줄)
            for (int i = x2; i > x1; i--) {
                box[i][y2] = box[i - 1][y2];
                minVal = Math.min(minVal, box[i][y2]);
            }

            // ↑ 위쪽 (왼쪽 세로줄)
            for (int i = y2; i > y1 + 1; i--) {
                box[x1][i] = box[x1][i - 1];
                minVal = Math.min(minVal, box[x1][i]);
            }

            // 마지막 값 보정
            box[x1][y1 + 1] = temp;

            answer[q] = minVal;
        }
        
        return answer;
    }
}
