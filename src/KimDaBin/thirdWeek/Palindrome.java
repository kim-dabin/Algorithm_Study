package thirdWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Palindrome {

	public static int isPalindrome(char[][] arr, int size ) {
		int cnt=0;
		
		for(int i=0; i<8; i++) {//시작 부분 
			for(int j=0; j<8-size+1; j++) {//끝 부분 
				boolean checkX=true;
				boolean checkY=true;
				for(int k=0; k<size/2; k++) {
					if(arr[i][j+k]!=arr[i][j+size-1-k]) {
						checkX = false;
					}
					if(arr[j+k][i]!=arr[j+size-1-k][i]) {
						checkY = false;
					}
				
				}
				if(checkX) cnt++;
				if(checkY) cnt++;
			}
		}
		
		
		return cnt;
	}//isPalindrome() end 
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		for(int t = 1; t <= 1; t++)
        {
			int num = Integer.parseInt(br.readLine().trim()); //회문 길이 
			
			
			char[][] arr = new char[8][8];
			
			int cnt =0;
			String str = null;
		
			for(int i=0; i<8; i++) {
				str = br.readLine();
				for(int j=0; j<8;j++) {
					arr[i][j] = str.charAt(j);
					
				}
				
			}
		
			
			
			
			bw.append("#"+t+" "+String.valueOf(isPalindrome(arr, num)));
			bw.write("\n");

	
        }//for end
		bw.flush();
		bw.close();
		br.close();
	}
}
