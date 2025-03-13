import java.util.*;

class Solution {
    int[] answer = new int[2]; 
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] arr = new int[emoticons.length]; 
        count(arr, 0, users, emoticons);
        return answer;
    }
    
    // 조합 생성
    private void count(int[] arr, int cur, int[][] users, int[] emoticons) {
        if (cur == arr.length) { 
            cal(arr, users, emoticons);
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) { 
            arr[cur] = i; 
            count(arr, cur + 1, users, emoticons);
        }
    }
    
    // 계산 메서드
    private void cal(int[] arr, int[][] users, int[] emoticons) {
        int[] e = new int[emoticons.length]; 
        
        // 할인된 가격 계산
        for (int i = 0; i < arr.length; i++) {
            e[i] = emoticons[i] * (100 - arr[i]) / 100;
        }
        
        int[] ing = new int[2]; 
        
        for (int i = 0; i < users.length; i++) { 
            int hal = users[i][0]; 
            int price = users[i][1]; 
            int tempCur = 0; 
            
            for (int j = 0; j < e.length; j++) {
                if (hal <= arr[j]) { 
                    tempCur += e[j]; 
                }
                
                if (tempCur >= price) { 
                    ing[0] += 1; 
                    tempCur = 0;
                    break;
                }
            }
            
            ing[1] += tempCur;
        }
        
        if (ing[0] > answer[0] || (ing[0] == answer[0] && ing[1] > answer[1])) { 
            answer[0] = ing[0]; 
            answer[1] = ing[1]; 
        }
    }
}
