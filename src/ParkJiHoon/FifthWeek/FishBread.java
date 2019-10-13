package ParkJiHoon.FifthWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FishBread {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_num = Integer.parseInt(br.readLine());
        List<String> res = new ArrayList<>();
        for(int i=0; i <case_num ; i++){
            String[] line = br.readLine().split(" ");
            String[] people_time = br.readLine().split(" ");
            res.add(isPosible(Integer.parseInt(line[1]),Integer.parseInt(line[2]),people_time ));

        }

        for(int i=0; i<case_num;i++){
            System.out.println("#"+(i+1)+" "+res.get(i));
        }
    }
    static String isPosible(int M, int K, String[] people_time){
        String ret  = "Impossible";
        List<Integer> int_people_time = new ArrayList<>();
        for(int i = 0 ; i<people_time.length; i++) int_people_time.add(Integer.parseInt(people_time[i]));
        Collections.sort(int_people_time);
        int now_time = 0;
        int prev_K = 0;
        int next_K = K;
        while(prev_K<int_people_time.size()){
            now_time += M;
            for(int i=prev_K; i<next_K;i++){
                if(int_people_time.size()>i) {
                    if (int_people_time.get(i) >= now_time) continue;
                    else return "Impossible";
                }
            }
            next_K += K;
            prev_K += K;
        }
        return "Possible";
    }
}
