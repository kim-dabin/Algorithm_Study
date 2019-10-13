package ParkJiHoon.FifthWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NewCalculate {
//    static int[][] map = new int[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_num = Integer.parseInt(br.readLine());
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<case_num ; i++){
            String[] line = br.readLine().split(" ");
            res.add(calculate(Integer.parseInt(line[0]),Integer.parseInt(line[1])));
        }
        for(int i=0;i<case_num ; i++){
            System.out.println("#"+(i+1)+" "+res.get(i));
        }
    }
    private static int calculate(int p, int q){
        int[] p_cord = find_cord(p);
        int[] q_cord = find_cord(q);

//        System.out.println(cord_to_value(p,q));
//        System.out.println(find_cord(7)[0] +","+find_cord(7)[1]);
        return cord_to_value(p_cord[0]+q_cord[0],  p_cord[1]+q_cord[1]);
    }
    private static int cord_to_value(int x, int y){
        int ret =0;
        int n = (x+y)-1;
        ret = 1+(n*(n-1))/2 + n-y;
        return ret;
    }
    private static int[] find_cord(int n){
        int[] ret = new int[2];
        int i = 1;
        int layer= 0;
        while(true){
            if(((1+((i*(i-1))/2)) <= n) && ((1+((i*(i+1))/2)) > n) ) {layer = i;break;}
            i++;
        }
        int dif = n-(1+(layer*(layer-1))/2);
        ret[0] = dif+1;
        ret[1] = layer-dif;
        return ret;
    }
}
