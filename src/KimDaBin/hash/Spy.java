package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Spy {
	
	

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		String[][] clothes = {{"yellow_hat", "headgear"}, 
				{"blue_sunglasses", "headgear"}, 
				{"green_turban", "headgear"}};
		int answer=1;
		Set<String> clothSet = new HashSet<>();
		for(String[] str: clothes) {
			map.put(str[1], map.getOrDefault(str[1], 0)+1);
		}
		
		clothSet = map.keySet();
		
		for(String key : clothSet) {
			answer *= map.get(key)+1;
		}
	
		
		System.out.println(answer-1);
	}

}
