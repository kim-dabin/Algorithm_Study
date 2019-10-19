package ParkJiHoon.FourthWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * 개선할 사항 : n만큼 계속 돌게 아니라 i,j 접근할때 탐색해주는게 좋을듯
 * 통과는 함..
 */
public class Palindrome_Two {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_n = 10;
        List<Integer> res  = new ArrayList<>();
        for(int i = 0; i<case_n ; i++){
            int n = Integer.parseInt(br.readLine());
            map = new char[100][100];
            for(int j=0; j<100;j++){
                map[j] = br.readLine().toCharArray();
            }
            int longest_pal = 0;//1일때 3개
            for(int j=2 ; j<=100;j++) {if(get_palindrome_count(j)) longest_pal =j;}

            res.add(longest_pal);
        }

        for(int i = 0; i<10; i++){
            System.out.println("#"+(i+1)+" "+res.get(i));
        }
    }

    static boolean get_palindrome_count(int n){
        int ret = 0;
        //가로
        loop:
        for(int i=0 ; i<100 ; i++){
            for(int j=0 ; j<=(100-n) ; j++){
                char[] temp = new char[n];
                for(int k=0; k<n;k++){
                    temp[k] = map[i][j+k];
                }
                if(isStringPalin(String.valueOf(temp))) {ret++;break loop;}
            }
        }

        //세로
        loop:
        for(int i=0 ; i<=(100-n) ; i++){
            for(int j=0 ; j<100 ; j++){
                char[] temp = new char[n];
                for(int k=0; k<n;k++){
                    temp[k] = map[i+k][j];
                }
                if(isStringPalin(String.valueOf(temp))) {ret++;break loop;}
            }
        }

        if(ret >0) return true;
        else return false;
//        return ret;
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
