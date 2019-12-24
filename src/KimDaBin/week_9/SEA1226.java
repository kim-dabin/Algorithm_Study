package week_9;

import java.io.*;
import java.util.*;

public class SEA1226 {
	public static int[][] maze;
	public static boolean[][][] v;
	public static int[] row = {0,1,0,-1};
	public static int[] col = {1,0,-1,0};
	
	public static class Node{
		int r,c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		
		}
	}
	
	public static int bfs(int x, int y) {
		int re = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			//System.out.println(n.r+" "+n.c);
			for(int i=0; i<4; i++) {
				
				int nr = n.r+row[i];
				int nc = n.c+col[i];
				
				if(nr<0||nc<0||nr>=16||nc>=16) {
					continue;
				}
			
				
				if(maze[nr][nc]==0&&!v[nr][nc][i]) {
					//System.out.println(nr+" "+nc);
					v[nr][nc][i] = true;
					q.add(new Node(nr, nc));
				}
				else if(maze[nr][nc]==1) continue;
				
				else if(maze[nr][nc]==3) {
					re = 1;
					return re;
				}
				
			}
			
		}
		
		
		return re;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test = 1; test<=10; test++) {
			int num = Integer.parseInt(br.readLine());
			int x = 0;
			int y =0;
			maze = new int[16][16];
			v = new boolean[16][16][4];
			for(int i=0; i<16; i++) {
				String input = br.readLine();
				for(int j=0; j<16; j++) {
					maze[i][j] = input.charAt(j)-'0';
					if(maze[i][j]==2) {
						x = i;
						y = j;
					}
				}
			}
			//System.out.println(x);
			int re = bfs(x, y);
			System.out.print("#"+num+" "+re+"\n");
			
		}//for testcase
	}
}
