package multiDimensionArray;

import java.util.Arrays;
import java.util.Scanner;

public class multiDimensionArray {

    public static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for(int j=0; j < arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        //2차원배열 선언
        int[][] score2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
        printArr(score2);

        //빙고 게임
        final int SIZE = 3;
        int[][] score1 = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for(int j=0; j < SIZE; j++){
                score1[i][j] = i * SIZE + j + 1;
            }
        }

        int x = 0;
        int y = 0;
        for (int i = 0; i < SIZE; i++) {
            for(int j=0; j < SIZE; j++){
                x = (int)(Math.random() * SIZE);
                y = (int)(Math.random() * SIZE);
                int tmp = score1[i][j];
                score1[i][j] = score1[x][y];
                score1[x][y] = tmp;
            }
        }
        printArr(score1);


        int input = 0;
        while (input!=-1){
            System.out.print("0부터 10 사이의 수를 입력하시요.");
            Scanner scan = new Scanner(System.in);
            input = scan.nextInt();
            if(0<input && input<10){
                for (int i = 0; i < score1.length; i++) {
                    for(int j=0; j < score1[0].length; j++){
                        if(score1[i][j]==input) score1[i][j]=0;
                    }
                }
            }else if(input==-1) System.out.print("프로그램 종료");
            printArr(score1);
        }
    }
}
