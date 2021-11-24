package switch_1;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args){
        //if문 예제- 등급
        int score = 0;
        char grade = ' ';
        char opt = ' ';

        System.out.println("점수를 입력하라 : ");
        Scanner scan = new Scanner(System.in);
        score = scan.nextInt();

        if(score>=90){
            grade = 'A';
            if(score>95){
                opt = '+';
            }else if(score==95){
                opt = ' ';
            }else{
                opt = '-';
            }
        }else{
            grade = 'F';
        }
        System.out.println("너는 " + opt + grade + "다.");

        //switch case문 예제 - 성적
        score = 0;
        grade = ' ';

        System.out.println("점수를 입력하라 : ");
        Scanner scan3 = new Scanner(System.in);
        score = scan3.nextInt();

        switch (score/10) { //보기에는 좋으나 조건이 많아질수록 불편하고, 조건에 제한이 많아서 불편.
            case 90 : grade = 'A';
            default: grade = 'F';
        }
        System.out.println("너는 " + grade + "다.");


        //switch case문 예제- 등급
        System.out.println("등급을 입력하셔요. : ");
        Scanner scan2 = new Scanner(System.in);
        String level = scan2.nextLine();

        System.out.println("당신이 받을 수 있는 혜택은.. ");

        switch ( level ){ //switch 문의 조건식 결과는 반드시 정수 또는 문자열이어야 한다.
            case "3" : //case 문의 값은 정수 상수만 가능하며, 중복되지 않아야 한다. '1', ONE(final int ONE=1 정수상수 ), "ONE" 가능. 변수, 1.0 등 불가
                System.out.println("기념일 선물 발송");
            case "2" : //case "2" case "0" : 과 같이 여러 조건을 한번에 쓸 수도 있음.
                System.out.println("5% 적립");
            case "1" :
                System.out.println("무료 음료 쿠폰");
                break; //break문은 각 case문의 영역 구분. 3,2,1 구간과 같이 생략하면 switch문의 블럭 끝을 만날 때 까지 모든 문장을 수행한다.
            default:
                System.out.println("아무 혜택 없음"); //default는 보통 마지막에 위치. 마지막 조건에는 break 문을 사용하지 않아도 됨. 사용해도 되고.
        }
    }
}
