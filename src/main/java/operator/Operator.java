package operator;
//연산 시 타입에 따라 데이터 손실이 발생할 수 있으므로 주의하자!

public class Operator {
    public static void main(String[] args){

        //int를 int로 나누면 결과도 int! 5/2는 2.5지만 소수점 이하는 버려진다.
        int val_int = 5/2;
        double val_double_1 = 5/2;

        //피연산자 중 하나라도 실수라면 실수형 결과가 나온다.
        double val_double_2 = 5/2.0;
        System.out.println("int : "+val_int);
        System.out.println("double : "+val_double_1);
        System.out.println("double : "+val_double_2);

        byte val_byte1 = 10;
        byte val_byte2 = 20;
        byte val_byte3 = (byte) (val_byte1 * val_byte2);
        //결과 -56, byte는 -128~127까지만 표현 가능. 200은 이 범위를 넘기 때문에 데이터 손실 발생.
        //int형은 32bit, byte는 8bit로 int->byte 형변환 시에 int형의 앞 24자리를 잘라내면서 데이터 손실 발생.
        System.out.println("val_byte1 * val_byte2 =" + val_byte3);

        int val_int_1 = 1000000;
        int val_int_2 = 2000000;
        long val_long_1 = val_int_1 * val_int_2; // int*int 는 int. 이 경우 표현 범위를 넘었기 때문에 데이터 손실 발생. 손실 이후 long 타입으로 저장하므로 오류는 안남.
        long val_long_2 = (long)val_int_1 * val_int_2; // 계산식에 바로 long으로 형변환. 또는 피연산자 한 쪽이라도 L을 붙여도 같은 결과을 냄.
        System.out.println("val_int_1 * val_int_2 =" + val_long_1);
        System.out.println("(long)val_int_1 * val_int_2 =" + val_long_2);

         double val_double_3 = 0.3;
         double val_double_4 = val_double_3 < 0.5 ? 0 : 0.5;
         System.out.println(val_double_4); //결과는 0.0 -> 조건 연산자의 피연산자도 자동형변환된다.

        //val_int=2 양수:1, 0:0, 음수:-1 ->  조건연산자를 중첩해서도 쓴다. 중첩될수록 가독성은 별로
        int val_int_3 = val_int > 0 ? 1 : ( val_int == 0 ? 0 : -1 );
        System.out.println(val_int_3);
    }
}
