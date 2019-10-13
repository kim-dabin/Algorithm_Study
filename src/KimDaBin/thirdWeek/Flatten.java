package thirdWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Flatten {
	public static int max;
	public static int min;
	public static int[] cnt;

	public static void findM() {//최소값 최댓값 찾기 
		while(cnt[max]==0) {
			max--;
		}
		while(cnt[min]==0) {
			min++;
		}
	}

	public static int dump(int size) {
		for(int i=0; i<size; i++) {
			if(max-min<2) break;
			findM();
			cnt[max]--; //100
			cnt[max-1]++;//99 최댓값 1감소 
			
			cnt[min]--;
			cnt[min+1]++;//최소값 1증가 
		}
		findM();//변경된 최소최댓값 찾기 
		return max-min;
	}
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int t = 1; t <= 10; t++)
        {
			int num = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int[] arr = new int[100];
			cnt = new int[100+1];
			
			/* 초기화  */
			max=100;
			min=1;			
			for(int i=0; i<100; i++) {
//				cnt[i+1]=0;
				arr[i]=Integer.parseInt(str[i]);//상자 높이 값 
				
			}//for end
			
			for(int i=0; i<100; i++) {
				cnt[arr[i]]++;// 갯수 세기 1~100까지 
			}//for end
			
			System.out.println("#"+t+" "+dump(num));
			
			
        }//for end

	}

}
