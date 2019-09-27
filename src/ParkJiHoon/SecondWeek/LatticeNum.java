package ParkJiHoon.SecondWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LatticeNum {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> res_li = new ArrayList<>();

        int n  = Integer.parseInt(br.readLine());
        for(int i=0 ; i<n ; i++){
            map = new int[4][4];
            for(int j=0;j<4;j++) {
                String[] line = br.readLine().split(" ");
                for(int k=0; k<4; k++){
                    map[j][k] = Integer.parseInt(line[k]);
                }
            }
            res_li.add(get_possible_nums());
        }

        for(int i=1; i<=n;i++){
            System.out.println("#"+i+" "+res_li.get(i-1));
        }

    }

    static HashSet<Integer> possible_num;
    public static int get_possible_nums(){
        int count = 0;
        possible_num = new HashSet<>();
        for(int i=0 ; i<4; i++){
            for(int j=0 ; j<4; j++){
                move(i,j,map[i][j],6);
            }
        }

        return possible_num.size();
    }

    /**
     *
     * @param count 이동 횟수
     * @return
     */
    public static void move(int i , int j, int num,int count){
        //base case
        if(count == 0){ possible_num.add(num); return ;}

        for(int idx = 0; idx<4; idx++){
            int next_i= i+dy[idx];
            int next_j= j+dx[idx];
            if(next_i>=0 && next_j>=0 && next_i<4 && next_j<4){
               move(next_i,next_j,num*10 +map[next_i][next_j],count-1 );
            }
        }
    }
}
