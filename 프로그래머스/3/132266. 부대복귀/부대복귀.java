import java.util.*;

class Solution {
    ArrayList<Integer>[] list;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] road : roads) {
            list[road[0]].add(road[1]);
            list[road[1]].add(road[0]);
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        bfs(destination, distance);

        for(int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }

        return answer;
    }

    private void bfs(int start, int[] distance) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : list[now]) {
                if(distance[next] == -1) {
                    distance[next] = distance[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
