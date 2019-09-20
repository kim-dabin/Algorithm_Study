package firstWeek;

import java.util.Scanner;

public class Num8104 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		int n = sc.nextInt(); // 조별당 인원 수 
		int k = sc.nextInt(); // 조의 개수 
		int result = 0;
		System.out.print("#"+test_case+" ");
		if((n%2)==0) { // 짝수
			
			for(int i =1; i<=n; i+=2) {
				result+=(2*i)*k;	
			}//for end
			result += (n/2);
			for(int i=1; i<=k; i++) {
				System.out.print(result+" ");
			}
		}else {
			
			for(int i =2; i<=(n-1); i+=2) {
				result+=(2*i)*k;
			}//for end
			result += (n/2)+1;
			for(int i=0; i<k;i++) {
				System.out.print(result+i+" ");
			}
		}
			System.out.println();
		}//for end test
		
	}

}
