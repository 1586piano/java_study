package enum_1;
//enum
//서로 관련된 상수를 편리하게 선언하기 위한 것으로 여러 상수를 정의할 때 사용하면 유용하다.
//그냥 상수로 선언해도 되지만, 접근성이 좋으며, 관리에 용이하여 논리적인 오류를 줄일 수 있다.
//값 비교 뿐만 아니라 타입 체크도 가능하기 떄문에 타입에 안전하다.

enum DevType {

    SERVER(0), WEB(1), MOBILE(2), DATA(3);

    private final int value;

    //private Direction(int value)와 동일. 묵시적으로 enum 생성자는 private이기 때문
    //내부에서 저장하기 위한 변수로, 외부에서 접근이 불가능하다.
    DevType(int value) {
        this.value = value;
    }

    //외부에서 값을 얻을 수 있도록 추가해준다.
    public int getValue() {
        return this.value;
    }
}

class Employee {
    String name;
    DevType devType;

    Employee() {
    }

    Employee(String name, DevType devType) {
        this.name = name;
        this.devType = devType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDevType(DevType devType) {
        this.devType = devType;
    }

    public String getName() {
        return this.name;
    }

    public DevType getDevType() {
        return this.devType;
    }

    public boolean equals(Employee e) {
        if (this.name == e.name && this.devType == e.devType) {
            return true;
        }
        return false;
    }
}


public class enumTest {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setName("song");
        e1.setDevType(DevType.DATA);

        Employee e2 = new Employee();
        e2.setName("park");
        e2.setDevType(DevType.MOBILE);

        Employee e3 = new Employee();
        e3.setName("song");
        e3.setDevType(DevType.DATA);
        //e3.setDevType(DevType.HR);  enum에 선언되지 않은 value 사용 불가

        //같은 타입의로 선언된 enum 객체는 비교가 가능하다.
        //Enum 열거형 상수 하나하나는 DevType의 객체이며, 따라서 객체의 주소이므로 바뀌지 않는 값이다. 따라서 ==비교가 가능하다.
        System.out.println(DevType.DATA == DevType.DATA);
        System.out.println(DevType.DATA == DevType.MOBILE);

        System.out.println(e1.equals(e2));
        System.out.println(e1.equals(e3));

        System.out.println(e1.devType.getValue()); //3
    }


}
