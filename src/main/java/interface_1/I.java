package interface_1;

public interface I {
    //public임. public 생략가능
    abstract void methodBi();

    //인터페이스를 아무리 잘 생성해도 언젠가는 메서드가 추가될 수 있다.
    //인터페이스에 메서드가 추가되면 이를 구현한 모든 클래스들이 추가된 메서드를 구현하야 하는데...!
    //default 메서드라는 것은 그러지 않아도 된다. 구현해도 되고~ 안해도 되고!
    //앞에 default를 붙이고, 뒤에 몸체{} 를 붙여서 선언한다.
    default void newMethod(){};
}
