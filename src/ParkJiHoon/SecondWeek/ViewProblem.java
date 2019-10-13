package ParkJiHoon.SecondWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ViewProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> res_li = new ArrayList<>();

        for(int i= 0 ; i<10;i++) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] ap_height = new int[n];

            for(int j=0; j<n;j++){
                ap_height[j] = Integer.parseInt(line[j]);
            }
            res_li.add(how_many_views(n,ap_height));
        }
        for(int i=1; i<=10;i++){
            System.out.println("#"+i+" "+res_li.get(i-1));
        }

    }
    public static int how_many_views(int n , int[] ap_height){
        int ret = 0;
        for(int i=0; i<n; i++){
            if(ap_height[i]!=0){
                int now = ap_height[i];
                int back_2 =0 ;
                int back_1 =0 ;
                int forward_1 =0 ;
                int forward_2 =0 ;
                if(i-2>=0) back_2 = ap_height[i-2];
                if(i-1>=0) back_1 = ap_height[i-1];
                if(i+1<n) forward_1 = ap_height[i+1];
                if(i+2<n) forward_2 = ap_height[i+2];

                int max_len = Math.max(back_1, Math.max(back_2, Math.max(forward_1,forward_2)));
                if(max_len< now) ret+= now-max_len;
            }
        }
        return ret;
    }
}
