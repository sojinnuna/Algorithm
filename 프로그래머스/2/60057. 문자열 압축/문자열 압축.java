class Solution {
    public int solution(String s) {
        int answer = s.length();

        // 압축 단위를 1부터 s.length()/2까지 시도
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder result = new StringBuilder();
            String base = s.substring(0, i);
            int count = 1;

            for (int j = i; j <= s.length(); j += i) {
                int endIdx = Math.min(j + i, s.length());
                String compare = s.substring(j, endIdx);

                if (base.equals(compare)) {
                    count++; // 동일한 문자열 반복됨
                } else {
                    if (count > 1) {
                        result.append(count);
                    }
                    result.append(base);
                    base = compare;
                    count = 1;
                }
            }
            result.append(base); // 마지막 문자열 추가
            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}
