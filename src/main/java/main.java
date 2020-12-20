//날짜와 시간 비교

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.JapaneseDate;

public class main {

    public static void main(String[] args) {

        //생성 및 요소 변경
        LocalDate today = LocalDate.now();
        LocalDate today2 = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate tomorrow = today.plusDays(1);
        LocalTime now = LocalTime.now();

        //of()로 지정하여 생성
        LocalDate kDate = LocalDate.of(1999, 12, 31);
        JapaneseDate jDate = JapaneseDate.of(1999, 12, 31);
        LocalTime time = LocalTime.of(23,59,59);

        //equals는 모든 필드가 일치해야 같다고 판단하지만, isEqual은 날짜만 비교한다.
        System.out.println(kDate.equals(jDate)); //false
        System.out.println(kDate.isEqual(jDate)); //true

        System.out.println(today.isBefore(kDate)); //false
        System.out.println(today.isAfter(kDate)); //true

        System.out.println(now.isBefore(time)); //true
        System.out.println(now.isAfter(time)); //false

        //compareTo가 오버라이딩 되어 있다.
        System.out.println(today.compareTo(today2)); //0 같음
        System.out.println(today.compareTo(yesterday)); //1
        System.out.println(today.compareTo(tomorrow)); //-1
        System.out.println(now.compareTo(time)); //-1
    }

}