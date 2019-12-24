package week_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEARobot {
	private static int n, term, max;
	private static int[][] map;
	private static int[] row = {0,1,0,-1};
	private static int[] col = {1,0,-1,0};
	
	public static class Robot{
		int x,y;
		public Robot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int[][] copy(int[][] ori){
		int[][] copyMap = new int[n][n]; 
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				copyMap[i][j]=ori[i][j];
			}
		}
		
		return copyMap;
	}
	
	
	public static void bfs(int x, int y, int dir) {
		Queue<Robot> q = new LinkedList<Robot>();
		int cnt =0;
		int sum =0;
		int[][] tmp = copy(map);
		q.add(new Robot(x, y));//start 
		while(!q.isEmpty()) {
			Robot robot = q.poll();
			int r = robot.x;
			int c = robot.y;
			//System.out.println(cnt);
			if(cnt==term) {
				max = Math.max(max, sum);
				return;
			}
			
			// 싹이 큼 
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					
					if(tmp[i][j]>0) {
						tmp[i][j]++;
					//	System.out.print(tmp[i][j]+" ");
					}
					
				}
				//System.out.println();
			}
			
			if(tmp[r][c]==0) {
				for(int i=0; i<4; i++) {
					int nd = (dir+i)%4;
					int nr = r+row[nd];
					int nc = c+col[nd];
					
					if(tmp[nr][nc]==0||tmp[nr][nc]>=4) {
						tmp[r][c]=1;
						r = nr;
						c = nc;
						
						break;
					}
					
				}
				
			}else if(tmp[r][c]>=4) {
				tmp[r][c]=0;
				sum++;
				
			}
			
			q.add(new Robot(r, c));
			cnt++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		term = Integer.parseInt(input[1]);
		max = 0;
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			String[] inputMap = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j]= Integer.parseInt(inputMap[j]);
				if(map[i][j]==1) {
					map[i][j]=-1;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int d=0; d<4; d++) {
				if(map[i][j]==0) {
					bfs(i, j, d);
				}
				}
			}
		}
		
		
		System.out.println(max);
	}
}
