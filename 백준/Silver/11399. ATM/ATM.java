import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(answer);
        int[] total = new int[answer.length];
        total[0] = answer[0];
        for(int i=1; i<answer.length; i++){
            total[i] = total[i-1]+answer[i];
        }
        int count = 0;
        for(int i=0; i<total.length; i++){
            count += total[i];
        }
        System.out.println(count);
    }
}