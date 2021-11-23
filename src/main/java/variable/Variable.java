package variable;

import java.util.Date;
import java.util.Scanner;

public class Variable {
    public static void main(String[] args){

        //primitive type : 실제 값 저장. 아래 8개 제외 나머지 reference type : 객체 주소 저장
        //boolean 제외 형변환 가능.작은 타입 -> 큰 타입(빈공간채움), 큰 타입 -> 작은 타입(손실 발생 가능성 존재)
        char val_char_1 = 'A';
        char val_char_2 = 65; //문자 코드 65 = A
        boolean val_boolean = true; //true of false 대문자 X
        byte val_byte = 1; // -128 ~ 127
        short val_short = 1; // -32,768 ~ 32,767
        int val_int = 1; // -2^31 ~ 2^31-1
        long val_long = 1; // -2^63 ~ 2^63-1
        float val_float_1 = (float) 3.14; // -1.4*10^-45 ~ 3.4*10^38. Java에서 실수는 기본적으로 double로 처리하려고 함. casting 또는 뒤에 f를 붙여주어야 함.
        float val_float_2 = 3.14f;
        double val_double = 3.14; // -4.9*10^-324 ~ 1.8*10^308

        System.out.println(val_byte);
        System.out.println(val_char_1);
        System.out.println(val_char_2);
        System.out.println(val_boolean);
        System.out.println(val_short);
        System.out.println(val_int);
        System.out.println(val_long);
        System.out.println(val_float_1);
        System.out.println(val_float_2);
        System.out.println(val_double);

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine(); //san.nextInt 정수로 입력받기
        int num = Integer.parseInt(input);
        String str_a = "song";
        System.out.println(str_a+'\t'+num); // \t : tab
        System.out.println(" \' "+" \" "+" \\ "); // ' " \

        //상수 : 값을 한번만 저장. 변경 X
        final int MAX_VALUE = 10;

        //printf 형식 지정 출력
        System.out.printf("int : %d%n", val_int);
        System.out.printf("float : %f%n", val_float_1);
        System.out.printf("float : %10.2f%n", val_float_1); //전체10자리, 소수점아래2, 우정렬

        //자동 형변환
        int i = 3;
        double d = 1.0 + i ; // 1.0 + (double)i 기존 값을 최대한 보존할 수 있도록 표현범위가 더 넓은 타입으로 자동 형변환
        System.out.println(d);
    }
}

