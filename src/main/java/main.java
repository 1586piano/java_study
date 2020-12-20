// Date와 time

//실행 결과
//2020-12-21
//'20년 12월 21일 월요일
//2020-12-21 01:59:34.896
//오늘은 올 해의 356번째 달입니다.
//오늘은 이 달의 21번째 날입니다.
//오늘은 올 해의 52번째 주입니다.
//오늘은 이 달의 4번째 주입니다.
//오늘은 이 달의 4번째 월요일입니다.

import java.time.*;
import java.time.format.DateTimeFormatter;

public class main {

    public static void main(String[] args) {

        //LocalData + LocalTime = LocalDateTime
        LocalDate d = LocalDate.now();
        LocalDate date = d.withMonth(11);
        LocalTime time = LocalTime.parse("23:59:59");
        LocalDateTime datetime = LocalDateTime.of(date,time);

        //LocalDateTime -> LocalData, LocalTime
        //LocalDate date = datetime.toLocalDate();
        //LocalTime time = datetime.toLocalTime();

        //LocalDataTime + time-zone = ZonedDataTime
        //ZonedDateTime zdt = ZonedDateTime.now();
        ZoneId zid = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdt = datetime.atZone(zid);

        //plusHours함수를 통해 시간 변경. ZonedDateTime을 반환하기 떄문에 새로운 객체로 받는다.
        ZonedDateTime zdt2 = zdt.plusHours(9);

        String[] patternArr = {
                "yyyy-MM-dd",
                "''yy년 MMM dd일 E요일",
                "yyyy-MM-dd HH:mm:ss.SSS",
                "오늘은 올 해의 D번째 달입니다.",
                "오늘은 이 달의 d번째 날입니다.",
                "오늘은 올 해의 w번째 주입니다.",
                "오늘은 이 달의 W번째 주입니다.",
                "오늘은 이 달의 W번째 E요일입니다."
        };

        for(String p : patternArr){
            //ofPattern을 통해 포맷을 변경한다.
            DateTimeFormatter f = DateTimeFormatter.ofPattern(p);
            System.out.println(zdt2.format(f));
        }

    }

}