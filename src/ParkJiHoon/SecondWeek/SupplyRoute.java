package ParkJiHoon.SecondWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SupplyRoute {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int map[][];
    static int dp[][];  //현재 위치까지 최소값
    static int global_n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> res_li = new ArrayList<>();
        int case_n  = Integer.parseInt(br.readLine());
        for(int i=0 ; i<case_n ; i++){
            int n  = Integer.parseInt(br.readLine());
            global_n = n;
            map = new int[n][n];
            dp = new int[n][n];//
            for(int j=0 ;j<n ;j++) {
                Arrays.fill(dp[j], 123456789);
            }
            for(int j=0;j<n;j++) {
                String[] line = br.readLine().split("");
                for(int k=0; k<n; k++){
                    map[j][k] = Integer.parseInt(line[k]);
                }
            }
            res_li.add(supply_route());
        }
        for(int i=1; i<=case_n;i++){
            System.out.println("#"+i+" "+res_li.get(i-1));
        }
    }


    public static int supply_route(){
        int ret;
        Queue<Bridge> queue = new LinkedList<>();
        queue.offer(new Bridge(0,0,0));
        ret = move(queue);
        return ret;
    }


    public static int move(Queue<Bridge> q){
        while (!q.isEmpty()) {
            int i = q.peek().i;
            int j = q.peek().j;
            int nowCost = q.peek().cost;
            q.poll(); //맨앞에 빼냄
            for (int idx = 0; idx < 4; idx++) {
                int next_x = j + dx[idx];
                int next_y = i + dy[idx];
                if (next_x >= 0 && next_y >= 0 && next_x < global_n && next_y < global_n) {
                    int next_cost = nowCost + map[next_y][next_x];
                    if(next_cost>= dp[next_y][next_x]) continue;
                    dp[next_y][next_x] = next_cost;
                    q.offer(new Bridge(next_y,next_x,next_cost));
                }
            }
        }
        return dp[global_n-1][global_n-1];
    }


    private static class Bridge{
        int i,j,cost;

        public Bridge(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }
}
