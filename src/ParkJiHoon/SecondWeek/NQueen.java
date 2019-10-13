package ParkJiHoon.SecondWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NQueen {
    static int n;
    static int[][] map = {};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> res_li = new ArrayList<>();
        int case_n = Integer.parseInt(br.readLine());
        for(int i= 0 ; i<case_n;i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            res_li.add(find_queen_count(0));
        }
        for(int i=1; i<=case_n;i++){
            System.out.println("#"+i+" "+res_li.get(i-1));
        }

    }

    public static int find_queen_count(int i){
        int ret = 0;


        for(int j=0 ; j<n; j++){
            if(isSpotPossible(i,j)){
                //base case
                if(i == n-1) return 1;
                map[i][j] = 1;
                ret += find_queen_count(i+1);
                map[i][j] = 0;
            }else continue;//안됨

        }

        return ret;
    }
    public static boolean isSpotPossible(int i, int j){
        boolean ret = false;
        int count = 0;//좌우 한칸씩 이동
        while(i>=0 ){
            if(map[i][j] == 1) return ret;

            if(j-count >= 0) {
                if(map[i][j - count] == 1){
                    return ret;
                }
            }
            if (j+count <n){
                if(map[i][j + count] == 1){
                    return ret;
                }
            }

            count++;
            i--;
        }
        ret = true;
        return ret;

    }

}
