package algorithmTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Adjcency_Test {
	 /*
     * 인접행렬을 이용해 구현한 방향성 그래프
     */
    
    static int nV; //총 vertex 수
    static int nE; //총 edge 수
    
    static boolean[] v;
    
//    public static void dfs(int x) {
//    	if(v[x]) {	
//    		
//    		return;}
//    	v[x] = true;
//    	System.out.println(x);
//    	for(int i=0; i< adMatrix[x].length;i++) {
//    		int y = adMatrix[x][i];
//    		if(y==1&&!v[x]) {
//    		dfs(y);
//    		}
//    	}
//    	
//    	
//    }
    public static void main(String[] args) {
    	int N, M;
    	 ArrayList<ArrayList<Graph>> test = new ArrayList<ArrayList<Graph>>();
		
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		
		for(int i=0; i<101; i++){
			test.add(new ArrayList<Graph>());
		}
		
		for(int i=0; i<M; i++){
			int start, end, weight;
			start = input.nextInt();
			end = input.nextInt();	
			weight = input.nextInt();
			
			Graph element = new Graph(end, weight);			//리스트에 넣어줄 element
			test.get(start).add(element);
			Graph element2 = new Graph(start, weight);
			test.get(end).add(element2);
		}



     //   dfs(1);
		for(int i=0; i<test.size(); i++){
			System.out.print(i + " : ");
			for(int j=0; j<test.get(i).size(); j++){
				System.out.print(test.get(i).get(j).end + " / " + test.get(i).get(j).weight + " ");
			}
			System.out.println();
		}



}

}
