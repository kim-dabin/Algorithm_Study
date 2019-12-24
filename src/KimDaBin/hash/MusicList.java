package hash;

import java.util.*;


public class MusicList {
	
	public static class Node{
		private int index, play;
		private String genre;
		public Node(int index, int play, String genre) {
			this.index = index;
			this.play = play;
			this.genre = genre;
		}

	}
	
	
    public static  int[] solution(String[] genres, int[] plays) {
    	 int[] answer = {};
    	ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> bestGenres = new HashMap<>();
        List<Node> playList = new ArrayList<>();

        
        
        for(int i=0; i<genres.length; i++) {
        	bestGenres.put(genres[i], bestGenres.getOrDefault(genres[i], 0)+plays[i] );
  
        	playList.add(new Node(i, plays[i],genres[i]));
        	
        }
        

     
        List<String> sortedMap =  sortByValue(bestGenres);
        
        playList.sort(new Comparator<Node>() {
        	@Override
        	public int compare(Node o1, Node o2) {
        		int p1 = o1.play;
        		int p2 = o2.play;
        		
        		return ((Comparable) p2).compareTo(p1);
        	}
        
		});
    
        int idx = 0;
        sortedMap.forEach(genre->{
        	int check = 0;
        	for(int i=0; i<playList.size();i++) {
        		if(playList.get(i).genre.equals(genre)) {
        			result.add(playList.get(i).index);

        			check++;
        		}
        	
        		if(check==2) { break;}
        		//idx++;
        	}
        });
        
        answer = new int[result.size()];
        for(int i=0; i<answer.length;i++) {
        	answer[i]= result.get(i);
        }
        
        return answer;
    }
    
    public static List sortByValue(Map map) {

        List<String> list = new ArrayList();

        list.addAll(map.keySet());
        
        list.sort(new Comparator<String>() {
        	
        	@Override
        	public int compare(String o1, String o2) {
        	    Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                 
                return ((Comparable) v2).compareTo(v1);
        	}
		});
        
        return list;


    } 
  
    
   
	public static void main(String[] args) {
		String[] genres= {"classic","pop","classic","classic","pop"}; 
		int[] plays = {500, 600, 150, 800, 2500};
		int[] result = solution(genres, plays);
		for(int a : result) {
			System.out.print(a+" ");
			
		}
		
		
	
	}

}
