package ParkJiHoon.FifthWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Magnetic {
    static int map[][] = new int[100][100];
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        List<Integer> ret = new ArrayList<>();
        for(int i=0 ; i<10; i++){
            int n = Integer.parseInt(br.readLine());
            for(int j=0 ; j<100 ; j++){
                String[] line = br.readLine().split(" ");
                for(int k=0; k<100 ; k++) map[j][k] = Integer.parseInt(line[k]);
            }
            ret.add(get_deadlock_count());
        }
        for(int i=0; i<10; i++){
            System.out.println("#"+(i+1)+" "+ret.get(i));
        }

    }
    private static int get_deadlock_count(){
        int ret = 0;

        for(int j= 0;j<100 ;j++){
            ret+= how_many_deadlock_in_row(j);
        }

        return ret;
    }
    private static int how_many_deadlock_in_row(int j){
        int ret = 0;
        int n_count = 0;
        for(int i=0 ; i<100 ; i++){
            if(map[i][j] == 1) n_count++;
            else if(map[i][j] ==2 && n_count>0) {ret++; n_count=0;}
        }

        return ret;
    }
}
