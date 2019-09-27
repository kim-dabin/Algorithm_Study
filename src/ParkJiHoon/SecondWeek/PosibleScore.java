package ParkJiHoon.SecondWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PosibleScore {
    static TreeSet<Integer> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> res_li = new ArrayList<>();

        int case_n  = Integer.parseInt(br.readLine());
        for(int i=0 ; i<case_n ; i++){
            int n  = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            HashMap<Integer, Integer> num_count = new HashMap<>();
            for(int j=0; j<n ; j++){
                int num = Integer.parseInt(line[j]);
                if(num_count.containsKey(num)) num_count.put(num, num_count.get(num)+1);
                else num_count.put(num,1);
            }
            res= new TreeSet<>();
            res.add(0);
            res_li.add(get_possible_score(num_count));
        }

        for(int i=1; i<=case_n;i++){
            System.out.println("#"+i+" "+res_li.get(i-1));
        }
    }
    private static int get_possible_score(HashMap<Integer,Integer> num_count){
        Iterator<Integer> it = num_count.keySet().iterator();
        List<Integer> nums ;

        while(it.hasNext()){//있으면
            nums = new ArrayList<>();
            int num = it.next();
            int count = num_count.get(num)+1;//0포함  +1
            for(int i=1; i<count;i++){
                for(Integer n : res) nums.add(n+ num*i);

            }
            res.addAll(nums);
        }
        return res.size();
    }


    //recursive-dfs로 들어갈 필요도 없음 - 0을 넣어주는 상황을 무시하고 그냥 더해주면 됨
    /*private static void rec_add_nums(List<int[]> nums, int sum, int idx){
        //base case
        if(nums.size() == idx) {res.add(sum); return ;}

        for(int num : nums.get(idx)){
            rec_add_nums(nums, sum+num, idx+1);
        }
        return ;
    }*/


}
