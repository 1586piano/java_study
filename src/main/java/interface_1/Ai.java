package interface_1;

public class Ai {
    public void methodA(){
        //static으로 선언했기 때문에 인스턴스 생성 없이 수행
        I i = InstanceManager.getInstance();
        i.methodBi();
    }
}
