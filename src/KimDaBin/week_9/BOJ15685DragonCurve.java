package week_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/*
 * tm 스택에 저장된 최신 정보를 꺼내려면 스택 크기 먼저 시작 
 * 런타임 에러: 배열 범위를 잘 살펴야하는데, 귀찮다면 입력 배열 크기를 크게 주고, 문제해결은 원래 범위 안에 하기 
 * 
 * */

public class BOJ15685DragonCurve {
	private static boolean[][] map;
	private static int[] row = {0,-1,0,1};
	private static int[] col = {1,0,-1,0};
	private static ArrayList<Node> info;

	public static class Node{
		int x, y, d, g;
		public Node(int x, int y, int d, int g) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}
	}
	
	
	public static void move(int x, int y, int d, int g) {
//	System.out.println("g "+g);
		Stack<Integer> prev = new Stack<>();
		map[y][x]= true;
		//0g 이동 지점
		int ny = y+row[d];
		int nx = x+col[d];
//		ny +=row[d];
//		nx +=col[d];
	//	System.out.println(nx);
		if(ny>=0&&ny<=100&&nx>=0&&nx<=100) {
		map[ny][nx]=true;
		prev.add(d);
		}
		for(int i=0; i<g;i++) {
			int stackSize = prev.size();
	
		for(int j=stackSize-1; j>=0; j--) {//스택의 최신 정보를 불러오기
			int nd = (prev.get(j)+1)%4;//회전
			
			ny+=row[nd];
			nx+=col[nd];
			if(ny>=0&&ny<=100&&nx>=0&&nx<=100) {		
			map[ny][nx]=true;
			prev.add(nd);
			}
		}
			
			
			
		}
	
		
		
//		System.out.println(prev.toString());
	}
	
	

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new boolean[102][102];
		int n = Integer.parseInt(br.readLine());
		info = new ArrayList<>();
		for(int i=0; i<n; i++) {
			String[] infoStr = br.readLine().split(" ");
			info.add(new Node(Integer.parseInt(infoStr[0]), Integer.parseInt(infoStr[1]), Integer.parseInt(infoStr[2]), Integer.parseInt(infoStr[3])));
			
		}
		
		for(int i=0; i<info.size();i++) {
			int x = info.get(i).x;
			int y = info.get(i).y;
			int d = info.get(i).d;
			int g = info.get(i).g;
		//System.out.println(Math.pow(2, g));
			move(x , y, d, g);
		}

		
		  int result = 0;
		    for(int i=0; i<102; i++){
		        for(int j=0; j<102; j++){
		            
		            //인접한 4칸의 정사각형이 모두 드래곤의 일부이면
		            if(map[i][j]&& map[i][j+1]&& map[i+1][j]&& map[i+1][j+1]){
		                
		                //갯수를 1 증가시킨다.
		            	result++;
		            }
		        }
		    }
		    System.out.print(result);
//		
	//	System.out.println((3+1)%4);
	}

}
