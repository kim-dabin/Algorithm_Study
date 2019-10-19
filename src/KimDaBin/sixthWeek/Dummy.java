package sixthWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Dummy {
	private static int N,K,L;
	private static int[][] map;
	private static int[] row = {0,1,0,-1};
	private static int[] col = {1,0,-1,-0};

	private static Queue<Node> body;
	private static String[] dir;

	public static class Node{
		private int row;
		private int col;
		public Node() {
		}
		
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void dfs(int type, int dr, int dc, int t) {
		if(dir[t].equals("D")) {

			switch (type) {
			case 0:
				type = 1;
				break;
			case 1:
				type = 2;
				break;
			case 2:
				type = 3;
				break;
			case 3:
				type = 0;
				break;
			}
		} 
		else if(dir[t].equals("L")) {
			switch (type) {
			case 0:
				type = 3;
				break;
			case 1:
				type = 0;
				break;
			case 2:
				type = 1;
				break;
			case 3:
				type = 2;
				break;
			}
		}
		

		 if(map[dr][dc]>0) {
	
			map[dr][dc]=-1;
			body.add(new Node(dr, dc));
			
			
		} else if(map[dr][dc]==0) {//apple x 
			if(!body.isEmpty()) {//snake length>1
				map[body.peek().row][body.peek().col]=0;
				body.poll();
			}
				map[dr][dc]=-1;

				body.add(new Node(dr, dc));
		}
		else if(map[dr][dc]<0) { //exit 
			System.out.println(t);
		return;
		} 
		 
		
		
		
		
		dfs(type, dr+row[type], dc+col[type], t+1);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		body = new LinkedList<Node>();
		map = new int[N+2][N+2];
	
		for(int i=0; i<N+2; i++) { //padding 
			for(int j=0; j<N+2; j++) {
				map[i][j]=-1;
			}
		}
		K = Integer.parseInt(br.readLine());//사과 개수
		for(int i=0; i<K; i++) {
			String[] s = br.readLine().split(" ");
			map[Integer.parseInt(s[0])][Integer.parseInt(s[1])]=1;
		}
		
	
		
		L = Integer.parseInt(br.readLine());//뱀 방향 횟수
		dir = new String[10001];
		Arrays.fill(dir, "");
		for(int i=0; i<L; i++) {
			String[] s = br.readLine().split(" ");
			dir[Integer.parseInt(s[0])]= s[1];
		}
			
	
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j]<0) {
					map[i][j]=0;
				}
			
				
			}
		}
		
		
		dfs(0, 1, 1,0);
		

		
	}

}
