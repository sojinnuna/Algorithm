import java.util.*;

class Solution {
    ArrayList<Integer> answer = new ArrayList<>();
    char[][] box;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int cur = 0;

    public int[] solution(String[] maps) {
        box = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            String s = maps[i];
            for (int j = 0; j < s.length(); j++) {
                box[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (box[i][j] != 'X' && !visited[i][j]) {
                    cur = 0;  // 새 영역 시작 시 초기화
                    dfs(i, j);
                    answer.add(cur);
                }
            }
        }

        if (answer.isEmpty()) return new int[]{-1};

        Collections.sort(answer);
        int[] a = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            a[i] = answer.get(i);
        }

        return a;
    }

    private void dfs(int a, int b) {
        visited[a][b] = true;
        cur += box[a][b] - '0';

        for (int i = 0; i < 4; i++) {
            int na = a + dx[i];
            int nb = b + dy[i];
            if (na >= 0 && na < box.length && nb >= 0 && nb < box[0].length) {
                if (!visited[na][nb] && box[na][nb] != 'X') {
                    dfs(na, nb);
                }
            }
        }
    }
}