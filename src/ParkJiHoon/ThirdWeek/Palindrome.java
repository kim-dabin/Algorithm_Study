package ParkJiHoon.ThirdWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_n = 10;
        List<Integer> res  = new ArrayList<>();
        for(int i = 0; i<case_n ; i++){
            int n = Integer.parseInt(br.readLine());
            map = new char[8][8];
            for(int j=0; j<8;j++){
                map[j] = br.readLine().toCharArray();
            }
            res.add(get_palindrome_count(n));
        }

        for(int i = 0; i<10; i++){
            System.out.println("#"+(i+1)+" "+res.get(i));
        }
    }

    static int get_palindrome_count(int n){
        int ret = 0;
        if(n==1) return 64; //3임? 64임?

        //가로
        for(int i=0 ; i<8 ; i++){
            for(int j=0 ; j<=(8-n) ; j++){
                char[] temp = new char[n];
                for(int k=0; k<n;k++){
                    temp[k] = map[i][j+k];
                }
                if(isStringPalin(String.valueOf(temp))) ret++;
            }
        }

        //세로
        for(int i=0 ; i<=(8-n) ; i++){
            for(int j=0 ; j<8 ; j++){
                char[] temp = new char[n];
                for(int k=0; k<n;k++){
                    temp[k] = map[i+k][j];
                }
                if(isStringPalin(String.valueOf(temp))) ret++;
            }
        }
        return ret;
    }

    static boolean isStringPalin(String s){
        char[] char_arr_s = s.toCharArray();
        char[] temp = new char[char_arr_s.length];
        for(int i=0; i<char_arr_s.length;i++){
            temp[i] = char_arr_s[char_arr_s.length-1-i];
        }
        return String.valueOf(char_arr_s).equals(String.valueOf(temp));

    }
}
