import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        // 1. 장르별 총 재생 수와 곡 리스트 생성
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 총 재생 수 계산
            if (genrePlayCount.containsKey(genre)) {
                genrePlayCount.put(genre, genrePlayCount.get(genre) + play);
            } else {
                genrePlayCount.put(genre, play);
            }

            // 장르별 곡 리스트 추가
            if (!genreSongs.containsKey(genre)) {
                genreSongs.put(genre, new ArrayList<>());
            }
            genreSongs.get(genre).add(new int[]{i, play}); // [곡 번호, 재생 수]
        }

        // 2. 장르별 총 재생 수로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        // 3. 장르별로 가장 많이 재생된 2곡씩 선택
        List<Integer> resultList = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);

            // 재생 수 내림차순 정렬, 같으면 고유번호 오름차순
            songs.sort((a, b) -> {
                if (b[1] == a[1]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });

            resultList.add(songs.get(0)[0]); // 첫 번째 곡
            if (songs.size() > 1) {
                resultList.add(songs.get(1)[0]); // 두 번째 곡 (있을 경우)
            }
        }

        // 4. List<Integer>를 int[] 배열로 변환
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
