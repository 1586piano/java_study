public class main {

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
