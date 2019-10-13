package ParkJiHoon.ThirdWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * ?의 StackOverFlow 문제를 해결못함..
 * dfs말고 bfs 접근하는게 좋을것 같음 -> 시간 관계상..
 */

/**
 * 4차원 배열
 *
 */
public class ProgramVer {
    static List<Status> visited = new ArrayList<>();
    static char now_direction = '>';
    static int global_i=0;
    static int global_j=0;
    static int mem =0;
    static char[][] cmd;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_num = Integer.parseInt(br.readLine());
        List<String> res = new ArrayList<String>();
        for(int i=0; i<case_num ; i++) {
            String[] line = br.readLine().split(" ");
            int R = Integer.parseInt(line[0]);
            int C = Integer.parseInt(line[1]);
            cmd = new char[R][C];
            visited = new ArrayList<>();
            global_i =0;
            global_j =0;
            mem =0;
            now_direction = '>';
            boolean isEndExist = false;
            int qCount = 0;
            for(int j=0 ; j<R;j++) {
                cmd[j] = br.readLine().toCharArray();
            }
            for(int j=0 ;j<R;j++){
                for(int k=0 ;k<C ; k++){
                    if(cmd[j][k] == '@') isEndExist =true;
                    if(cmd[j][k] == '?') qCount++;
                }
            }
            if (isEndExist) {
                if(qCount>20) res.add("NO");
                else res.add(is_Case_Endable(cmd));
            }
            else res.add("NO");
        }
        for(int i=0 ; i<case_num;i++) {
            System.out.println("#"+(i+1)+" "+res.get(i));
        }
    }


    static void move(int R,int C) {
        switch (now_direction) {
            case '>':{global_j++; if(global_j==C) global_j=0;break;}
            case '<':{global_j--; if(global_j==-1) global_j=C-1;break;}
            case 'v':{global_i++; if(global_i==R) global_i=0;break;}
            case '^':{global_i--; if(global_i==-1) global_i=R-1;break;}
            default:
                break;
        }
    }

    static String is_Case_Endable(char[][] cmd) {
        String ret= "YES";
        int R = cmd.length;
        int C = cmd[0].length;
        ret= dfs(R,C);
        return ret;
    }

    static String dfs(int R, int C){
        char now_cmd = cmd[global_i][global_j];
        switch (now_cmd) {
            case '>':{now_direction = '>'; break;}
            case '<':{now_direction = '<'; break;}
            case 'v':{now_direction = 'v'; break;}
            case '^':{now_direction = '^'; break;}
            case '_':{
                if(mem==0) {now_direction='>';}
                else{now_direction='<';};
                break;
            }

            case '|':{
                if(mem==0) {now_direction='v';}
                else{now_direction='^';};
                break;
            }
            case '?':{  //는 visited에 기록을 남기지 x 우연히 똑같이 올수도 있다. 이전까지 기록을 reset
                now_direction='<';
                int temp_i = global_i;
                int temp_j = global_j;
                Status temp = new Status(global_i,global_j,now_direction,mem);
                if(visited.contains(temp)) return "NO";
                visited.add(temp);
                move(R,C);
                if(dfs(R,C).equals("YES"))return "YES";
                else{visited.remove(temp);}
                global_i = temp_i;
                global_j = temp_j;
                now_direction='>';
                temp = new Status(global_i,global_j,now_direction,mem);
                if(visited.contains(temp)) return "NO";
                visited.add(temp);
                move(R,C);
                if(dfs(R,C).equals("YES"))return "YES";
                else{visited.remove(temp);}
                global_i = temp_i;
                global_j = temp_j;
                now_direction='v';
                temp = new Status(global_i,global_j,now_direction,mem);
                if(visited.contains(temp)) return "NO";
                visited.add(temp);
                move(R,C);
                if(dfs(R,C).equals("YES"))return "YES";
                else{visited.remove(temp);}

                global_i = temp_i;
                global_j = temp_j;
                now_direction='^';
                temp = new Status(global_i,global_j,now_direction,mem);
                if(visited.contains(temp)) return "NO";
                visited.add(temp);
                move(R,C);
                if(dfs(R,C).equals("YES"))return "YES";
                else{visited.remove(temp);}

                break;
            }

            case '.':{
                break;
            }

            case '@':{
                return "YES"; // 종료
            }
            case '+':{//visited reset
                mem++;
                if(mem==16) mem=0;
                break;
            }
            case '-':{//visited reset
                mem--;
                if(mem==-1) mem=15;
                break;
            }
            default:
                //숫자 일때
                mem=Integer.parseInt(String.valueOf(now_cmd));
                break;
        }
        Status temp = new Status(global_i,global_j,now_direction,mem);
        if(visited.contains(temp)) return "NO";
        visited.add(temp);
        move(R, C);

        return dfs(R,C);
    }


    static class Status {
        int i,j;
        char dir;
        int mem;
        public Status(int i, int j, char dir, int mem) {
            super();
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.mem = mem;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public char getDir() {
            return dir;
        }

        public int getMem() {
            return mem;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof Status) {
                if (this.i == ((Status)obj).getI() && this.j == ((Status)obj).getJ() && this.dir == ((Status)obj).getDir()&& this.mem == ((Status)obj).getMem()) {
                    return true;
                }
            }

            return false;
        }
    }

}
