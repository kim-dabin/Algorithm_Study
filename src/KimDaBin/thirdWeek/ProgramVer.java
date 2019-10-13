package thirdWeek;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class ProgramVer {
	private static char[][] arr;
	private static boolean[][][][] visited;
	private static int[] row = {0,1,0,-1};
	private static int[] col = {1,0,-1,-0};
	private static int r,c ,mem;
	private static boolean result;
	public static void dfs(int dr, int dc, int dir) {
	       
        if(result) {
        	return;
        }
		
		
		if(dr == -1) dr = r-1;
        else if(dr == r) dr = 0; 
        if(dc == -1) dc = c-1;
        else if(dc == c) dc = 0;
       
        if(mem>=0&&mem<=15&&dir<4&&dir>=0) {
    
		char ch = arr[dr][dc];
//	 	System.out.println(dir);
		//System.out.print(ch+" ");	
	
			if(ch=='<') {//left dir
				dir = 2;
			}else if(ch=='^') {
				dir=3;
				
			}  else if(ch=='>') {//dir: right
				dir = 0;
				
				
			} else if(ch=='v') {//dir: down 
				dir = 1;
			} else if(ch=='_') {
				dir = (mem==0)?0:2;
			} else if(ch=='|') {
				dir= (mem==0)?1:3;
			} else if(ch=='+') {
				mem=(mem==15)?0:mem+1;
			} else if(ch=='-') {
				mem=(mem==0?15:mem-1);			
			}else if(ch>='0'&&ch<='9') {
				mem=ch-'0';		
				
			}else if(ch=='.') {
				
				//System.out.println(dir);
			}
			else if(ch=='@') {//exit 
				result=true;
				return;
			} 
			if(visited[dr][dc][dir][mem]) {
				result=false;
				return;
			}else {
				visited[dr][dc][dir][mem] = true;
			}
			
			
			if(ch=='?') {
				//dir=0;
				char find=' ';
				for(int i=0; i<4; i++) {
					
					int x = dr+row[i];
					int y = dc+col[i];
					if(x == -1) x = r-1;
			        else if(x == r) x = 0;
			        if(y == -1) y = c-1;
			        else if(y == c) y = 0;
			    	
			        if(arr[x][y]=='@') { 
			        	result=true; 
			        	break;
			        }
			        if(visited[x][y][i][mem]) {
						result=false;
						return;
					}else {
						visited[x][y][i][mem] = true;
					}
						       
			        if(x>=0&&x<r&&y>=0&&y<c) { 
			        	dfs(x,y,i);        	
			        	visited[x][y][i][mem] = false;
			        }
			        
			        
				}
			}else {
				dfs(dr+row[dir],dc+col[dir],dir);
			}
			
		
			
        }
 
		
	 }
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] nums = br.readLine().split(" ");
			 r = Integer.parseInt(nums[0]);//r행 
			 c = Integer.parseInt(nums[1]);//c열 
			String str = null;
			visited = new boolean[r][c][4][16];//r,c,dir,mem size
			arr = new char[r][c];
			result = false;
			
			for(int i=0; i<r; i++) {
				str = br.readLine(); 
				for(int j=0; j<c;j++) {
					arr[i][j] = str.charAt(j);
				}
			}//for end 

			//bw.append("\n");
			mem =0;
			dfs(0, 0, 0);
			
			bw.append("#"+test_case+" "+(result?"YES":"NO")+"\n");
						
		}
		br.close();
		bw.flush();
		bw.close();

	}

}
