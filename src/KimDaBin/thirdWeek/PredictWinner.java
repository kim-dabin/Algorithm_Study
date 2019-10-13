package thirdWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/* 등비수열 합공식으로 다시 풀어보기 */
public class PredictWinner {
	public static long cnt;
	public static long n;
	public static void solve(long x, long sum) {	
		if(sum>n||x>n) {
			return;
		}
		cnt++;
		solve(x+1,sum==n?2*x:2*x+1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = Long.parseLong(br.readLine());
			cnt=Long.valueOf(1);
			String win=null;
			if(n>0&&n<4) {
				win=n==1?"Bob":"Alice";
				//bw.append("#"+test_case+" "+win+"\n");
			}else {
			solve(0,0);
			win=(cnt%2)==0?"Bob":"Alice";
			
			}
			//bw.append(String.valueOf(cnt));
			bw.append("#"+test_case+" "+win+"\n");
						
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
