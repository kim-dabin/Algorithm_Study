package algorithmTest;
import java.util.ArrayList;
/*막대기 자르기*/
public class DP01 {
	private static int[] a;
	public static void print() {
		for(int i:a) {
			System.out.print(i);
		}
		System.out.println();
	}
	
	public static void binary(int n) {
		if(n<1) {
			print();
		}else {
			a[n-1]=0;
			binary(n-1);
			a[n-1]=1;
			binary(n-1);
			
		}
	} 
	
	public static void main(String[] args) {
		int num=3;
		a = new int[num];
		binary(num);

	}

}
