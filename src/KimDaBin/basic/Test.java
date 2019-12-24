package basic;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
	private static boolean[] flag;
	
	
	public static void solve2(int[] arr) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		
		while(!q.isEmpty()) {
			int data = q.poll();
			if(data>=arr.length) continue;
			if(arr[data]==3) { System.out.println(data);}
			q.add(data+1);
			
		}
	}
	
	public static void solve3(int[] arr) {
		for(int i=0; i<arr.length; i++) {
    		if(arr[i]==3) {
    			System.out.println(i);
    			
    		}
    	}
	}
	
	public static void solve(int[] arr, int l, int r) {
		if(arr[l]==3) { 
			System.out.println(l);
		
		}
		 
		else if(l<r) { //왼쪽이 오른쪽보다 작을 때 
			int mid = (l+r)/2; //중간 값 
			solve(arr, l, mid);//왼쪽 
			solve(arr, mid+1, r);//오른쪽 
			 
		} 
		 
	}
	
    public static void main(String[] args) {        
    	int arr[] = new int[10000000];
    	flag = new boolean[10000000];
    	
    	for(int i=0; i<arr.length; i++) {
    	
    		int num = (int) (Math.random()*10000000)+1;
    		if(num==3) {num = 878;}
    		arr[i] = num;
    	
  
    	}
    	arr[999999] = 3;
    	long start = System.currentTimeMillis(); //시작하는 시점 계산
    	//solve2(arr);
    	solve(arr, 0,arr.length-1);
    	long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
    	System.out.println( "실행 시간1 : " + ( end - start )/1000.0 +"초"); 
    	long start2 = System.currentTimeMillis(); //시작하는 시점 계산
    	
    	//solve(arr, 0,arr.length-1);
    	solve3(arr);
    	
    	long end2 = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
    	System.out.println( "실행 시간2 : " + ( end2 - start2 )/1000.0 +"초"); 


    	
    } 
}
