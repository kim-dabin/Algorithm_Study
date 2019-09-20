package firstWeek;

import java.util.Scanner;

public class Num8338 {
	/* 방탈출 카페 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//test case
		int T = scan.nextInt();
		int testcase = 0;
		while(T>testcase) {
			int n = scan.nextInt();//정수 값 
			int [] numArr = new int[n]; // N개의 정수 
			
			int result=0; //계산 결과 
			
			for(int i=0; i<n; i++) {
				numArr[i] = scan.nextInt();
			}
			
			for(int i =0; i<numArr.length;i++) {
				
				if(numArr[i]>1&&result>1) {
					result*=numArr[i];
				}else {
					result+=numArr[i];
				}
			}//for end
			testcase++;
			System.out.println("#"+testcase+" "+result);
			
		}

 	}

}
