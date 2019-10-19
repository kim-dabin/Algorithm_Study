package secondWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class SupplyRoute {
	public static Queue<Node> queue;
	public static boolean v;
	public static int[][] map;
	public static int[][] checkMap;
	public static int size;
	private static int[] dirY = {0,1,0,-1};
	private static int[] dirX = {1,0,-1,-0};
		
	public static class Node {
		public int row; //row 열 y
		public int col; //column 행 x
		public int check; //왔던거 확인 
		public Node() {}
		public Node(int x, int y, int c) {
			this.row = y;
			this.col = x;
			this.check = c;
		}
		
	}//Node end
	
	public static Node getQueue(Queue<Node> queue) {
		
		int c = queue.peek().col;
		int r = queue.peek().row;
		int data = queue.peek().check;
		
		return new Node(c,r,data);
	}
	
	public static int setQueue() {
		queue = new LinkedList<Node>(); // queue 생성 
		/*insert */
		queue.offer(new Node(0,0,0));//출발점
		
		while (!queue.isEmpty()) {
		Node cur = getQueue(queue);
		queue.poll();
		for(int i =0; i<4;i++) {
			int nx = cur.col + dirX[i];
			int ny = cur.row + dirY[i];
			
			if(nx<0||ny<0||nx>=size||ny>=size) {
				continue;
			}
			
			int cnt = cur.check+map[nx][ny];//0+value
//			System.out.println(cur.check);
			
			if(cnt>=checkMap[nx][ny]) continue;//999999
			checkMap[nx][ny] = cnt;
			queue.offer(new Node(nx,ny,cnt)); //이동한 위치 
		}//for end
		
		}//while end
		return checkMap[size-1][size-1];
	}//createQueue() end
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int test_case = 1; test_case<= T; test_case++) {
			// 지도 크기 
			size = Integer.parseInt(br.readLine().trim());
			//갔던 곳 체크 
			map = new int[size][size];
			checkMap = new int[size][size];
			for(int i=0; i<size; i++) {
				String str = br.readLine();
				for(int j=0; j<size;j++) {
					map[i][j]= str.charAt(j)-'0';
					checkMap[i][j] = 999999;
				}
			}//for end
			int result = setQueue();
			String str = "#"+String.valueOf(test_case)+" "+String.valueOf(result);
			bw.write(str+"\n");
			
			
		}
	
		 bw.close();
	}//main end


}
