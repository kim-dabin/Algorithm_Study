package week_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RoboticVacuum {
	private static int n,m,r,c,d,cnt;
	private static int[][] map;

	private static int[] row = {-1,0,1,0}; //북 동 남 서 
	private static int[] col = {0,1,0,-1};
	
	
	public static class Robot{
		int row;
		int col;
		int dir;
		public Robot() {
			// TODO Auto-generated constructor stub
		}
		public Robot(int row, int col, int dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
		
	}
	
	
	public static int nextDir(int now) {
		
		
		if(now==0) {
			return 3;
		}else if(now==1) {
			return 0;
		}else if(now==2) {
			return 1;
		}else {
			return 2;
		}
		
	}
	
	
	public static int backDir(int now) {
		
		

		if(now==0) {
			return 2;
		}else if(now==1) {
			return 3;
		}else if(now==2) {
			return 0;
		}else {
			return 1;
		}
		

	}
	
	public static void bfs() {
		Queue<Robot> q = new LinkedList<Robot>();
		
		q.add(new Robot(r, c, d));//시작 
		
		
		while (!q.isEmpty()) {
			int nowR = q.peek().row;
			int nowC = q.peek().col;
			int nowD = q.peek().dir;
			
			if(map[nowR][nowC]==0) {
				map[nowR][nowC] = 2;
				cnt++;
			}
			
			/*큐 하나로만*/
			int nextR = 0;
			int nextC = 0;
			int dir = nowD;
			
			int check = 0;
			q.poll();
			for(int i=0; i<4; i++) {
				//왼쪽방향 탐색 
				dir = nextDir(dir);//다음 왼쪽 방향 
				nextR = nowR+row[dir];
				nextC = nowC+col[dir];
				
				 if(map[nextR][nextC]==0) {
	
					q.add(new Robot(nextR, nextC, dir));
					break;
				
				}else {
					check++;
				}
				
				
			}
		
			
			if(check==4) {
				dir = backDir(dir);
				nextR = nowR+row[dir];
				nextC = nowC+col[dir];
				

				if(map[nextR][nextC]!=1) {
					q.add(new Robot(nextR, nextC, nowD));
				
				
				}
				
			}
			
			
			
		}
		System.out.println(cnt);
		
	}
	
	public static void main(String[] args) throws Exception, IOException {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String[] mapSize = br.readLine().split(" ");
	n= Integer.parseInt(mapSize[0]);
	m= Integer.parseInt(mapSize[1]);
	map=new int[n][m];
	
	String[] robotStatus = br.readLine().split(" ");
	r=Integer.parseInt(robotStatus[0]);
	c=Integer.parseInt(robotStatus[1]);
	d=Integer.parseInt(robotStatus[2]);	
	cnt =0;
	for(int i=0; i<n; i++) {
		String[] data = br.readLine().split(" ");
		for(int j=0; j<m; j++) {
			map[i][j]=Integer.parseInt(data[j]);
		}//for end 
	}//for end 
	
//	for(int[] i : map) {
//		for(int j : i) {
//			System.out.print(j+" ");
//		}
//		System.out.println();
//	}
//	
	
	bfs();
	//System.out.println(cnt);
	}//main end 

}
