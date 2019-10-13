package thirdWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Harvesting {
	private static int[][] arr;
	private static int up=-1, down=-1, left=-1, right =-1;
	
	public static void checkArr(int num) { //num = N/2
		for(int i=1;i<=num;i++) {
            for(int j=1; j<=num; j++) {
            
                up = arr[i-1][j];
                down = arr[i+1][j];
                left=arr[i][j-1];
                right=arr[i][j+1];
                
                if(arr[i][j]<up && arr[i][j]<down && arr[i][j]<left && arr[i][j]<right) {
                    arr[i][j]=-1;//*
                }
                
                
            }//for end
        }//for end
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		int T = Integer.parseInt(br.readLine().trim());
		 
		for(int test_case = 1; test_case<= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); //농장 크기 
			arr=new int[N+2][N+2];//패딩
		
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					arr[i][j]=6;
				}
			}
	
			
			for(int i=1; i<=N; i++) {
				String str = br.readLine();
				for(int j=1; j<=N; j++) {
					arr[i][j]= str.charAt(j-1)-48;
				}
				
			}
		
			checkArr(N/2);
			
			
			for(int[] a: arr) {
				for(int b: a) {
					System.out.print(b+" ");
				}
				System.out.println();
			}
			
		}
		bw.flush();
		 bw.close();
		 br.close();
	}//main end
}
