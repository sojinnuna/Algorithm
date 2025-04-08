class Solution {
    public int solution(String s) {
        int max = 1;

        for (int i=0; i<s.length(); i++) {
            for (int j=i; j<s.length(); j++) {
                if (check(s, i, j)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    private boolean check(String s, int str, int end) {
        while (str <= end) {
            if (s.charAt(str) != s.charAt(end)) {
                return false;
            }
            str++;
            end--;
        }
        return true;
    }
}
