package secondWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class PosibleScore2 {
	private static int num;
	private static int result;
	private static int[] arr;
	
	public static int colcul(int[] arr, int idx) {//idx 맞춰야하는 문제 수 		
		if(idx<=0) {
			return result+=1;
		}
		if(idx==1||idx==arr.length) {
			result += ((arr.length*1)/idx);
			
		}else {
			result +=((arr.length*(num-1))/idx);
		}
		
		return colcul(arr, idx-1);
	}

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		 int tSize=Integer.parseInt(br.readLine().trim());
		
		 for(int t = 1; t <= tSize; t++)
        {
			num = Integer.parseInt(br.readLine()); //문제 수 
			
			String[] str = br.readLine().split(" ");
			arr = new int[str.length];// 배점 
			int[] check = new int[101];
			Arrays.fill(check, 0);
			int cnt =0;
			result=0;
			check[0]=1;
			for(int i=0; i< str.length; i++) {
				
				arr[i]=Integer.parseInt(str[i]);
			}
			
			int sum =0;
			for(int i=0; i< str.length; i++) {
				
				for(int j=0; j<4; j++) {
					
					System.out.println(arr[i]+" "+check[arr[i]]);
					check[sum]++;	
					
				}
				if(check[arr[i]]>1) {
					cnt++;
				}
				
				
			}
			
			
			
			System.out.println(check.length);
			
			
			
			bw.append("#"+String.valueOf(t)+" "+String.valueOf(colcul(arr, num-cnt))+"\n");
			
		
			
        }//for end
		 bw.flush();
		 bw.close();
		 br.close();
	}



}
