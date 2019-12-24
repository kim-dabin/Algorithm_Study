package week_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Security {
	private static int[][] map;
	private static Queue<Node> q;
	private static int totalN,n,m, min;
	private static int[] x = {0,1,0,-1}; //오른쪽 아래 왼쪽 위 
	private static int[] y = {1,0,-1,0};
	private static boolean[][] v;
	public static class Node{
		int row; 
		int col;
		int cctv;
		
		public Node(int row, int col, int cctv) {
			this.row = row;
			this.col = col;
			this.cctv =cctv;
		}
	}
	
	public static int[][] copyArr(){
		int[][] arr = new int[n+2][m+2];
		for(int i=0; i<n+2; i++) {
			for(int j=0; j<m+2;j++) {
				arr[i][j]=map[i][j];
			}
		}
		
		
		return arr;
		
	}
	
	
	public static void bfs() {

		
		v = new boolean[n][m];
		int total = totalN;
		while(!q.isEmpty()) {
			
			Node node = q.poll();
			int cctv = node.cctv;
			int row = node.row;
			int col = node.col;
			min = Math.min(min, total);
			for(int i=0; i<4; ) {
				int[][] copyMap  = copyArr();//원본 배열 복사 
				
				
				int idx =0;
				int nr =row;
				int nc =col;
				if(i==0) {
					
				
				while(true) {
					
					nr+=x[i];
					nc+=y[i];
					
					if(copyMap[nr][nc]!=6) {
						if(copyMap[nr][nc]==0) total--;
						copyMap[nr][nc]=-1;
						continue;
					//System.out.println(nc);
					
					}else if(copyMap[nr][nc]==6) {
						 i++;
						break;
					}
				}
				}
				 nr = row;
				 nc = col;
				
				if(i==2) {
					
					while(true) {
						idx =(i+2>3)?i+2-4:i+2;
						
							 nr +=x[idx];
							 nc +=y[idx];
					
						if(copyMap[nr][nc]!=6) {
							if(copyMap[nr][nc]==0) total--;
							copyMap[nr][nc]=-1;
							continue;
						
						
						}else if(copyMap[nr][nc]==6) {
							i++;
							break;
						}

						
					}
					
				}//if end 
				if(i==3) {
					
					
					while(true) {
						
						idx =(i+3>3)?i+3-4:i+3;
						
						 nr +=x[idx];
						 nc +=y[idx];
			
						if(copyMap[nr][nc]!=6) {
							if(copyMap[nr][nc]==0) total--;
							copyMap[nr][nc]=-1;
							continue;
						
						}else if(copyMap[nr][nc]==6) {
							i++;
							break;
						}
			
					}
					
				}//if end 
				if(i==1) {
					
					
					while(true) {
						
						idx =(i+5>3)?i+5-4:i+5;
						
						 nr +=x[i];
						 nc +=y[i];

						if(copyMap[nr][nc]!=6) {
							if(copyMap[nr][nc]==0) total--;
							copyMap[nr][nc]=-1;
							continue;
						
						
						}else if(copyMap[nr][nc]==6) {
							i++;
							break;
						}
			
					}
					
				}//if end 
				
			
				//System.out.println(min);
			}//for end 
			
			
			
			
			
		
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		q = new LinkedList<Security.Node>();
		map = new int[n+2][m+2];
		totalN =0;
		min = Integer.MAX_VALUE;
		for(int[] ma: map) {
			Arrays.fill(ma, 6);
		}
		
		for(int i=1; i<=n; i++) {
			String[] data = br.readLine().split(" ");
			for(int j=1; j<=m; j++) {
				map[i][j]= Integer.parseInt(data[j-1]);
				if(map[i][j]>0&&map[i][j]<6) {
					q.add(new Node(i, j, map[i][j]));
					
				}else if(map[i][j]==0) {
					totalN++;
				}
			}
		}//for end 
		
		
		bfs();
		System.out.println(min);
//		for(int[] ma: map) {
//			System.out.println(Arrays.toString(ma));
//			
//		}
	}

}
