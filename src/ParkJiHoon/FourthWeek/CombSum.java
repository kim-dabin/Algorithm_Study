package ParkJiHoon.FourthWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CombSum {
    static List<Integer> li_nums;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_n = Integer.parseInt(br.readLine());
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<case_n ; i++){
            String[] line1 = br.readLine().split(" ");
            String[] nums = br.readLine().split(" ");

            li_nums = new ArrayList<>();
            for(String num : nums) li_nums.add(Integer.parseInt(num));
            k = Integer.parseInt(line1[1]);
            ret = 0;
            dfs(0,0);
            res.add(ret);

        }
        for(int i = 0; i<case_n; i++){
            System.out.println("#"+(i+1)+" "+res.get(i));
        }
    }

    static int ret = 0;
    private static void dfs(int idx, int sum){
        //base case
        if(sum==k) {ret++;return;}
        if(idx>=li_nums.size() || sum>k) return;

        //넣고
        dfs(idx+1,sum+li_nums.get(idx));
        //없이
        dfs(idx+1,sum);
    }


    private static int how_many_SubSums(List<Integer> nums , int k){
        int ret = 0;
        int n = nums.size();

        //power set 구하기
        for(int i=0; i < 1<<n; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                if((i & 1<<j) != 0) {
//                    System.out.print(arr[j] + " ");
//                    temp.add(nums.get(j));
                    sum+= nums.get(j);
                    if(sum>k) break;
                }
            }
            if(sum==k) {ret++; }
//            ret.add(temp);
//            System.out.println();
        }

        return ret;
    }



}
