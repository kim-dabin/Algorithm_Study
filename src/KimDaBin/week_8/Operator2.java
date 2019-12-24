package week_8;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;




public class Operator2 {
	private static int n;
	private static int min;
	private static int max;
	private static int[] arr;
	public static void dfs(int plus, int minus, int multi, int divi, int cnt, int sum ) {
		if(cnt==n) {
			min = Math.min(sum, min);
			max = Math.max(sum, max);
			return; 
		}
		
		if(plus>0) {
			dfs(plus-1, minus, multi, divi, cnt+1, sum+arr[cnt]);
		}
		if(minus>0) {
			dfs(plus, minus-1, multi, divi, cnt+1, sum-arr[cnt]);
		}
		if(multi>0) {
			dfs(plus, minus, multi-1, divi, cnt+1, sum*arr[cnt]);
		}
		if(divi>0) {
			dfs(plus, minus, multi, divi-1, cnt+1, sum/arr[cnt]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		int[] op = new int[4];
		String[] ra = br.readLine().split(" ");
		String[] ro =  br.readLine().split(" ");
		
		/*단순 for문일때는 람다식 사용 자제할것*/
		IntStream.range(0, ra.length).forEach((i)-> arr[i]= Integer.parseInt(ra[i]));
		IntStream.range(0, 4).forEach((i)-> op[i]= Integer.parseInt(ro[i]));
		
		
		
		
		dfs(op[0], op[1], op[2], op[3], 1, arr[0]);
		System.out.print(max+"\n"+min);
		
		
		
	}

}

