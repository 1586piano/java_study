package hashcode;

//Hashing : 데이터 관리 기법 중 하나로 다량의 데이터를 저장하고 검색하는 데 유용
//해시함수는 찾고자하는 값을 입력하면, 그 값이 저장된 위치를 알려주는 해시코드를 반환한다.
//해시코드는 중복될 수 있다..
//클래스의 인스턴스 변수 값으로 객체의 같고 다름을 판단해야 하는 경우라면, equals 메서드 뿐 만아니라 hashCode메서드도 적절히 오버라이딩 해야 한다.
//같은 객체라면 hashCode 메서드를 호출했을 때의 결과 값인 해시코드도 같아야하기 때문이다. 11장에서 자세히 설명.


import java.util.HashSet;
import java.util.Objects;

class Employee {
    private int id;
    private String name;

    void setId(int id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }
}


class Employee2 {
    private int id;
    private String name;

    void setId(int id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    public boolean equals(Object o) {
        Employee2 e = (Employee2) o;
        return (this.getId() == e.getId());
    }

    public String toString() {
        return (this.getId() + ", " + this.getName());
    }
}

class Employee3 {
    private int id;
    private String name;

    void setId(int id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    public boolean equals(Object o) {
        Employee3 e = (Employee3) o;
        return (this.getId() == e.getId());
    }

    public String toString() {
        return (this.getId() + ", " + this.getName());
    }

    public int hashCode() {
        //return (this.getId()+this.getName()).hashCode();
        //JDK1.8부터 java.util.Objects클래스의 hash()를 이용해서 작성할 수 있다. 이전 코드와 별반 다르지 않지만 아래 코드를 권장한다.
        return Objects.hash(this.getId(), this.getName());
    }
}


public class HashcodeTest {
    public static void identityHashcodeTest() {
        Employee3 e1 = new Employee3();
        Employee3 e2 = new Employee3();
        e1.setId(12345);
        e1.setName("song");
        e2.setId(12345);
        e2.setName("song");

        System.out.println("System.identityHashCode() Test");
        System.out.println("equals : " + e1.equals(e2));
        System.out.println("hashCode == : " + (e1.hashCode()==e2.hashCode()));
        System.out.println("identityHashCode == : " + (System.identityHashCode(e1)==System.identityHashCode(e2)));
        System.out.println("e1==e2 : " + (e1==e2));
        System.out.println("System.identityHashCode(e1) : " + System.identityHashCode(e1));
        System.out.println("System.identityHashCode(e2) : " + System.identityHashCode(e2));
    }

    public static void main(String[] args) {
        identityHashcodeTest();

        String str1 = new String("abc");
        String str2 = new String("abc");

        //equals는 두 객체가 같은지 검사한다.
        //만약 equals의 매개변수가 string 이라면, 먼저 length가 같은지 확인하고, length가 같다면 문자를 하나씩 끝까지 비교한다.
        System.out.println(str1.equals(str2));

        //hashCode란 객체를 식별하는 하나의 정수 값이다. hashCode()는 heap에 저장된 객체의 메모리 주소를 반환한다.
        //hashSet, hashMap, HashTable에서 hashCode를 이용해서 객체 동일성을 확인하고, equals로 다시 비교한다. 이 두개가 같아야 같은 값으로 본다.
        //HashTable에 key를 생성할 때, hashCode를 사용하고, 이 값이 충돌되는 경우, equals메서드를 사용한다. 같은 객체로 판단되면 기존 객체를 덮어쓰고, 그렇지 않다면, linkedlist에 추가하여 관리한다.
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str1.hashCode() == str2.hashCode());

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));


        Employee e1 = new Employee();
        Employee e2 = new Employee();

        e1.setId(134029);
        e1.setName("song");
        e2.setId(134029);
        e2.setName("song");

        System.out.println(e1.equals(e2)); //false
        System.out.println(e1.hashCode()); //1829164700
        System.out.println(e2.hashCode()); //2018699554

        //Employee2는 equals를 오버라이드했다.
        Employee2 e3 = new Employee2();
        Employee2 e4 = new Employee2();

        e3.setId(134029);
        e3.setName("song");
        e4.setId(134029);
        e4.setName("song");
        //equals는 ID를 비교하여 같은 경우 true를 반환하도록 했다. hashCode는 오버라이드 되지 않았다.
        System.out.println(e3.equals(e4)); //true
        System.out.println(e3.hashCode()); //1311053135
        System.out.println(e4.hashCode()); //118352462

        //HashSet에 저장될 때는 hashCode를 비교하여 같은 객체인지를 판단한다.
        //equals() true라도 hashCode가 다르므로, 다른 객체로 인식하여 같은 객체이지만 중복 저장된다.
        HashSet<Employee2> hs = new HashSet<>();
        hs.add(e3);
        hs.add(e4);
        System.out.println(hs.toString());

        //Employee3는 equals()와 hashCode()를 오버라이드했다.
        Employee3 e5 = new Employee3();
        Employee3 e6 = new Employee3();

        e5.setId(134029);
        e5.setName("song");
        e6.setId(134029);
        e6.setName("song");
        //equals는 ID를 비교하여 같은 경우 true를 반환하도록 했다. hashCode는 오버라이드 되지 않았다.
        System.out.println(e5.equals(e6)); //true
        System.out.println(e5.hashCode()); //1311053135
        System.out.println(e6.hashCode()); //118352462

        //HashSet에 저장될 때는 hashCode를 비교하여 같은 객체인지를 판단한다.
        //hashCode가 같다면 같은 객체로 판단한다. String의 경우, hashCode를 비교하고 equals()를 통해 비교한다.
        //hash 자료구조를 이용하여 저장하는 경우, equals만 오버라이드하고, hashCode를 오버라이드하지 않으면, Employee2와 같은 오류가 발생할 수 있다.
        //equals() true이면, hashCode도 같아야 한다.
        //하지만 hashCode가 같다고 해서 equals() true이지만은 않다. (해시 충돌이 발생할 수 있기 때문)
        //충돌이 발생하지 않아야 hash 자료구조의 성능이 향상된다. (충돌이 발생하면,, 충돌 처리를 해줘야 하지 떄문.. ex)linkedlist로 연결한다든지..)
        HashSet<Employee3> hs2 = new HashSet<>();
        hs2.add(e5);
        hs2.add(e6);
        System.out.println(hs2.toString()); //중복되지 않음
    }
}
