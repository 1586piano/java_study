//Date 클래스와 SimpleDateFormat 형식화 클래스
//SimpleDateFormat 클래스는 Date 클래스 결과를 원하는 형태로 다양하게 출력할 수 있도록 한다.

//실행 결과
//2020-12-21
//'20년 12월 21일 월요일
//2020-12-21 01:59:34.896
//2020-12-21 01:59:34 오전
//
//오늘은 올 해의 356번째 달입니다.
//오늘은 이 달의 21번째 날입니다.
//오늘은 올 해의 52번째 주입니다.
//오늘은 이 달의 4번째 주입니다.
//오늘은 이 달의 3번째 월요일입니다.
//
//2020-12-25

package simpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class simpleDateFormat {

    public static void main(String[] args) {
        Date today = new Date();

        SimpleDateFormat f1, f2, f3, f4;
        SimpleDateFormat f5, f6, f7, f8, f9;

        f1 = new SimpleDateFormat("yyyy-MM-dd");
        f2 = new SimpleDateFormat("''yy년 MMM dd일 E요일");
        f3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        f4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

        f5 = new SimpleDateFormat("오늘은 올 해의 D번째 달입니다.");
        f6 = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
        f7 = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
        f8 = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");
        f9 = new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다.");

        System.out.println(f1.format(today));
        System.out.println(f2.format(today));
        System.out.println(f3.format(today));
        System.out.println(f4.format(today));

        System.out.println();

        System.out.println(f5.format(today));
        System.out.println(f6.format(today));
        System.out.println(f7.format(today));
        System.out.println(f8.format(today));
        System.out.println(f9.format(today));

        System.out.println();

        //parse : String을 Date인스턴스로 변환
        try {
            Date d = f1.parse("2020-12-25");
            System.out.println(f1.format(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}