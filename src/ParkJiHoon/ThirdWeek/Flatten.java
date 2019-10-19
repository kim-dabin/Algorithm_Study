package ParkJiHoon.ThirdWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Flatten {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_n = 10;
        List<Integer> res  = new ArrayList<>();
        for(int i = 0; i<case_n ; i++){
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            List<Integer> num_li = new ArrayList<>();
            for(String num : line){
                num_li.add(Integer.parseInt(num));
            }
            res.add(get_flatten_count(num_li,n));
        }

        for(int i = 0; i<10; i++){
            System.out.println("#"+(i+1)+" "+res.get(i));
        }
    }
    static int get_flatten_count(List<Integer> num_li,int count){
        int ret;
        Collections.sort(num_li);
        while(count>0){
            //맨앞에있는 값 하나를 빼서 넣음
            int highest = num_li.get(num_li.size()-1);
            num_li.set(num_li.size()-1,highest-1);
            int lowest = num_li.get(0);
            num_li.set(0,lowest+1);
            Collections.sort(num_li);
            count--;
        }
        ret = num_li.get(num_li.size()-1) - num_li.get(0);
        return ret;
    }


}
