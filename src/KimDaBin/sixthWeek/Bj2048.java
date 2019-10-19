package sixthWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj2048 {
	private static int num;
	private static int max;
	private static int[][] arr;
	
	public static void merge(int dir) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		switch (dir) {//0 왼, 1 오, 2 위, 3 아래 
		case 0: //왼쪽  
			for(int y=0; y<num; y++ ) {
				for(int x= 0; x<num; x++) {
					if(arr[y][x]!=0) {
						q.add(arr[y][x]); //왼쪽  
						arr[y][x]=0;//0으로 초기화 
					}
				}//for end
				
				int idx = 0;
				
				while(!q.isEmpty()) {
					int n = q.peek();// 맨 앞의 데이터 
					
				//	System.out.println(n);
					if(arr[y][idx]==0) {
						arr[y][idx]=q.poll(); // 데이터 땡기기 
					}else if(arr[y][idx]==n) {
						arr[y][idx]+=q.poll(); // 합쳐져야 하니까 
						//테스크 수행했으니까 다음 데이터로 바로 이동 
						idx++;
					}else {
						arr[y][++idx] = q.poll();//그냥 원상복귀 
					}
					
				}
				
				
			}//for end
			
			
			break;

		case 1://오른쪽 
			for(int y=0; y<num; y++ ) {
				for(int x=num-1; x>=0; x--) {
					if(arr[y][x]!=0) {
						q.add(arr[y][x]); //오른쪽 한 줄 
						arr[y][x]=0;//0으로 초기화 
					}
				}//for end
				
				int idx = num-1;
				
				while(!q.isEmpty()) {
					int n = q.peek();// 맨 앞의 데이터 
					if(arr[y][idx]==0) {
						arr[y][idx]=q.poll(); // 데이터 땡기기 
					}else if(arr[y][idx]==n) {
						arr[y][idx]+=q.poll(); // 합쳐져야 하니까 곱하기 2
						//테스크 수행했으니까 다음 데이터로 바로 이동 
						idx--;
					}else {
						arr[y][--idx] = q.poll();//그냥 원상복귀 
					}
					
				}
				
				
			}//for end
			break;
			
		case 2://위 
			
			for(int x=0; x<num; x++ ) {
				for(int y=0; y<num; y++) {
					if(arr[y][x]!=0) {
						q.add(arr[y][x]); //오른쪽 한 줄 
						arr[y][x]=0;//0으로 초기화 
					}
				}//for end
				
				int idx = 0;
				
				while(!q.isEmpty()) {
					int n = q.peek();// 맨 앞의 데이터 
					if(arr[idx][x]==0) {
						arr[idx][x]=q.poll(); // 데이터 땡기기 
					}else if(arr[idx][x]==n) {
						arr[idx][x]+=q.poll(); // 합쳐져야 하니까 곱하기 2
						//테스크 수행했으니까 다음 데이터로 바로 이동 
						idx++;
					}else {
						arr[++idx][x] = q.poll();//그냥 원상복귀 
					}
					
				}
				
				
			}//for end
			
			
			break;
			
		case 3://아래 
			
			for(int x=0; x<num; x++ ) {
				for(int y=num-1; y>=0; y--) {
					if(arr[y][x]!=0) {
						q.add(arr[y][x]); //오른쪽 한 줄 
						arr[y][x]=0;//0으로 초기화 
					}
				}//for end
				
				int idx = num-1;
				
				while(!q.isEmpty()) {
					int n = q.peek();// 맨 앞의 데이터 
					if(arr[idx][x]==0) {
						arr[idx][x]=q.poll(); // 데이터 땡기기 
					}else if(arr[idx][x]==n) {
						arr[idx][x]+=q.poll(); // 합쳐져야 하니까 곱하기 2
						//테스크 수행했으니까 다음 데이터로 바로 이동 
						idx--;
					}else {
						arr[--idx][x] = q.poll();//그냥 원상복귀 
					}
					
				}
				
				
			}//for end
			break;
			
			
		}
	}
	private static int cnt =0;
	public static void dfs(int depth) {
		int[][] copyArr = new int[num+1][num+1];
		
		
		//깊이가 5일 때
		if(depth==5) {
			
//			System.out.println("#"+(cnt++));
//			
//			for(int[] a: arr) {
//				for(int b: a) {
//				System.out.print(b+" ");
//				}
//				System.out.println();
//			}
			
			
			for(int[] a: arr) {
				for(int b: a) {
					max= Math.max(max, b);
				}
			}
			
			return;
		}
		
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
		
		
		
		
		for(int i=0; i<4; i++) {
			
			merge(i);
			
			dfs(depth+1);
			
			for(int a=0; a<num; a++) {// 배열 복구 
				for(int b=0; b<num; b++) {
					arr[a][b] = copyArr[a][b];
				}
			}
		
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		arr = new int[num+1][num+1];
		
		max=0;
		
		
		for(int i=0; i<num; i++) {
			String str[] = br.readLine().split(" ");
			for(int j=0; j<num; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		dfs(0);
		System.out.println(max);
		
	}
}
