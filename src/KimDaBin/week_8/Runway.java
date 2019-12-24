package week_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Runway {
	private static int[][] map;
	private static int road, n, l;
	private static int[] row = {0,1};//오른쪽, 아래 이동 
	private static int[] col = {1,0};

	public static class Node{
		int prev;
		int cnt;
		int r,c;
		
		public Node(int prev, int cnt, int r, int c) {
			this.prev = prev;
			this.cnt = cnt;
			this.r = r;
			this.c =c;
		}
		
		public Node(int r, int c) {
			this.r = r;
			this.c =c;
		}
		
	}
	
//	public static void rightPath() {
//		Queue<Node> q = new LinkedList<Node>();
//		q.add(new Node(map[1][1], 0, 1, 1));
//		
//		
//		
//		while (!q.isEmpty()) {
//			
//			int prev = q.peek().prev;//이전 값 
//			int cnt = q.peek().cnt;//경사로 없이 지나온 칸의 수 
//			int nr = q.peek().r;
//			int nc = q.peek().c;
//			q.poll();
//			
//						
//			if(prev>0) {
//				if(map[nr][nc+1]<0) {//한줄 갈 수 있음 
//					road++;
//					q.add(new Node(map[nr+1][1], 0, nr+1, 1));// 다음줄 첫번째 칸으로 이동 
//					
//				}else {
//					if(prev-map[nr][nc+1]==1&&cnt<l) {
//						q.add(new Node(prev, cnt+1, nr, nc+1));//다음 칸 이동 
//				}else if(prev-map[nr][nc+1]==1&&cnt==l) {
//					q.add(new Node(map[nr][nc], 0, nr, nc+1));
//				}else if(prev-map[nr][nc+1]==0) {
//					q.add(new Node(map[nr][nc], cnt+1, nr, nc+1));
//				}else if(prev-map[nr][nc+1]==-1&&cnt>=l) {
//					q.add(new Node(map[nr][nc], 0, nr, nc+1));
//				}else {
//					q.add(new Node(map[nr+1][1], 0, nr+1, 1));
//					}
//				}
//				
//				
//				
//			}else {
//				return;
//			}
//			
//			
//		}// while end
//		
//	}
	
	public static void downPath() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(map[1][1], 0, 1, 1));
		
		
		
		for(int i=1; i<=n; i++) {
			int cnt =1;
			boolean check = false;
			for(int j=1; j<=n; j++) {
				if(map[i][j+1]>0) {
					if(check&&cnt>=l) {
						cnt=0;
						check = false;
						
					}
					if(map[i][j]-map[i][j+1]==1&&!check) {
						cnt=1;
						check = true;
					}else if(map[i][j]-map[i][j+1]==0) {
						cnt++;
						
					}else if(map[i][j]-map[i][j+1]==-1&&cnt>=l&&!check) {
						cnt=1;
					}else {
						
						break;
					}
				}else {
					
					if(!check) {
//						System.out.println(i+" "+j);
						road++;
					}
					else if(check&&cnt>=l) {
//						System.out.println(i+" "+j);
						road++;
					}
				}
				
			}//for end
			
		}//for end
		for(int i=1; i<=n; i++) {
			int cnt =1;
			boolean check = false;
			
			for(int j=1; j<=n; j++) {
				if(check&&cnt>=l) {
					cnt=0;
					check = false;
				}
				if(map[j+1][i]>0) {
					if(map[j][i]-map[j+1][i]==1&&!check) {
						cnt=1;
						check = true;
					}else if(map[j][i]-map[j+1][i]==0) {
						
						cnt++;
						
					}else if(map[j][i]-map[j+1][i]==-1&&cnt>=l&&!check) {
						cnt=1;
					}else {
//						System.out.println(j+" "+i);
						break;
					}
				}else {
					if(!check) {
//						System.out.println(i+" "+j);
						road++;
					}
					else if(check&&cnt>=l) {
//						System.out.println(i+" "+j);
						road++;
					}
					
					
				}
			}
		}//for end
		
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		road=0;
		String[] data = br.readLine().split(" ");
		n = Integer.parseInt(data[0]);
		l = Integer.parseInt(data[1]);
		map = new int[n+2][n+2];
		for(int[] m : map) {
			Arrays.fill(m, -1);
		}
		
		for(int i=1; i<=n;i++) {
			String[] mapData = br.readLine().split(" ");
			for(int j=1; j<=n;j++) {
				
				map[i][j]= Integer.parseInt(mapData[j-1]);
			}
		}
		//rightPath();
		downPath();
		System.out.println(road);
		
		
//		for(int[]a : map) {
//			for(int b: a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
		
	}

}
