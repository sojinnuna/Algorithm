import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N-1; i++){
            int cur = Math.abs(num[i] - num[i+1]);
            if(cur != 0){
                list.add(cur);
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        
        int sum = 0;
        for(int i=K-1; i<list.size(); i++){
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}