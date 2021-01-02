//참조변수와 인스턴스의 연결
//조상 클래스에 선언된 멤버변수와 같은 이름의 인스턴스변수를 자손 클래스에 중복으로 정의했을 때, 조상타입의 참조변수로 자손 인스턴스를 참조하는 경우와 자손타입의 참조변수로 ㅏ손 인스턴스를 참조하는 경우는 서로 다른 결과를 얻는다.
//메서드의 경우 오버라이딩된 메서드가 호출되지만, 멤버변수의 경우 참조변수의 타입에 따라 달라진다.

package binding;

public class binding {

    public static void main(String[] args) {

        //부모타입의 참조변수 p를 자식 타입으로 인스턴스 생성
        Parent p = new Child();
        Child c = new Child();

        //멤버변수는 참조 타입(현재 부모 타입)을 따른다.
        System.out.println("p.x = "+p.x);
        //함수는 같은 이름으로 선언한 경우, 오버라이딩한 함수를 실행한다.
        p.method();
        System.out.println("c.x = "+c.x);
        c.method();
    }

    private static class Parent {
        String x = "I'm Parent";
        void method(){
            System.out.println("Parent");
            System.out.println("this.x = "+this.x);
        }
    }

    private static class Child extends Parent {
        String x = "I'm Child";
        void method(){
            System.out.println("Child");
            System.out.println("x = "+x);
            System.out.println("this.x = "+this.x);
            System.out.println("super.x = "+super.x);
        }
    }

}
