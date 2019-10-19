package secondWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PosibleScore {
	private static int num;
	private static int result=0;
	private static int[] arr;
	private static int count =0;
	
	
	public static int partition(int n, int k, int idx) {//n-k
		
		
		return (n == k || k == 1) ? 1 : (k > n || k < 1) ? 0 : partition(n - 1, k - 1, idx+1) + partition(n - k, k, idx+1);


	}
	public static int colcul(int[] arr, int idx) {//idx 맞춰야하는 문제 수 		
		if(idx<=0) {
			return result+1;
		}
		if(idx==1||idx==arr.length) {
			result += ((arr.length*1)/idx);
		}else {
			result +=((arr.length*(num-1))/idx);
		}
//		System.out.println(result);
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
			int re =0;
			int old =0;

			for(int i=0; i< str.length; i++) {
				
				arr[i]=Integer.parseInt(str[i]);
				
				
				for(int k=1;k<=arr[i];k++) {
					old=partition(arr[i],k,i);
					if(old>1) {
						re-=old;
						count++;
					}
						re+=old;
		
				
				}
				
			}
			
			System.out.println("c"+count);
			
			
			bw.write("#"+t+" ");
			bw.write(String.valueOf(re)+"\n");
			bw.write(String.valueOf(colcul(arr, num)));
			bw.write("\n");
			
        }//for end
		 
		 bw.close();
	}



}
