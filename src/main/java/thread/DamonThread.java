package thread;

public class DamonThread implements Runnable{

    static boolean autoSave = false;
    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(3 * 1000);//3초 마다
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(autoSave){
                autoSave();
            }
        }
    }

    public void autoSave(){
        System.out.println("자동저장되었습니다.");
    }
}
