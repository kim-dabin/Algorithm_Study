package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestString {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = {"A","B"};
		String[] arr2 = new String[2];
		String a = "A";
		
		arr2[0]= new String("A");
		arr2[1]=new String("B");
//		for(int i=0; i<2;i++) {
//			arr2[i] = br.readLine();
//		}
		System.out.println(arr2[0]=="A");
		
	}
}
