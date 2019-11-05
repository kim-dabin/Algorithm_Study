package week_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Retire {
	private static int num;
	private static int[] times;
	private static int[] pays;
	
	

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		times = new int[num+2];
		pays= new int[num+2];
		int[] dp = new int[num+2];
		
		for(int i=1; i<=num;i++) {
			String[] str = br.readLine().split(" ");
			times[i]= Integer.parseInt(str[0]);
			pays[i]=Integer.parseInt(str[1]);
		}
		
		
		for(int i=1; i<=num+1;i++) {
			
			for(int j=1; j<i;j++) {
				dp[i]=Math.max(dp[i], dp[j]);
				
				if(times[j]+j==i) {
					dp[i]= Math.max(dp[i],dp[j]+pays[j]);
				}
				
			}
			
			
			
		}
		
		System.out.println(dp[dp.length-1]);
		
	}
}
