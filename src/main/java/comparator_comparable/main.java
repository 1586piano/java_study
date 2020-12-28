package comparator_comparable;//Comparator와 Comparable
//Comparator와 Comparable은 모두 인터페이스로, 컬렉션을 정렬하는데 필요한 메소드를 정의하고 있다.
//Comparable: 기본 정렬 기준을 구현하는데 사용.
//Comparator : 다른 기준으로 정렬하고자 할 때 사용

import java.util.Arrays;
import java.util.Comparator;

public class main {

    public static void main(String[] args) {

        //Comparator 예제
        String[] sArr = {"d","e","b","a","c"};

        Arrays.sort(sArr);
        System.out.println("sArr : " + Arrays.toString(sArr));

        //역순으로 정렬하도록 Comparator 구현
        Arrays.sort(sArr,new Descending());
        System.out.println("sArr : " + Arrays.toString(sArr));


        Person a = new Person("ann", 27);
        Person b = new Person("byun", 29);
        Person c = new Person("choi", 28);
        Person[] person = {a, b, c};

        //Comparable 예제
        //정렬 기준 지정
        Arrays.sort(person);
        for (Person p:person) {
            System.out.println(p.name+", "+p.age);
        }
    }

}


class Descending implements Comparator{
    public int compare(Object o1, Object o2){
        if( o1 instanceof Comparable && o2 instanceof Comparable){
            Comparable c1 = (Comparable)o1;
            Comparable c2 = (Comparable)o2;
            return c1.compareTo(c2) * -1 ; //-1을 곱해서 기본 정렬 방식의 역으로 변경. 객체의 순서를 바꿔도 된다.
        }
        return -1;
    }
}

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    //사람의 정렬 기준은 나이
    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }
}
