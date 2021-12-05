package thread;

public class MyThreadExtend extends Thread{
    public void run(){
        int i = 10;
        while(i!=0 && !isInterrupted()){
            System.out.println(i--);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                interrupt();
                //sleep때문에 스레드가 멈춘 상태이기때문에 interruptedException이 발생되고, 쓰레드 interrupted가 false로 자동 초기화된다. 때문에 카운트가 종료되지 않는것.
                //여기서 interrupt를 걸어줘야지 true로 바뀌면서 카운트가 중단된다.
            }
        }
        System.out.println("시스템이 종료되었습니다.");
    }
}
