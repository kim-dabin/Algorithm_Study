package week_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJLaboratory {
	private static int n,m,safeNum,max;
	private static int[][] lab, copyLab;
	private static int[] row = {0,1,0,-1};
	private static int[] col = {1,0,-1,0};
	
	public static class Node{
		int row;
		int col;
		
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void bfs() {
		
		Queue<Node> virus = new LinkedList<Node>();// 바이러스 위치값 
		int[][] virusLab = new int[n][m];
		copyArr(virusLab, copyLab);
		
		
		int sum = (safeNum-3);
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(virusLab[i][j]==2) {
					virus.offer(new Node(i,j));
				}
			}
		}//for end 
		
		while(!virus.isEmpty()) {
			int x = virus.peek().row;
			int y = virus.peek().col;
			virus.poll();
			for(int i=0; i<4; i++) {
				int nr = x+row[i];
				int nc = y+col[i];
				
				if(nr<0||nr>=n||nc<0||nc>=m) continue;
				
				if(virusLab[nr][nc]==0) {//바이러스가 빈 칸을 만나면 
					virusLab[nr][nc]=2; //바이러스 감염 
					--sum; //안전 공간 감소 
					//System.out.println(sum);
					virus.offer(new Node(nr,nc));
				}
				
				
			}
		//	System.out.println(sf);
		}
		
		//System.out.println(sf);
		max = Math.max(sum, max);
		
	}
	
	public static void dfs(int cnt) { //벽 세우기 
		
		
		if(cnt==3) {
			bfs();
			
			return;
		}
		
		
		
		 
		for(int i=0; i<n; i++) { 
			for(int j=0; j<m; j++) {
				if(copyLab[i][j]==0) {
					copyLab[i][j]=1; //벽세우기 
					dfs(cnt+1);
					copyLab[i][j]=0;
				}
			}
		}//for end
		
		
	}
	
	public static void copyArr(int[][] a, int[][] b) {
		for(int i=0; i<n; i++) { //배열 복사 
			for(int j=0; j<m; j++) {
				a[i][j] = b[i][j];
			}
		}//for end
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mapStr = br.readLine().split(" ");
		n = Integer.parseInt(mapStr[0]);
		m = Integer.parseInt(mapStr[1]);
		lab = new int[n][m];
		copyLab = new int[n][m];
		safeNum=0;
		max = 0;
		
		for(int i=0; i<n; i++) {
			String[] dataList = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				lab[i][j]= Integer.parseInt(dataList[j]);
				if(lab[i][j]==0) {safeNum++;}
			}
		}//for end 
		
	
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(lab[i][j]==0) {
					copyArr(copyLab,lab);
					copyLab[i][j]=1;
					dfs(1);
					copyLab[i][j]=0;
				}
				
			}
		}//for end 
		
		System.out.println(max);
		//System.out.println(safeNum);
		
	}
}
