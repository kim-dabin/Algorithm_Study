package week_7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Tetromino {
	
	private static int N,M,max,ch;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] row = {0,1,0,-1};
	private static int[] col = {1,0,-1,0};
	

	//row,col 첫번째랑 같고 cnt가 6번이면 poll 
	public static void shape(int x, int y) {
		
		int min = 9999;
		int sum = map[x][y];
		int cnt =0;
		for(int i=0; i<4; i++) {
			int nx = x+ row[i];
			int ny = y+ col[i];
			if(nx>=0&&nx<N&&ny>=0&&ny<M) {
				cnt++;
				sum+=map[nx][ny];
			
			if(min>map[nx][ny]) {
				min = map[nx][ny];
			}
				
				
				
			} 
			
		
		}
		
		
		if(cnt==4) { 
			sum-=min;
			
		} 
		
		max = Math.max(max, sum);
		
	}
	public static void colcul(int x, int y, int cnt,int sum) {
			
			if(cnt==3) {
				max = Math.max(sum, max);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = x+ row[i];
				int ny = y+ col[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&!visited[nx][ny]) {
					visited[nx][ny]= true;
					colcul(nx, ny, cnt+1, sum+map[nx][ny]);
					visited[nx][ny] =false;
				} 
				
				
			
			
			}
			
			
	}
		



	
	public static void main(String[] args) throws Exception, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		
		N=Integer.parseInt(size[0]);
		M=Integer.parseInt(size[1]);
		max=0;
		map = new int[N][M];
		
		
		int[] check= new int[4];
		visited = new boolean[N][M];
		
		

		
		for(int i=0; i<N;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j]= Integer.parseInt(s[j]);
			}
		}
		
		for(int i=0; i<N;i++) {
			for(int j=0; j<M; j++) {
				visited[i][j]=true;
				colcul(i, j, 0, map[i][j]);
				shape(i, j);
				visited[i][j]=false;
				
			}
		}

		System.out.println(max);
		
		
		
	}

}
