package inheritance;

public class Parent {

    int age;
    String name;
    int x = 10;

    Parent(int age, String name){
        this.age = age;
        this.name = name;
    }

    void run(){
        System.out.println("달리기");
    }

    void draw(String topic){
        System.out.println(topic + "을 그린다.");
    }



}
