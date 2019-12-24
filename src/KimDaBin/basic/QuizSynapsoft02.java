package basic;

import java.util.HashMap;

public class QuizSynapsoft02 {
	
	private static String[] numbersArray = {"","일","이","삼","사","오","육","칠","팔","구"};
	private static String[] smallUnitArray = {"","십","백","천"};
	private static String[] bigUnitArray = {"","만","억","조"};

	
	public static void solve(char[] money) {
		HashMap<String, Integer> map = new HashMap<>();
		 for(int j=money.length-1; j>=0; j--) {
			 System.out.print(money[j]);
			 if(j%4==0) System.out.println();
		 }
		
		
	}
	
	
	public static void main(String[] args) {
		String[] inputList = {
				"1원",
				"80,270원",
				"111,111원",
				"1,234,567,890원",
				"100,000,000,000,000원",
				"100,000,000,000원",
				"1170,000원",
				"1,000,000,000,000원",
				"1,000원",
				"100원","112,910,701원","10원","1,224,690,666원"
		};
		
		for(int i =0; i<inputList.length;i++) {
		
			String data =  inputList[i];
		
			if(data.length()>1&&data.length()<=20) {//1원 이상 백조원 이하 
				 data = data.replaceAll("[^0-9]","");
				 String[] money = null;
				 int len = data.length()%2==0?data.length()/2:data.length()/2+1;
				 System.out.println(len);
				 
				 for(int j=0; j<len; j++) {
					 //money[j]=data.substring(data.length()-j*4, )
				 }
				 
			}
		
		}
	}
}
