package secondWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class PosibleScore3 {
	private static int num;
	private static int result;
	private static int[] arr;
	
	public static int colcul(int[] arr, int idx, int count) {//idx 맞춰야하는 문제 수 		
		if(idx<=0) {
			
			return result+=1;
		}
		if(idx==1||idx==arr.length) {
			result += ((arr.length*1)/idx);
			
		}else {
			result +=((arr.length*(num-1))/idx)-count;
		}
		
		return colcul(arr, idx-1, count);
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
			int re =0;
			int cnt =0;
			result=0;
//			check[0]=1;
			int sum =0;
			for(int i=0; i< str.length; i++) {
				arr[i]=Integer.parseInt(str[i]);
				
				sum =arr[0];
				if(sum!=arr[i]&&i>1) {
					sum+=arr[i];
					cnt++;
//					System.out.println(sum);
				}else if(sum==arr[i]){
					re++;
				}else {
					sum=0;
				}
								
				
			}
		
			
			
			
			
			bw.write("#"+String.valueOf(t)+" ");

			
			
			bw.write(String.valueOf(colcul(arr, re==num?1:num, cnt)));
			bw.write("\n");
			
        }//for end
		 bw.flush();
		 bw.close();
		 br.close();
	}




}
