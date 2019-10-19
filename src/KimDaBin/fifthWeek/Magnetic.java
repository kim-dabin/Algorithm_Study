package fifthWeek;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Magnetic {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int size = Integer.parseInt(br.readLine());//크기 
			
			int[][] arr = new int[size+2][size+2];//패딩 만들기 
			int cnt=0;
			boolean check=false;
			
			for(int i=0; i<size+2;i++) {
				for(int j=0; j<size+2;j++) {
				arr[i][j]=-1; //패딩 부분 -1로 초기화 
				}
			}
			
			
			for(int i=1; i<=size; i++) {//1~100
				String[] line = br.readLine().split(" ");
				for(int j=1; j<=size; j++) {
					arr[i][j]= Integer.parseInt(line[j-1]);
				}
			}
		
			for(int i=1; i<=size;i++) {//100
				for(int j=1; j<size+2; j++) {					
					if(arr[j][i]==1) {
							check=true;
					}else if(arr[j][i]==2&&check) {//자석 붙음 
							check=false;
							cnt++;
					}else if(check&&arr[j][i]<0) {//열에 1만 있을 경우 
						check=false;
					}
					
				}
				
			}//for end 
	
			
			bw.append("#"+test_case+" "+String.valueOf(cnt)+"\n");
		

		
			
			

			
		}//for
		br.close();
		bw.flush();
		bw.close();
	}//main

}
