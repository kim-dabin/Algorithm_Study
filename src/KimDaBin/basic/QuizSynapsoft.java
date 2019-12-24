package basic;

public class QuizSynapsoft {

	private static String[] numbersArray = {"","일","이","삼","사","오","육","칠","팔","구"};
	private static String[] smallUnitArray = {"","십","백","천"};
	private static String[] bigUnitArray = {"","만","억","조"};
	
	public static void solve(char[] data) {
		StringBuffer sb = new StringBuffer();
		int[] money = getMoney(data);
		int smallUnit = 0;//십, 백, 천 단위  
		int bigUnit = 0;// 만, 억, 조 단위
		int number = 0;// 돈의 숫자 
		int max = 0; // 가장 큰 단위 저장 
		int size = money.length-1; //돈 크기 
		
		for(int i=size; i>=0;i--) {//끝에서 부터 
			number = money[i];
			if(number>0) {
			smallUnit = i%4;//십 백 천 
			bigUnit = (i-smallUnit)/4;//만 억 조
			max = Math.max(max, bigUnit);
			
			if(number==1) {//돈의 숫자가 1일 때 
				if(smallUnit>0||(bigUnit==1&&i==size)) { number=0;}//작은 단위는 모두 0 // 일만원을 만원으로 
			}//if end
			sb.append(numbersArray[number]);
			sb.append(smallUnitArray[smallUnit]); 
			}//if end 

			if(i%4==0) {  //만 단위로 끊기 
			  sb.append(bigUnitArray[max]+" ");
			  max = 0;
			}//if end
			
			
			}

		System.out.println(sb.toString().trim()+"원");
	
		
	}
	
	public static int[] getMoney(char[] data){//문자 배열을 정수 배열로 변환 
		int[] result = new int[data.length];
		
		for(int i=0; i<data.length;i++) {
			result[i]=(data[(data.length-1)-i]-'0');
		}
		return result;
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
				String money = data.replaceAll("[^0-9]", "");//숫자 외 문자 제거 
				solve(money.toCharArray());
			}
		
		}
	}

}
