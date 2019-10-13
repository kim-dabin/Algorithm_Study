package ParkJiHoon.FifthWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://4ngs.tistory.com/4
 *
 * 모르겠어요 ㅠㅠ 죄송합니다. - 왜 6~9에 들어가면 Bob인지 모르겠어요..
 * n/2 + 1(상대는 공격) 과 n/2 -1(다시 나는 방어) 을 통해서 최선의 수를 구현한것 같은데 :이것도 잘은 모르겠습니다.
 *
 */
public class PredictWinner {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_num = Integer.parseInt(br.readLine());
        List<String> ret = new ArrayList<>();
        for(int i= 0 ;i<case_num ; i++){
            long n = Long.parseLong(br.readLine());
            ret.add(predict_winner(n));

        }

        for(int i=0 ; i<case_num;i++){
            System.out.println("#" +(i+1)+" "+ret.get(i));
        }
    }
    private static String predict_winner(long N){
        String s = "Alice";
        while(N > 10) {
            N = (N/2) + 1;
            N = (N/2) - 1;
        }
        if( N == 1 || (N >= 6 && N <= 9)){
            s = "Bob";
        }
        return s;
    }
}
