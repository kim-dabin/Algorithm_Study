package ParkJiHoon.FourthWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 개선해야할 부분 : 중복 탐색 ex) (1,2,3) 순으로 탐색하고 (3,2,1)순으로도 탐색함
 * 풀리긴 함..
 */
public class LongestPath {
    static int map[][];
    static int max_len;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_n = Integer.parseInt(br.readLine());
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<case_n ; i++){
            String[] line1 = br.readLine().split(" ");
            int M = Integer.parseInt(line1[1]);
            N = Integer.parseInt(line1[0]);
            max_len = 1;
            map = new int[N+1][N+1];
            for( int j=0 ; j<M; j++){
                String[] line_data = br.readLine().split(" ");
                int temp_i = Integer.parseInt(line_data[0]);
                int temp_j = Integer.parseInt(line_data[1]);
                map[temp_i][temp_j] = 1;
                map[temp_j][temp_i] = 1;
            }

            get_max_len();
            res.add(max_len);

        }
        for(int i = 0; i<case_n; i++){
            System.out.println("#"+(i+1)+" "+res.get(i));
        }
    }

    //bfs
    static private int get_max_len(){
        int ret = 0;
        Queue<Node_Status> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            int[] temp = new int[N + 1];
            temp[i] = 1;
            queue.offer(new Node_Status(temp, i, 1));
        }
        while(!queue.isEmpty()){
            Node_Status ns = queue.poll();
            int[] temp_visited = ns.visited;
            int temp_num = ns.node_num;
            int len = ns.len;
            for(int i=1; i<=N;i++){
                if(map[temp_num][i]==1 && temp_visited[i]==0){
                    int[] clone_visited = new int[N+1];
                    for(int j=1; j<=N;j++ ) clone_visited[j] = temp_visited[j];
                    clone_visited[i] = 1;
                    queue.offer(new Node_Status(clone_visited,i,len+1));

                }
            }
            max_len = Math.max(max_len, len);
        }
        return ret;
    }

    static class Node_Status{
        int[] visited;
        int node_num;
        int len;
        public Node_Status(int[] visited, int node_num, int len) {
            this.visited = visited;
            this.node_num = node_num;
            this.len = len;
        }
    }

}
