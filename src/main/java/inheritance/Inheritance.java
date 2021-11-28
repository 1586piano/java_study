package inheritance;

//상속(ingeritance) : 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것 extends
//상속을 받는 다는 것은 조상 클래스를 확장 한다는 의미로 해석할 수 있다.
//상속에 상속을 거듭할수록 상속받는 클래스의 멤버 개수는 점점 늘어나게 된다.
//조상 클래스에 새로운 멤버를 추가해주는 것은 자식 클래스에 모두 새로운 멤버를 추가해주는 것과 같다.
public class Inheritance {
    public static void main(String[] args){
        Parent parent = new Parent(49, "철수");
        Child child = new Child(15, "나미");

        //child에서는 run()가 존재하지 않지만 parent가 run함수를 가지고 있으므로 상속받아 사용 가능.
        child.run();

        //child에서는 Parent로부터 상속받은 draw()를 Overriding하여 기능을 추가하였다.
        //Overriding의 조건 : 이름, 매개변수, 반환타입이 같아야 한다.
        parent.draw("꽃");
        child.draw("꽃");

        child.draw("꽃", "빨강");

        System.out.println(child.x);
        System.out.println(parent.x);
        System.out.println(child.addX());
    }
}
