package week_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestSupervision {
	
	
	public static long solve(int[] arr, int b, int c) {
		long cnt = 0l;

		for(int i=0; i<arr.length; i++) {
			int a = arr[i]-b;
			if(a>0) {//부감독관이 필요 없을 때는 계산을 하지 않음 
				cnt+=(a%c==0?(a/c):(a/c+1));
			}
			
		}
		
		return cnt;
	}

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());//시험장 개수 
		int[] arr = new int[num];//시험 응시자수 배열 
		String[] str = br.readLine().split(" ");
		for(int i=0; i<num; i++) {
			arr[i]=Integer.parseInt(str[i]);
		}
		String[] sup = br.readLine().split(" ");
		int b = Integer.parseInt(sup[0]);//총감독관이 맡는 응시자 수 
		int c = Integer.parseInt(sup[1]);//부감독관이 맡는 응시자 수 
		 
		
		System.out.println(solve(arr, b, c)+num);//부감독관 수 +총감독관 수 
	}

}
