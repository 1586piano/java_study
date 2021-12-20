package time_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TimeCal {

    public static String calDate(String date, int num) throws ParseException {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat("yyyyMMdd").parse(date));
        cal.add(Calendar.DATE, num);
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime()).toString();
    }

    public static void main(String[] args) throws ParseException {
        System.out.println("날짜를 입력하세요. (yyyyMMdd): ");
        Scanner scan1 = new Scanner(System.in);
        String date = scan1.nextLine();

        System.out.println("계산할 날짜를 입력하세요. : ");
        Scanner scan2 = new Scanner(System.in);
        int num = scan2.nextInt();

        System.out.println(date + " " + num + "일 = " + calDate(date, num));
    }
}
