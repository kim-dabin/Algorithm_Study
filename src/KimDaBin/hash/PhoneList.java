package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class PhoneList {
	
	
	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		HashMap<String, Integer> map = new HashMap<>();
		String[] phone_book = {"123","456","789"};
		int min = Integer.MAX_VALUE;
		
		boolean answer = true;
		for(String s: phone_book) {
			if(!answer) {
				System.out.println(false);
				break;
			}
			for(String b: phone_book) {
				if(!b.equals(s)&&b.startsWith(s)) { 
					answer = false;
				}
			}
		}
		

		
		
		
	//System.out.println(set.toString());
	//System.out.println(map.toString());
		
//		for(String s: phone_book) {
//			Iterator<String> str = set.iterator();
//			while(str.hasNext()) {
//				String prefix = str.next();
//				if(s.length()>prefix.length()&&!s.equals(prefix)&&s.startsWith(prefix)) {
//					System.out.println(s);
//					break;
//				}
//			}
//		}
	
	}

}
