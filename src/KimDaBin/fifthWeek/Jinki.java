package fifthWeek;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class Jinki {
	private static int[] arr;
	private static int[] customArr;
	
	public static void solve() {
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		int T;
		T=Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			arr = new int[11112];
	
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			int k = Integer.parseInt(line[2]);
			
			
			int len = (int) Math.ceil(n%k==0?n/k:n/k+1);
			//bw.append(String.valueOf(len)+"\n");
			for(int i=m; i<=arr.length; i+=m) {//붕어빵 팔만큼 넣기 
				if(i<=11111) {
				//	bw.append(String.valueOf(len)+"\n");
					arr[i] = k;
					len--;
					if(len==0) break;
				}
				
			}
//			for(int a :arr) {
//				bw.append(String.valueOf(a));
//			}
			//bw.append("\n");
			String[] cusLine = br.readLine().split(" ");
			customArr = new int[cusLine.length]; 
			for(int i=0; i< cusLine.length; i++) {
				customArr[i]= Integer.parseInt(cusLine[i]);
			}
			
			Arrays.sort(customArr);
			
			boolean no = true;
			String result ="";
			for(int i=0; i<customArr.length; i++) {
				for(int j=0; j<=customArr[i];j++) {
					if(arr[j]>0) {
						arr[j]--;
						no = false;
						break;
					}else {
						no = true;		
						
					}
				}
				if(no) {
					result="Impossible";
					break;
				}else{
					result="Possible";
				}

			}
		bw.append("#"+test_case+" "+result+"\n");
//			
//			for(int a :arr) {
//				bw.append(String.valueOf(a));
//			}
//			
//			
			
			
		}//for
		br.close();
		bw.flush();
		bw.close();
	}//main

}
