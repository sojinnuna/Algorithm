class Solution {
    public int solution(String s) {
        int answer = 0;
        int firstCount = 0;
        int otherCount = 0; 
        char firstChar = s.charAt(0); 

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == firstChar) {
                firstCount++;
            } else {
                otherCount++;
            }

            if (firstCount == otherCount) {
                answer++;
                if (i + 1 < s.length()) {
                    firstChar = s.charAt(i + 1);
                }
                firstCount = 0;
                otherCount = 0;
            }
        }

        if (firstCount != 0 || otherCount != 0) {
            answer++;
        }

        return answer;
    }
}
