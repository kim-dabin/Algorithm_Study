package week_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class RollingDivice {
	private static int n,m,k; 
	private static int[][] map;
	private static int[] direct;
	private static int[] row = {0,0,0,-1,1}; //1,2,3,4
	private static int[] col = {0,1,-1,0,0}; //동,서,북,남  

	
	public static void swap(int[] d,int ori, int ch) {
		int tmp = d[ori];
		d[ori] = d[ch];
		d[ch] = tmp;
		
	}
	public static void solve(int cnt, int[] divice, int nextX, int nextY) {
		if(cnt==k) {
			return;
		}
		int d = direct[cnt];
		nextX=nextX+row[d];
		nextY=nextY+col[d];
	
		
		//주사위 굴리기 
		
		
		if(map[nextX][nextY]==-1) {
			nextX=nextX-row[d];
			nextY = nextY-col[d];
		}else {
			switch (d) {
			case 1:
				swap(divice,1, 5);//5->1
				swap(divice,2, 0);//0->2
				swap(divice,1, 2);//1<->2
				break;

			case 2:
				swap(divice,2, 5);
				swap(divice,1, 0);
				swap(divice,1, 2);
				break;
			case 3:
				swap(divice,3, 5);
				swap(divice,4, 0);
				swap(divice,3, 4);
				break;
			case 4:
				swap(divice,4, 5);
				swap(divice,3, 0);
				swap(divice,4, 3);
				break;
			}
			
			
			if(map[nextX][nextY]==0) {
				map[nextX][nextY]=divice[5];
			}else if(map[nextX][nextY]>0) {
				divice[5]=map[nextX][nextY];
				map[nextX][nextY]=0;
			}
			
			System.out.println(divice[0]);
		}
	
			solve(cnt+1,divice,nextX,nextY);

	}
	
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] divice = new int[6];//주사위 
	
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);//세로 
		m = Integer.parseInt(str[1]);//가로 
		int x = Integer.parseInt(str[2]);//주사위 위치 
		int y = Integer.parseInt(str[3]);//주사위 위치 
		k = Integer.parseInt(str[4]);//명령 개수 
		map = new int[n+2][m+2];// 지도 
		for(int[] a: map) {
			Arrays.fill(a, -1);
		}
		
		for(int i=1; i<=n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}//for 
		
		
		
		direct = new int[k+1];//주사위 이동 방향 
		String[] s = br.readLine().split(" ");
		for(int i=0; i<k;i++) {
			direct[i]= Integer.parseInt(s[i]);
		}// for end 
		
		solve(0,divice,x+1,y+1);

		
		
	}

}
