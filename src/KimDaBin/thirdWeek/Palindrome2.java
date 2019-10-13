package thirdWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Palindrome2 {
	public static boolean[][] visited;

	public static int isPalindrome(char[][] arr, int size ) {
		int cntx=0, cnty=0;
		int max=0;
		for(int i=0; i<100; i++) {//시작 부분 
			for(int j=0; j<100-size+1; j++) {//끝 부분 
				for(int k=0; k<size/2; k++) {
					if(arr[i][j+k]==arr[i][j+size-1-k]&&!visited[i][j+k]) {
						visited[i][j+k]=true;
						cntx++;
					}else {
						cntx=0;
					}
					if(arr[j+k][i]==arr[j+size-1-k][i]&&!visited[j+k][i]) {
						visited[j+k][i]=true;
						cnty++;
					}else {
						cnty=0;
					}
					max=Math.max(cnty, cntx);
				}
				
				
			}
			
		}
		
		
		return max;
	}//isPalindrome() end 
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		for(int t = 1; t <= 1; t++)
        {
			int num = Integer.parseInt(br.readLine().trim()); //회문 길이 
			
			
			char[][] arr = new char[100][100];
			visited = new boolean[100][100];
			int cnt =0;
			String str = null;
		
			for(int i=0; i<100; i++) {
				str = br.readLine();
				for(int j=0; j<100;j++) {
					arr[i][j] = str.charAt(j);
					
				}
				
			}
			
			for(boolean[] ba: visited) {
				for(boolean b: ba ) {
					bw.append(b+" ");
				}
				bw.append("\n");
			}
		
			
			
			
			bw.append("#"+t+" "+String.valueOf(isPalindrome(arr, num)));
			bw.write("\n");

	
        }//for end
		bw.flush();
		bw.close();
		br.close();
	}
}
