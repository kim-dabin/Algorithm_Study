package sixthWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;



public class MarbleEscape2 {
	private static int[] row = {0,1,0,-1};
	private static int[] col = {1,0,-1,-0};
	private static char[][] arr;
	private static boolean[][][][] v;
	private static int n,m,rx,ry,bx,by;
	
	public static class Node {
		public int rx, ry, bx, by, cnt;
		
		
		public Node() {}
		
		public Node(int rx, int ry, int bx, int by, int cnt ) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
		
	}//Node end
	
	public static int bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(rx, ry, bx, by, 0));//초기화 
		v[rx][ry][bx][by] = true; 
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.cnt>10) continue;
			if(arr[node.bx][node.by]=='O') continue;
			if(arr[node.rx][node.ry]=='O') return node.cnt;
			
			
			for(int i=0;i<4;i++) {//4방향 
				int next_rx = node.rx;
				int next_ry = node.ry;
				int next_bx = node.bx;
				int next_by = node.by;
				
				while(true) {//red 
					//벽이 아니고 구멍도 아님 
					if(arr[next_rx][next_ry]!='#'&&arr[next_rx][next_ry]!='O') {
						next_rx+= row[i];
						next_ry+= col[i];
					}else {
						//벽일때 이전 상태로 
						if(arr[next_rx][next_ry]=='#') {
							next_rx-= row[i];
							next_ry-= col[i];
						}
						//다음 방향으로 가기위해 나감
						break;
					}
				}//while end
				
				while(true) {//blue
					if(arr[next_bx][next_by]!='#'&&arr[next_bx][next_by]!='O') {
						next_bx+= row[i];
						next_by+= col[i];
					}else {
						//벽일때 이전 상태로 
						if(arr[next_bx][next_by]=='#') {
							next_bx-= row[i];
							next_by-= col[i];
						}
						//다음 방향으로 가기위해 나감
						break;
					}
				}//while end blue
				
				
				//red랑 blue 위치값이 같음 
				if(next_rx == next_bx && next_ry == next_by) {
					if(arr[next_rx][next_ry]!='O') {// 끝은 아닐 때 뒤에 있던 걸 뒤로 옮겨줌 
						int rd = Math.abs(next_rx-node.rx)+ Math.abs(next_ry-node.ry);
						int bd = Math.abs(next_bx-node.bx)+Math.abs(next_by-node.by);
						//큰 값이 뒤에 있었음 
						if(rd>bd) {
							next_rx-= row[i];
							next_ry-= col[i];
						}else {
							next_bx-= row[i];
							next_by-= col[i];
						}
					}
				}
				
				
				
				if(!v[next_rx][next_ry][next_bx][next_by]) {
					v[next_rx][next_ry][next_bx][next_by]= true;
					q.offer(new Node(next_rx, next_ry, next_bx, next_by, node.cnt+1)); // 카운트 증가 
				}
				
				
			}//for end 
		}//while end 
		return -1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		m = Integer.parseInt(size[1]);
		arr = new char[n][m];
		v = new boolean[n][m][n][m];
		rx=0;
		ry=0;
		bx=0;
		by=0;

		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j]=='R') {
					rx=i;
					ry=j;
				}
				if(arr[i][j]=='B') {
					bx=i;
					by=j;
				}
			}//for end 
		}//for end 
		
		
		System.out.println(bfs());
		
	}

}
