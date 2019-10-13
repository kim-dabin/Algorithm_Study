package thirdWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CombSum {
	public static int cnt,k,n;
	public static int[] arr; 
	
	public static void solve(int idx, int sum) {	
		if(sum>k || idx>n-1) {
			if(sum==k) { 
				cnt++;
			}
			return;
		}
		
		solve(idx+1, sum+arr[idx]);
		solve(idx+1, sum);	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			k = Integer.parseInt(str[1]);
			arr = new int[n];
			String[] line = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				arr[i]=Integer.parseInt(line[i]);
			}//for end
			

			cnt=0;
			solve(0,0);
			bw.append("#"+test_case+" "+cnt+"\n");
			
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
}
