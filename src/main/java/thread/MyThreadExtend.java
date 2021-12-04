package thread;

public class MyThreadExtend extends Thread{
    public void run(){
        for(int i=0; i<5; i++){
            //getName() : 조상 쓰레드의 getName(); 호출
            System.out.println(getName());
        }
    }
}
