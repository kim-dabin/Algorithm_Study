package ParkJiHoon.ThirdWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Harvesting {
        /*1
        5
        14054
        44250
        02032
        51204
        52212*/
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int case_n = Integer.parseInt(br.readLine());
            List<Integer> res  = new ArrayList<>();
            for(int i = 0; i<case_n ; i++){
                int n = Integer.parseInt(br.readLine());
                int[][] map = new int[n][n];
                for(int j=0;j<n;j++){
                    String[] line = br.readLine().split("");
                    for(int k=0;k<n; k++){
                        map[j][k] = Integer.parseInt(line[k]);
                    }
                }
                res.add(get_harvested_value(map));

            }

            for(int i = 0; i<case_n; i++){
                System.out.println("#"+(i+1)+" "+res.get(i));
            }
        }

        static int get_harvested_value(int[][] map){
            int ret = 0;
            int n = map.length/2;
            int idx = 0;
            for(int i=0 ; i<n+1 ; i++){
                int count = idx;
                while(count>=0){
                    if(count!=0) {
                        ret += map[i][n-count];
                        ret += map[i][n+count];
                    }else{
                        ret+= map[i][n];
                    }
                    count--;
                }
                idx++;
            }
            idx = idx-2;
            for(int i=n+1 ; i<map.length ; i++){
                int count = idx;
                while(count>=0){
                    if(count!=0) {
                        ret += map[i][n-count];
                        ret += map[i][n+count];
                    }else{
                        ret+= map[i][n];
                    }
                    count--;
                }
                idx--;
            }
            return ret;
        }
}
