package week_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class Gear {
	
	private static ArrayList< ArrayList<LinkedList<Integer>>> gears;
	private static int count;
	private static int[][] data;
	private static boolean[] v;

	public static void solve(int gear, int dir , int cnt ){		
		int gp = gears.get(gear).get(6).iterator().next();
		int gn = gears.get(gear).get(2).iterator().next();
		
		int prev =gear-1;
		int next =gear+1;
		
		if(dir==1) {
			dir = -1;
			clockwise(gear);
			
		}else if(dir==-1) {
			dir = 1;
			counterclockwise(gear);
			
		}
		
		if(prev>=0) {
			int prevGear = gears.get(prev).get(2).iterator().next();			
			if(gp!=prevGear&&!v[prev]) {
				v[prev] = true;
				solve(prev, dir, cnt+1);
				v[prev] = false;
				
			}
			
		}
		if(next<4) {
			int nextGear = gears.get(next).get(6).iterator().next();
			if(gn!=nextGear&&!v[next]) {
				v[next] = true;
				solve(next, dir, cnt+1);
				v[next] = false;
			}
			
		}
		
	}
	
	public static void clockwise(int gear) {//시계방향 
		Collections.rotate(gears.get(gear), 1);
		
	}
	public static void counterclockwise(int gear) {//반시계방향 
		Collections.rotate(gears.get(gear), -1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gears = new ArrayList< ArrayList<LinkedList<Integer>>>();
		v = new boolean[4];
		for(int i=0; i<4; i++) {
			gears.add(new ArrayList<>());
			String str = br.readLine();
			for(int j=0; j<8; j++) {
				LinkedList<Integer> input = new LinkedList<>();
				input.add(str.charAt(j)-'0');
				gears.get(i).add(input);
				
			}
		}
		count = Integer.parseInt(br.readLine());
		data = new int[count][2];
		for(int i=0; i<count; i++) {
			String[] input = br.readLine().split(" ");
			data[i][0]= Integer.parseInt(input[0]);
			data[i][1]= Integer.parseInt(input[1]);
		}
		for(int i=0; i<count; i++) {
			int nowGear = (data[i][0])-1;
			v[nowGear] = true;
			solve(nowGear, data[i][1], 0);
			v[nowGear] = false;
		}

	int result = 0;
		for(int i=0; i<4;i++) {
			int num = gears.get(i).get(0).iterator().next();
			if(num==1) {
				
				switch (i) {
				case 0:
					result+=1;
					break;
				case 1:
					result+=2;
					break;
				case 2:
					result+=4;
					break;
				case 3:
					result+=8;
					break;
				}
			}
			
		}
		
		System.out.println(result);
		
	}

}
