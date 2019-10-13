package ParkJiHoon.SecondWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumPrize {
    static int biggest_num_possible = 0;//가능한 가장 큰수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> res_li = new ArrayList<>();

        int n  = Integer.parseInt(br.readLine());
        for(int i=0 ; i<n ; i++){
            String[] line = br.readLine().split(" ");
            int num = Integer.parseInt(line[0]);
            int count = Integer.parseInt(line[1]);

            biggest_num_possible = get_biggest_possible(num);
            res_li.add(biggest_num_make(num,count,1));
        }
        for(int i=1; i<=n;i++){
            System.out.println("#"+i+" "+res_li.get(i-1));
        }

    }
    //가능한 가장 큰수 만들어주기
    public static int get_biggest_possible(int num){
        int ret = 0;
        String[] num_str_arr  = String.valueOf(num).split("");
        Arrays.sort(num_str_arr, Collections.reverseOrder());
        ret = Integer.parseInt(String.join("",num_str_arr));
        return ret;
    }

    //idx 를 통해 들어가는 방향에 순서를 부여함
    public static int biggest_num_make(int num, int count,int idx){
        int ret = 0;
        char[] char_num = String.valueOf(num).toCharArray();

        //base case
        if(count==0) return num;

        //base case
        if(biggest_num_possible == num ){//그만해도됨 - 최대치에 도달한 상황
            if(count%2 ==0) return num;
            else{//맨 마지막거 바꿈

                //똑같은 카드가 있으면 그냥 return
                for(int i=0; i<char_num.length;i++){
                    for(int j=i+1; j<char_num.length;j++){
                        if(char_num[i]==char_num[j]) return num;
                    }
                }

                char temp = char_num[char_num.length-1];
                char_num[char_num.length-1] = char_num[char_num.length-2];
                char_num[char_num.length-2] = temp;

                ret = Integer.parseInt(String.valueOf(char_num));
                return ret;
            }
        }


        for(int i=0; i<char_num.length; i++){
            for(int j=idx ; j<char_num.length ; j++) {

                if(char_num[i] <char_num[j]) {//뒤에 있는게게 더 클때만 바꿈
                    int temp_num = 0;
                    //i번째랑 자리 바꿈
                    char temp = char_num[i];
                    char_num[i] = char_num[j];
                    char_num[j] = temp;

                    //이번 loop에서 바꾼 값을 temp num 으로 들어감
                    temp_num = Integer.parseInt(String.valueOf(char_num));
                    ret = Math.max(ret, biggest_num_make(temp_num, count - 1, j));
                    if (ret == biggest_num_possible) return ret; //그대로 탈출

                    char_num[j] = char_num[i];
                    char_num[i] = temp;
                }

            }
        }

        return ret;
    }
}
