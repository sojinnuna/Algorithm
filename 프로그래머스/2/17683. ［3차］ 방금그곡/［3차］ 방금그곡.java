import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0; 
        m = convertMelody(m); 

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            String title = parts[2];
            String melody = convertMelody(parts[3]);

            int playTime = calculatePlayTime(parts[0], parts[1]);
            String playedMelody = getPlayedMelody(playTime, melody);

            if (playedMelody.contains(m) && playTime > maxPlayTime) {
                answer = title;
                maxPlayTime = playTime;
            }
        }
        return answer;
    }

    private String convertMelody(String melody) {
        return melody.replaceAll("C#", "c")
                     .replaceAll("D#", "d")
                     .replaceAll("F#", "f")
                     .replaceAll("G#", "g")
                     .replaceAll("A#", "a")
                     .replaceAll("B#", "b");
    }

    private int calculatePlayTime(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");

        return (Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1])) - 
               (Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]));
    }

    private String getPlayedMelody(int playTime, String melody) {
        StringBuilder sb = new StringBuilder();
        int melodyLength = melody.length();

        for (int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % melodyLength));
        }

        return sb.toString();
    }
}
