import java.util.*;

class Solution {
    private int n, m, answer = 0;
    private List<Set<Integer>> candidateKeys = new ArrayList<>();
    private String[][] relation;

    public int solution(String[][] relation) {
        this.relation = relation;
        n = relation.length;
        m = relation[0].length;

        // 1부터 m까지 크기의 조합을 탐색
        for (int size = 1; size <= m; size++) {
            generateCombinations(0, size, new HashSet<>());
        }

        return answer;
    }

    private void generateCombinations(int start, int size, Set<Integer> currentSet) {
        if (currentSet.size() == size) {
            if (isUnique(currentSet) && isMinimal(currentSet)) {
                candidateKeys.add(new HashSet<>(currentSet));
                answer++;
            }
            return;
        }

        for (int i = start; i < m; i++) {
            currentSet.add(i);
            generateCombinations(i + 1, size, currentSet);
            currentSet.remove(i);
        }
    }

    private boolean isUnique(Set<Integer> keySet) {
        Set<String> seen = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int index : keySet) {
                sb.append(row[index]);
            }
            if (!seen.add(sb.toString())) {
                return false;
            }
        }
        return true;
    }

    private boolean isMinimal(Set<Integer> keySet) {
        for (Set<Integer> key : candidateKeys) {
            if (keySet.containsAll(key)) {
                return false;
            }
        }
        return true;
    }
}
