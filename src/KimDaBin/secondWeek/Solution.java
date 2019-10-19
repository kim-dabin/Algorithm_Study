package secondWeek;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Solution
{
   private static int num;
	private static int result;
	private static int[] arr; 
public static int partition(int n, int k, int idx) {//n-k
		
		
		return (n == k || k == 1) ? 1 : (k > n || k < 1) ? 0 : partition(n - 1, k - 1, idx+1) + partition(n - k, k, idx+1);


	}
	public static int colcul(int[] arr, int idx, int count) {//idx 맞춰야하는 문제 수 		
		if(idx<=0) { //0
			return result+=1;
		}
		if(idx==1||idx==arr.length) {//1 or 만점(4개)
			result += ((arr.length*1)/idx);
			//1,2,3,4 
		}else {// 두개=> 1+2/1+3/1+4/2+3/2+4/3+4 
			result +=((arr.length*(num-1))/idx)-count; //5*4/3 =>20/3
		}
		 
		return colcul(arr, idx-1, count);
	}
	public static void main(String args[]) throws IOException
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		int T;
		T=Integer.parseInt(br.readLine());
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			num=0;
			 
			
			num = Integer.parseInt(br.readLine()); //문제 수
			String[] str = br.readLine().split(" ");
			arr = new int[str.length];// 배점 
			int[] check = new int[101];
			Arrays.fill(check, 0);
			int re =0;
			int cnt =0;
			result=0;

			int sum =0;
			for(int i=0; i< str.length; i++) {
				arr[i]=Integer.parseInt(str[i]);
				
				sum=arr[0];
				if(sum!=arr[i]&&i>0) {
					sum+=arr[i];//1+2=3
				}else {
					System.out.println(sum);
					sum=0;
				}
				for(int k=1;k<=arr[i];k++) {
					re+=partition(arr[i],k,i);
				}
								
				
			}
			System.out.println(sum);
			
		
			System.out.println("#"+test_case+" "+colcul(arr, re>1?num-re:num, cnt));
		

		
		}

         bw.flush();
		 bw.close();
		 br.close();
		
		
	}
}