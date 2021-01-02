//예외 선언과 try-catch를 이용한 예외 처리 학습

package exception_1;

class exception_1 {

    public static void main(String[] args) throws Exception {

        //try-catch 예제
        method1();

        try {
            //method에 예외 선언하는 예제.
            //method3에서 발생한 예외를 처리하지 않으면 main이 비정상 종료된다.
            method2();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception e : "+e.getMessage());
        }
        finally {
            //예외 발생여부와 관계없이 실행된다.
            //예외가 발생한 경우 : try-catch-finally
            //예외가 발생하지 않은 경우 : try-finally
            System.out.println("success");
        }
    }

    static void method1(){
        try{
            //ArithmeticException 발생
            System.out.println(0/0);

            //고의로 예외 발생
            Exception e = new Exception("Error~");
            throw e;

            //RuntimeException은 프로그래머의 실수에 의해 발생하기 때문에 예외처리를 강제하지 않는다.
            //RuntimeException - ArrayIndexOutOfBoundsException, NullPointerException 등
            //throw new RuntimeException();

        } catch (ArithmeticException ae) {
            ae.printStackTrace();
            System.out.println("0/0 : "+ae.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception e : "+e.getMessage());
        }
    }

    //반드시 처리해야만 하는 예외들만 선언하도록 한다.
    static void method2() throws Exception {
        //method3에 의해 전달되 예외는 method2에서 처리되지 않고, 메인으로 던져진다.
        method3();
    }

    //method3에서 발생한 예외는 method3에서 처리되지 않고 method2로 던진다.
    static void method3() throws Exception {
        throw new Exception("method3 Exception");
    }

}
