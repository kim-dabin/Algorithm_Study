package week_8;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;




public class Operator {
	private static int n,min,max;
	public static void dfs(int plus, int minus, int multi, int division, int cnt, int[] a, int result) {
		if(cnt==n) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}
		
		if(plus>0) {
			dfs(plus-1, minus, multi, division, cnt+1, a, result+a[cnt]);
		}
		if(minus>0) {
			dfs(plus, minus-1, multi, division, cnt+1, a, result-a[cnt]);
		}
		if(multi>0) {
			dfs(plus, minus, multi-1, division, cnt+1, a, result*a[cnt]);
		}
		if(division>0) {
			dfs(plus, minus, multi, division-1, cnt+1, a, result/a[cnt]);
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());//수의 개수
		min = Integer.MAX_VALUE;
		max= Integer.MIN_VALUE;
		String[] arr = new String[(n*2)-1]; //연산자를 끼워 넣을 배열 
		int[] num = new int[n];
		String[] str = br.readLine().split(" ");
		for(int i=0; i<str.length;i++) {
			arr[i*2] = str[i];
			num[i]=Integer.parseInt(str[i]);
		}
		
		int[] op = new int[n-1];
		String[] opStr = br.readLine().split(" ");
		
		for(int i=0; i<opStr.length;i++) {
			op[i]=Integer.parseInt(opStr[i]);
		}
	
		dfs(op[0], op[1], op[2], op[3], 1, num, num[0]);
		System.out.print(max +"\n"+min);
		
	}

}

