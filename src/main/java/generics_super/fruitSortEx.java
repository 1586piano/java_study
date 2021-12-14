package generics_super;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Fruit{
    String name;
    int price;

    Fruit(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String toString() { return name+", "+price; }
}

class Apple extends Fruit{
    Apple(String name, int price) { super(name, price); }
}

class Grape extends Fruit{
    Grape(String name, int price) { super(name, price); }
}

class Box<T>{
    ArrayList<T> list = new ArrayList<T>();

    void add(T item){ list.add(item); }
    T get(int i){ return list.get(i); }
    ArrayList<T> getList(){ return list; }
    int size(){ return list.size(); }
    public String toString(){ return list.toString(); }
}

//Fruit을 상속받는 T타입의 객체를 저장하며, Box<T>클래스를 상속받는다.
class FruitBox<T extends Fruit> extends Box<T>{}

class FruitComp implements Comparator<Fruit> {
    @Override
    public int compare(Fruit o1, Fruit o2) {
        return o2.price - o1.price;
    }
}

public class fruitSortEx {
    public static void main(String[] args){
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();

        appleBox.add(new Apple("apple", 50));
        appleBox.add(new Apple("apple", 45));
        appleBox.add(new Apple("apple", 55));

        grapeBox.add(new Grape("grape", 20));
        grapeBox.add(new Grape("grape", 30));
        grapeBox.add(new Grape("grape", 50));

        System.out.println(appleBox);
        System.out.println(grapeBox);

        //첫번째 매개변수 list는 정렬할 대상, 두번째 매개변수 c는 정렬할 방법이 정의된 Comparator이다.
        //Comparator가 super이기 때문에 Fruit 타입인 경우, Fruit과 그 조성들만 가능하다.
        //와일드 카드를 사용하지 않는 경우, 모든 타입 Fruit, Apple, Grape에 대해 중복 Comparator를 작성해야 하며, 타입이 늘어나면 추가 작성이 필요하다.
        //public static <T> void sort(List<T> list, Comparator<? super T> c) {
        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(), new FruitComp());

        System.out.println(appleBox);
        System.out.println(grapeBox);
    }
}
