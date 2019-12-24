package basic;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("크기 : ");
		int n= scan.nextInt(); // 별 한쪽면 개수 입력값 
		int cnt =0; // 가로 증가 카운트 변수 선언 및 초기화 
		for(int i=-n; i<n-1; i++) {//5를 예시로 -5,-4,-3,-2,-1,0,1,2,3 => n*2-1번 반복 
			for(int j=1; j<(n+cnt); j++) {//
				String str = (j==Math.abs(i>=0?i+2:i))?"*":" ";
				System.out.print(str);//별 찍기 
			}
			System.out.print("*");//마지막 별 찍기 
			System.out.println();//줄바꿈 
			cnt=i<-1?cnt+1:cnt-1;// 위의 삼각형인지 아래의 삼각형인지 구분
			
		
		}
		

	}

}
