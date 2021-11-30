package interface_1;

class InstanceManager {
    //static으로 선언.
    public static I getInstance(){
        //다른 인스턴스로 변경하고 싶으면, 여기를 변경하면 되겠지!
        return new Bi();
    }
}
