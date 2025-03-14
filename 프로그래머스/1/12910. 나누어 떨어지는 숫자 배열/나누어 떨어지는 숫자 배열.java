import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {

        List<Integer> result = new ArrayList<>();
        
        for (int num : arr) {
            if (num % divisor == 0) {
                result.add(num);
            }
        }
        
        if (result.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(result);

        return result.stream().mapToInt(i -> i).toArray();
    }
}
