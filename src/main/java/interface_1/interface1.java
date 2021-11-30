package interface_1;

public class interface1 {
    public static void main(String[] args){
        //인터페이스 없이 A, B가 직접적인 관계에 있다.
        //B가 변경된다면, A도 변경되어야 한다.
        //A->B
        A a = new A();
        a.methodA(new B());

        //A->I->B 의 관계. A와 B는 직접적인 관계가 없다.
        //B가 없어지고, C가 생긴다면, C로 갈아끼워주면 된다.
        //인터페이스 I는 실제 구현 내용(클래스 B)를 감싸고 있는 껍데기이며, 클래스 A는 껍데기 안애 어떤 내용물이 있는지 몰라도 된다.
        Ai ai = new Ai();
        ai.methodA(new Bi());
    }
}
