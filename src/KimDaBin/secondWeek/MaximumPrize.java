package secondWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.org.apache.xpath.internal.operations.NotEquals;




/*
 * 1244. [S/W 문제해결 응용] 2일차 - 최대 상금
 * 
 * */
public class MaximumPrize {

	private static int count; 
	private static boolean[] flag;
	 public static void swap(int ori, int[] arr, int max) {
	       
         int tmp = arr[ori];
         arr[ori]= arr[max];
         arr[max]= tmp;
}

   public static void solve(int[]arr, int mxNum) {
	  // 가장 큰 값의 인덱스 저장하는 변수
	  
	
		int idx=1;
		int cnt=0;
		while(count>0) {

			mxNum=arr.length-1;

				 for(int j=arr.length-1;j>=(idx-1);j--) { //선택한 원소가 가장 큰 수인지 다른 것들과 비교
	            	 if((j-1)>=(idx-1)&&arr[j-1]>arr[mxNum]) {
	 					mxNum = j-1; 			
	 					
	 				} 
	            	
	             }// for end
				 
				
				swap(idx-1, arr, mxNum);
				flag[idx-1]=true;
				idx++;
				
				
				if(mxNum==(idx-1)) {
					cnt++;
					 continue;
				 }
					
				
				
				
				
//				if(mxNum==(idx-1)) {
//					continue;
//				} 
				count--;
					
				
					
				
				
			
	             if(idx>arr.length) {
					 idx=1;
					 
				 }
	             
		}
		
		
		
		
		
//		for(int i=arr.length-1;i>0;i--) {
//			mxNum=i;
//			 for(int j=i-1; j>=0; j--) {
//				if(arr[j]>arr[mxNum]&&!flag[mxNum]) {
//					mxNum = j;
//					flag[mxNum]=true;
//					
//				}else if(arr[j]<=arr[mxNum]){
//					flag[mxNum]=true;
//					
//				}else {
//					flag[mxNum] =false;
//				}
//			 }
//			 if(count>=0&&flag[mxNum]) {
//				 swap(idx, arr, mxNum);
//				 idx++;
//				 System.out.println(count);
//				 flag[mxNum]=false;
//				 flag[idx]=true;
//				 count--;
//				 if(idx>arr.length) {
//					 idx=0;
//				 }
//			 }
//			 if(count<0) {
//				 break;
//			 }
//			
//		}
//	
	
	
	
//	
	
//	System.out.println(max.toString());
	   
//       for(int i=0;i<arr.length-1;i++) {
//             for(int j=i+1; j<arr.length ; j++) { //선택한 원소가 가장 큰 수인지 다른 것들과 비교
//                  if(max.get(i)!=0) {
//                	 
//                  }
//                  
//                   
//             }// for end
//       }//for end
      
   }//selectionSort end
	 
	

		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		 int tSize=Integer.parseInt(br.readLine());
		
		 for(int t = 1; t <= tSize; t++)
        {
			/* 초기화 */
			String[] line = br.readLine().split(" ");
			int[] arr = new int[line[0].length()];
			flag = new boolean[line[0].length()];
			 for (int i = 0; i < line[0].length(); i++) {
	                arr[i] = line[0].charAt(i) - '0';
	                flag[i] = false;
	           }
			count = Integer.parseInt(line[1]);
//			
			bw.write("#"+t+" ");
			solve(arr,0);
			for(boolean b : flag) {
				bw.write(String.valueOf(b)+" ");
			}
			bw.write("\n");
			for(int a : arr) {
				bw.write(String.valueOf(a));
			}
		

			bw.write("\n");
			
        }//for end
		 
		 bw.close();
	}

}
