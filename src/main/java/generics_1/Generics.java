package generics_1;

import java.util.ArrayList;

public class Generics {

    class Box1{
        private Object item;

        void setItem(Object item){
            this.item = item;
        }
        Object getItem(){
            return this.item;
        }
    }

    //Generic Class
    class Box2<T>{
        private T item;

        void setItem(T item){
            this.item = item;
        }
        T getItem(){
            return this.item;
        }
    }

    //Generic Class - 여러 객체를 저장할 수 있도록 arrayList 선언
    class Box3<T>{
        ArrayList<T> list = new ArrayList<T>();

        void add(T item){list.add(item);}
        T get(int i){ return list.get(i);}
        ArrayList<T> getList(){ return list;}
        int size(){ return list.size();}
        public String toString(){ return list.toString();}
    }

    //Box3 클래스 상속
    //<> 내에 extends를 붙여서 특정 타입의 자손들만 대입할 수 있도록 제한
    //특정 인터페이스를 구현한 특정 타입의 자손들만 대입할 수 있도록 제한하기 위해 &를 붙이고 extends를 이어 붙여서 제한한다. implements가 아님에 주의하자.
    class FruitBox<T extends Fruit & Eatable> extends Box3<T>{}

    public void createClass(){
        Box1 box1 = new Box1();
        box1.setItem("object");
        box1.setItem(1); // Object타입이므로 가능.
        //String item1 = (String) box1.getItem(); //형변환을 해야만 한다. int형을 넣었기 때문에 ClassCastException 오류 발생
        int intItem1 = (int) box1.getItem();

        Box2<String> box2 = new Box2<String>(); //T를 실제 타입 String으로 지정.
        //box2.setItem(1); 에러. String타입 이외는 지정 불가
        String item2 = box2.getItem();
        //int intItem2 = box2.getItem(); //에러.

        Box2 box2_1 = new Box2(); //T는 Object 타입으로 간주된다.

        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());

        System.out.println(fruitBox.toString());

        Juicer.makeJuice(fruitBox);
    }

    public static void main(String[] args){
        Generics g = new Generics();
        g.createClass();
    }
}
