//사용자 정의 예외와 연결된 예외 학습

//실행 결과
//Not enough Memory
//        Delete tmp files
//        InstallException: Install Exception!
//        at main.install(main.java:17)
//        at main.main(main.java:7)
//        Caused by: MemoryException: Memory Exception!
//        at main.startinstall(main.java:30)
//        at main.install(main.java:15)
//        ... 1 more

package exception_2;

public class exception_2 {

    public static void main(String[] args){
        try{
            install();
        }catch (InstallException ie){
            ie.printStackTrace();
        }
    }

    static void install() throws InstallException{
        try{
            startinstall();
        }catch (MemoryException me){
            InstallException ie = new InstallException("Install Exception!");
            //설치 중 예외 발생의 원인을 설정한다.
            ie.initCause(me);
            //예외를 메인(intall을 실행시킨 곳)으로 던진다.
            throw ie;
        }finally {
            System.out.println("Delete tmp files");
        }
    }

    static void startinstall() throws MemoryException{
        if(!enoughMemory()){
            System.out.println("Not enough Memory");
            throw new MemoryException("Memory Exception!");
        }
    }

    static Boolean enoughMemory(){
        //예외를 발생시키기 위해 메모리가 없는 상태를 가정
        return false;
    }

}


//Exception클래스 또는 RuntimeException클래스를 상속받아 사용자 정의 예외 생성
class InstallException extends Exception {
    InstallException(String msg) { //String을 매개변수로 받아 메시지로 사용할 수 있다.
        super(msg);
    }
}

class MemoryException extends Exception {
    MemoryException(String msg) {
        super(msg);
    }
}
