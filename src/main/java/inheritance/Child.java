package inheritance;

public class Child extends Parent{

    int x = 20;
    Child(int age, String name) {
        //조상 클래스를 참조하여 사용하려면, 조상 클래스가 이미 생성되어 있어야 하므로, 조상 멤버를 super()생성자를 통해 먼저 초기화한다.
        //근데 여기서는 예시가 좀 잘못됐음. 이렇게 초기화하면 부모자식 이름이 같아짐.. 이런 구조가 아니라.. 모양-삼각형/네모/원형 같은 관계일 때 사용할 것 ㅋㅋ
        super(age, name);
    }

    void play(){
        System.out.println("널쟝");
    }

    //overriding. 조상으로부터 상속받은 메서드 변경
    void draw(String topic){
        String color = "노랑";
        System.out.println(topic + "을 그리고 "+color+"색으로 칠한다.");
    }

    //overloading. 기존에 없는 새로운 메서드 추가.
    void draw(String topic, String color){
        System.out.print(color+"색을 써서 ");
        //overloading으로 작업을 덧붙이고 조상클래스의 메서드를 수행시킬 수 있다.
        super.draw(topic);
    }

    int addX(){
        //super는 자손클래스에서 조상클래스로부터 상속받은 멤버롤 참조하는데 사용되는 참조변수
        //근본적으로 this.와 같은데.. 조상클래스의 멤버와 자손클래스의 멤버가 중복 정의된 경우에 사용하는 것이 좋다.
        //중복되지 않으면 그냥 this로 조상클래스의 멤버를 사용할 수 있다.
        return this.x + super.x;
    }

}
