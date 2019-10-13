package ParkJiHoon.ThirdWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PredictWinner {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_n = Integer.parseInt(br.readLine());
        List<String> res = new ArrayList<>();
        for(int i=0; i<case_n ;i++){
            long n = Long.parseLong(br.readLine());
            res.add(get_winner(n));
        }
        for(int i=0;i<case_n;i++){
            System.out.println("#"+(i+1)+" "+res.get(i));
        }
    }
    private static String get_winner(long n){
        int count = 0;
        long x =1;
        while(n>=x){
            if(  2*(2*(2*x+1)+1) > n  && 2*(2*(2*x)+1) <= n) x= 2*x;
            else{
                if((2*x+1)>n && (2*x)<=n) x = 2*x;
                else x= 2*x +1;
            }
            count++;
        }
        if(count%2==0) return "Alice";
        else return "Bob";

    }

}
