package week_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import sun.awt.image.ImageWatched.Link;

public class Security2 {
	private static int[][] map;
	private static ArrayList<Node> cctvList;
	private static int totalN,n,m, min;
	private static int[] x = {0,1,0,-1}; //오른쪽 아래 왼쪽 위 
	private static int[] y = {1,0,-1,0};
	private static boolean[][][] v;
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
	
	public static int[][] copyArr(int[][] ori){
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m;j++) {
				arr[i][j]=ori[i][j];
			}
		}
		
		
		return arr;
		
	}
	
	public static ArrayList<Integer> findType(int cctv) {
		ArrayList<Integer> type = new ArrayList<>();
		switch (cctv) {
		case 1:
			type.add(0);
			break;
		case 2:
			type.add(0);
			type.add(2);
			break;
		case 3:
			type.add(0);
			type.add(3);
			break;
		case 4:
			type.add(0);
			type.add(2);
			type.add(3);
			break;
		case 5:
			type.add(0);
			type.add(1);
			type.add(2);
			type.add(3);
			break;

		
		}
		
		return type;
	}
	
	
	
	public static void move(int[][] copy, int row, int col, int i, int cctvType) {
		ArrayList<Integer> cctv = findType(cctvType);
		for(int j=0; j<cctv.size(); j++) {
			
			int dir = cctv.get(j)+i;//방향 
			if(dir>3) {
				dir = dir-4;
			}
			int nx =row+x[dir];
			int ny=col+y[dir];

			while(true) {
				
			if(nx>=0&&nx<n&&ny>=0&&ny<m) {

				if(copy[nx][ny]!=6) {
					if(copy[nx][ny]==0) {
						copy[nx][ny]=-1;
					}
					//System.out.println(ny);
					nx+=x[dir];
					ny+=y[dir];
				}else if(copy[nx][ny]==6) {
					break;
				}
				}else {
					
					break;
				}
				
			}//while end
		}//for end 

		
		
		
	}
	
	
	public static void dfs(int cnt, int[][] prev) {
		int[][] copy = new int[n][m]; 
		if(cnt==cctvList.size()) {
			int tmp = totalN;
			for(int[] a: prev) {
				for(int b: a) {
					if(b==-1) {
						tmp--;
					}
				}
			}
			
			min = Math.min(tmp, min);
			return;
		}

			
		int cctvType = cctvList.get(cnt).cctv;
		int row = cctvList.get(cnt).row;
		int col = cctvList.get(cnt).col;
			
		switch (cctvType) {
		
		
		case 1:
			for(int i=0; i<4; i++) {
				copy = copyArr(prev);
				move(copy, row, col, i, cctvType);
				dfs(cnt+1,copy);
			}
		
			break;
		case 2:
			for(int i=0; i<2; i++) {
				copy = copyArr(prev);
				move(copy, row, col, i, cctvType);
				dfs(cnt+1,copy);
			}
			
			break;
		case 3:
			for(int i=0; i<4; i++) {
				copy = copyArr(prev);
				move(copy, row, col, i, cctvType);
				dfs(cnt+1,copy);
			}
			break;
		case 4:
			for(int i=0; i<4; i++) {
				copy = copyArr(prev);
				move(copy, row, col, i, cctvType);
				dfs(cnt+1,copy);
			}
			
			break;
		case 5:
			for(int i=0; i<1; i++) {
				copy = copyArr(prev);
				move(copy, row, col, i, cctvType);
				dfs(cnt+1,copy);
			}
			break;
		}

	}
	
	
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		cctvList = new ArrayList<Node>();
		map = new int[n][m];
		totalN =0;
		min = Integer.MAX_VALUE;
		v = new boolean[n][m][4];
		
		for(int i=0; i<n; i++) {
			String[] data = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j]= Integer.parseInt(data[j]);
				if(map[i][j]>0&&map[i][j]<6) {
					cctvList.add(new Node(i, j, map[i][j]));
					
				}else if(map[i][j]==0) {
					totalN++;
				}
			}
		}//for end 
		//sSystem.out.println(cctvList.get(1).row);
		
		dfs(0,map);
		System.out.println(min);

	}

}
