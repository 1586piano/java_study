package thread;

public class ThreadTest {
    public static void main(String[] args){
        //구현 방법
        // 1. Thread 클래스를 상속 받는다. -> Thread 클래스를 상속받으면 다른 클래스를 상속받을 수 없다.
        // 2. Runnable 인터페이스를 구현한다. -> 일반적이다. 재사용성이 높도 코드의 일관성을 유지할 수 있다.

        //1번 방법.. Thread의 자손 클래스의 인스턴스 생성
        MyThreadExtend th1 = new MyThreadExtend();

        //2번 방법.. Runnable을 구현한 클래스의 인스턴스 생성 후 Thread의 생성자를 통해 Runnable 인스턴스 r을 참조하도록 한다.
        /*
            @Override
            public void run() {
                if (target != null) {
                    target.run(); //Thread 클래스를 보면, 생성자를 통해 타켓(Runnable 인스턴스)을 받고, run()메소드를 target의 run()을 실행한다.
                }
            }
         */
        Runnable r = new MyThreadRunnable();
        Thread th2 = new Thread(r); // 생성자 Thread(Runnable target)
        //Thread th2 = new Thread(new MyTreadRunnable());

        //start를 호출 해야만 쓰레드가 실행된다.
        //start를 호출했다고 해서 바로 실행되는 것은 아니고, 실행대기 상태에 있다가 자신의 차례가 되어야 실행된다. 대기중인 쓰레드가 없으면 바로 실행되겠지만
        //Thread는 단 한번만 실행될 수 있다. 즉, 하나의 쓰레드에 대해 start()가 단 한 번만 호출될 수 있다.
        //하나의 쓰레드에 대해 두 번 이상 start()를 호출하면, IllegalThreadStateException이 발생한다.
        //th1 = new MyThreadExtend(); 와 같이 다시 생성해주어야 한다.
        //왜 run을 실행하지 않고 start를 실행하냐? run은 그냥 메소드이다.
        //start를 실행하면, thread가 작업을 수행하는데 필요한 콜스택을 생성한 다음에 거기에 run을 호출한다. 쓰레드가 종료되면 호출스택을 소멸된다.
        th1.start();
        th2.start();

        //데몬 쓰레드
        //일반 쓰레드의 보조적인 역할을 수행하는 쓰레드.
        //예를 들어서, 가비지컬렉터, 워드에서 자동저장, 화면 자동갱신 등의 기능을 데몬쓰레드로 구현한다.
        Thread damonThread = new Thread(new DamonThread());
        damonThread.setDaemon(true);
        damonThread.start();

        for(int i=0; i<=10; i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
