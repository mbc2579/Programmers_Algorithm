import java.io.*;
import java.util.*;

public class Main {

    static final int N = 10001;
    static int max = 0;

    static List<Integer>[] list = new ArrayList[N];
    static List<Integer> result = new ArrayList<>();
    static boolean[] visit = new boolean[N];
    static int[] connect = new int[N];

    static void DFS(int current){

        visit[current] = true;

        for(int next : list[current])
            if(!visit[next]) {
                connect[next]++;
                DFS(next);
            }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());

       for(int i=1; i<=n; i++) list[i] = new ArrayList<>();

       for(int i=1; i<=m; i++){
           st = new StringTokenizer(br.readLine());

           int home = Integer.parseInt(st.nextToken());
           int target = Integer.parseInt(st.nextToken());

           list[home].add(target);
       }

       for(int i=1; i<=n; i++) {
           visit = new boolean[N];
           DFS(i);
       }

        for(int i=1; i<=n; i++)
            if (connect[i] > max) {
                max = connect[i];
                result.clear();
                result.add(i);
            } else if (connect[i] == max)
                result.add(i);

       for(int a:result)
           System.out.print(a + " ");
    }
}