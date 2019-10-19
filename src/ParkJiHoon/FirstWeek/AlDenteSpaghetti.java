package ParkJiHoon.FirstWeek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AlDenteSpaghetti {
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream(&quot;res/input.txt&quot;));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        List<Integer> res = new ArrayList<>();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            String line1 = br.readLine();
            String line2 = br.readLine();
            int ret = al_dente_spaghetti(line1,line2);
            if(ret == Integer.MAX_VALUE) ret = 0;
            res.add(ret);

            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
        int test_case = 1;
        for(Integer ret: res){ System.out.println("#"+test_case +" "+ret); test_case++;}
    }

    static int min = 0;
    static int max = 0;
    static Integer[] hourglasses;
    static int ret = Integer.MAX_VALUE;
    public static int al_dente_spaghetti(String line1, String line2){
        int ret_fi = 0;
        String[] line1_split = line1.split(" ");
        String[] line2_split = line2.split(" ");

        ret = Integer.MAX_VALUE;
        hourglasses = new Integer[Integer.parseInt(line1_split[0])];


        for(int i = 0; i<hourglasses.length; i++) hourglasses[i] = Integer.parseInt(line2_split[i]);
        List<Integer> list = Arrays.asList(hourglasses);
        Collections.reverse(list);
        hourglasses = list.toArray(new Integer[list.size()]);
        int B = Integer.parseInt(line1_split[1]);

        int E = Integer.parseInt(line1_split[2]);
        min = B-E;
        max = B+E;
        ret_fi = get_more_hourglass(0, 0);



        return ret_fi;
    }

    private static int get_more_hourglass(int sum, int count){
        //base case 기존 값보다 넘어가면
        if(count > ret) return ret;
        //base case 넘을때
        if(sum>max) return Integer.MAX_VALUE;
        //base case 범위에 들어갈때
        if(min<=sum  && sum<=max) return count;

        if(sum < min) {
            for (int time : hourglasses) {
                count++;
                ret = Math.min(get_more_hourglass(sum+time, count), ret);
                if(ret != Integer.MAX_VALUE) return ret;
                count--;
            }
        }
        return ret;

    }

}
