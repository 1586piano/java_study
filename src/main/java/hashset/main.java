package hashset;

import java.util.HashSet;
import java.util.Set;

//hashset : 중복x,저장 순서x
//중복된 요소를 추가하고자 한다면 false 반환. hashset을 이용하여 중복 요소들을 쉽게 제거할 수 있다.
//저장 순서를 유지하고 싶다면, LinkedHashSet을 사용해야 한다.
public class main {

    public static void main(String[] args) {

        Object[] objArr = {"1", new Integer(1), "2", "4", "3", "3", "4"};

        Set hs1 = new HashSet<>();

        for(int i=0; i<objArr.length; i++){
            hs1.add(objArr[i]);
        }

        System.out.println(hs1);
        //결과 : [1, 1, 2, 3, 4]
        //1 : String, 1 : Integer, ...

        Set hs2 = new HashSet<>();

        hs2.add("abc");
        hs2.add("abc");
        hs2.add(new Person("Songhee",27));
        hs2.add(new Person("Songhee",27));

        System.out.println(hs2);
        //결과 : [abc, Songhee:27, Songhee:27]
        //Person객체의 이름과 나이가 같음에도 불구하고 서로 다른 것으로 인식하였다.


        Set hs3 = new HashSet<>();

        hs3.add("abc");
        hs3.add("abc");
        hs3.add(new Person2("Songhee",27));
        hs3.add(new Person2("Songhee",27));

        System.out.println(hs3);
        //결과 : [abc, Songhee:27]
    }

}

class Person{
    String name;
    int age;

    Person(String name, int age){
        this.name=name;
        this.age=age;
    }

    public String toString(){
        return name +":"+ age;
    }
}


class Person2 {
    String name;
    int age;

    Person2(String name, int age){
        this.name=name;
        this.age=age;
    }

    //HashSet의 add메서드는 새로운 요소를 추가하기 전에 기존 저장된 요소와 같은 것이 있는지 판별하기 위해 equals()와 hashCode()를 호출한다.
    //때문에 이를 목적에 맞게 오버라이딩하여 사용한다.
    //Person2객체 비교시 객체의 이름과 나이가 같은지를 비교
    public boolean equals(Object obj){
        if(obj instanceof Person2){
            Person2 tmp = (Person2)obj;
            return name.equals(tmp.name) && age==tmp.age;
        }
        return false;
    }

    //equals 비교에 의해 true를 얻은 두 객체에 대해 각각 hashCode()를 호출한 결과는 반드시 같아야 한다.
    //false를 얻어도 같은 hashCode가 나오는 것을 허용한다. 하지만 Hashtable이나 HashMap과 같은 컬렉션의 성능을 높이기 위해서는 가능한 서로 다른 값을 반환하도록 hashCode()를 잘 작성해야 한다.
    public int hashCode(){
        return (name+age).hashCode();
    }


    public String toString(){
        return name +":"+ age;
    }
}