package overloading;

public class OverloadingStudy {

    //Overloading
    public static int add(int a, int b){
        System.out.println("add int");
        return a+b;
    }

    public static double add(double a, double b){
        System.out.println("add double");
        return a+b;
    }

    //가변인자(varargs) Overloading - 매개변수 수에 제약이 없다
    //concatenate(String str1, String str2, String str3, ....) -> String atr, String args로 !
    public static String concatenate(String str, String... args){

        for(String fator : args){
            str += fator;
        }
        return str;
    }

    /*
    가변인자 오버로딩은 매개변수로 구별이 되지 않는 경우가 발생할 수 있다. 따라서 가능하면 가변인자를 사용한 메서드는 오버로딩하지 않도록 한다.
    public static String concatenate(String... args){
        String result = "";
        for(String fator : args){
            result += fator;
        }
        return result;
    }
     */

    public static void main(String[] args){

        //Overloading Test
        System.out.println(add(1,2) );
        System.out.println(add(1.0,2.0));

        //varargs overloading Test
        System.out.println(concatenate("a","b"));
        System.out.println(concatenate("a","b","c","d"));

    }



}
