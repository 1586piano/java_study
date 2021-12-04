package thread;

//Runnable 인터페이스 구현 방식
public class MyThreadRunnable implements Runnable{

    @Override
    public void run() {
        //Runnable 인터페이스는 오로지 run()만 정의되어 있다. 이 몸통만 채워주면 된다.
        for(int i=0; i<5; i++){
            //Thread.currentThread : 현재 실행중인 쓰레드의 참조를 반환한다.
            System.out.println(Thread.currentThread().getName());
        }
    }
}
