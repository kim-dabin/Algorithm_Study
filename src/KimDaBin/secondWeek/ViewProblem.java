package secondWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ViewProblem {
	private static int[] arr; //입력 받을 배열 
	private static int count; //조망권이 확보된 세대의 수

	
	public static int getMax(int num1, int num2) {
		return num1>=num2?num1:num2; 
	}//compare() end
	
	public static void getCalcul(int idx) {
		int prevMax = getMax(arr[idx-1], arr[idx-2]);
		int nextMax = getMax(arr[idx+1], arr[idx+2]);
		int realMax = getMax(prevMax, nextMax);
		if(arr[idx]>realMax) {
			count+=(arr[idx]-realMax);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int t = 1; t <= 10; t++)
        {
			int n = Integer.parseInt(br.readLine()); //테스트케이스의 길이 
			/*초기화*/
			arr = new int[n];
			count =0; 
			String[] line = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				arr[i]=Integer.parseInt(line[i]);
			}//for end
			
			for(int i=2; i<n-2; i++) {//0을 뺀 배열 값 조회
				getCalcul(i);
			}
			
			System.out.println("#"+t+" "+count); 
		 

        }//for end
		br.close();
		
	}

}
