# java_study
자바 스터디를 위한 저장소

# 객체지향언어
재사용성, 유지보수, 중복 코드 제거

클래스 객체를 정의해놓은 것 또는 객체의 설계도 또는 틀
클래스로부터 객체를 만드는 과정을 클래스의 인스턴스화라고 하며, 클래스로부터 만들어진 객체를 클래스의 인스턴스라고 한다.

1. 변수 : 하나의 데이터를 저장할 수 있는 공간
2. 배열 : 같은 종류의 여러 데이터를 하나의 집합으로 저장할 수 있는 공간
3. 구조체 : 서로 관련된 여러 데이터를 종류에 관계없이 하나의 집합으로 저장할 수 있는 공간
4. 클래스 : 데이터와 함수의 결합(구조체+함수)
ex) TV 설계도가 클래스라면, TV는 객체(TV클래스의 인스턴스)이다.

Tv t; //Tv 클래스 타입의 참조변수 선언
Cancel changes
t = new Tv(); //new 연산자를 통해 Tv클래스의 인스터스가 메모리 빈 공간에 생성됨

예제는 classStudy 참고

## 오버로딩과 오버라이딩
  1. 오버로딩 : 기존에 없는 새로운 메서드를 정의하는 것.
      testFunc() {} -> testFunc(int a) {}
  2. 오버라이딩 : 상속받은 메서드의 내용을 변경하는 것.
      이름, 매개변수, 반환타입이 같아야한다. 내용만 변경되는 것.
      parent class{ int testFunc(int a){return a;} } -> child class { int testFunc(int a){ System.out.println(a); return a;} }\
      
예제는 inheritance, overloading 참고
  
## 제어자
#### 접근 제어자
public > protected > (default) > private
클래스나 멤버(변수,메서드)에 접근 제어자를 두어 데이터를 보호. 외부에서 함부로 데이터를 변경하지 못하도록 접근을 제어. data hiding, 캡슐화에 해당
외부에서 접근할 필요가 없는 멤버들을 private으로 지정하여 외부에 노출시키지 않음으로써 복잡성을 줄임
만약 코드가 일부 변경되었을 때, 접근 제어가 public이라면 오류 테스트의 범위가 넓어짐. 하지만 접근제어자가 private이라면 클래스 하나만 살피면 됨.
1. private 같은 클래스 내에서만 접근 가능. 같은 클래스 내에서만 접근이 가능하기 때문에 오버라이딩 될 수 없음.
2. protected 같은 패키지 내. + 자손 클래스에서 접근이 가능하도록 함
3. public 제한이 없다.
4. default는 같은 패키지 내에서만 접근
#### 그 외
1. static
    static 변수는 하나의 변수를 모든 인스턴스가 공유. 클래스가 메모리에 로드될 때 생성되기 때문에 인스턴스 생성 없이 사용 가능.
    static 메서드는 인스턴스 생성 없이 호출이 가능하며, static 메서드 내에서는 인스턴스맴버들을 직접 사용할 수 없음. 인스턴스 생성 없이 호출이 가능하기 때문에 인스턴스 멤버는 사용할 수 없음. 따라서 인스턴스 멤버를 사용하지 않는 메서드에 static을 붙이면, 더 편리하고 속도도 빠름
2. final
    마지막의, 변경될 수 없는.
    final 변수 : 변경할 수 없는 상수
    final 메서드는 : 오버라이딩 할 수 없음
    final class : 확장 불가능. 따라서 다른 클래스의 조상이 될 수 없음.
3. abstract
    미완성의. 메서드의 선언부만 작성하고, 실제 수행내요은 구현하지 않은 추상 메서드 선언에 사용. 
    추상 클래스는 아직 완성되지 않은 메서드가 존재하는 미완성된 설계도이므로, 인스턴스를 생성할 수 없음.
    다른 크래스가 이 클래스를 상속받아서 일부 원하는 메서드만 오버라이딩해서 사용.
    
    
## 추상 클래스와 인터페이스
추상클래스 : 미완성 설계도. 상속을 통해 자손클래스에서 구현하도록 함. 여러 클래스의 공통점을 찾아내서 공통 조상을 만드는 작업. 생명체 추상 클래스{ 걷기 메소드, 나이 변수} - 사람, 동물 등이 자손 클래스가 될 수 있음
인터페이스 : 일종의 추상클래스. 추상클래스보다 추상화 정도가 높음. 추상클래스와 달리 몸통을 갖춘 일반 메서드 또는 멤버변수를 구성원으로 가질 수 없다. 오직 추상 메서드와 상수만을 멤버로 가질 수 있다. ex) interface 인터페이스 { public static final a = 값; public abstract 메서드이름(매개변수목록); }  <- 메서드 몸통 X


추상클래스는 IS - A "~이다". 
  ex) 생명체는 번식한다, 나이가 있다. (공통된 부분)
인터페이스는 HAS - A "~을 할 수 있는".
  ex) 사람은 말을 할 수 있다, 동물은 울 수 있다. 등
예제는 InterfaceTest 참고.

#### 인터페이스의 장점
1. 개발 시간 단축 : 인터페이스를 먼저 작성되면, 메서드 호출 쪽에서는 메서드의 내용과 관계없이 선언부만을 가지고 코드를 작성할 수 있다.
2. 표준화 가능 : 프로젝트에 사용되는 기본 틀을 인터페이스로 제공
3. 서로 관계없는 클래스들에게 관계를 맺어줄 수 있음 : 서로 상속관계도 아니고, 같은 조상클래스를 가지고 있지 않은 아무런 관계가 없는 클래스들에게 하나의 인터페이스를 공통적으로 구현하도록 함으로써 관계를 맺어줄 수 있다.
4. 독립적인 프로그래밍 : 클래스의 선언과 구현을 분리. - 예를 들어, 한 DB회사가 특정 DB를 사용하는데, 필요한 클래스를 사용해서 프로그램을 작성하고 추후 다른 DB를 사용하고자 한다면, DB관련 코드를 모두 변경해야 할 것이다. 하지만 DB 관련 인터페이스를 정의하고, 이를 이용해서 프로그램을 작성하면 DB의 종류가 변경되더라도 프로그램을 변경하지 않도록 할 수 있다.

#### default method
인터페이스를 아무리 잘 생성해도 언젠가는 메서드가 추가될 수 있다.
인터페이스에 메서드가 추가되면 이를 구현한 모든 클래스들이 추가된 메서드를 구현하야 한다.
이럴 때 default method를 사용할 수 있다. default method는 구현해도 되고, 하지 않아도 된다.
일반적인 method 생성 방식에서 앞에 default를 붙이고, 뒤에 몸체{} 를 붙여서 선언한다.
 
## 예외처리(Exception handling)
#### 프로그램 오류 
1. 컴파일 에러 : 컴파일 시에 발생하는 에러(checked)
2. 런타임 에러 : 실행 시에 발생하는 에러(unchecked)
3. 논리적 에러 : 실행은 되지만, 의도와 다르게 동작하는 것
#### Error & Exception
Error : 메모리 부족 이나 스택오버플로우 등 발생하면 심각한 오류
Exception : 발생하더라도 수습될 수 있는 비교적 덜 심각한 것
예제는 Exception 참고.

## Thread
#### 프로세스
- 실행 중인 프로그램. 프로그램을 실행하면 OS로부터 자원을 할당받아 프로세스가 된다.
- 프로그램을 수행하는 데 필요한 데이터와 메모리 등의 자원 그리고 쓰레드로 구성되어 있다.
- 프로세스는 최소 하나 이상의 쓰레드가 존재하며, 둘 이상의 쓰레드를 가진 프로세스를 멀티 쓰레드 프로세스 라고 한다.
- 여러 프로세스가 동시에 실행 될 수 있는 것은 멀티태스킹이라고 한다.
#### 쓰레드
- 프로세스의 자원을 이용해서 실제로 작업을 수행하는 것이 쓰레드이다.
- 프로세스 당 쓰레드의 수는 제한되어 있지 않다.
- 쓰레드가 작업을 수행하는데 개별적인 메모리 공간(호출스택)을 필요로 하기 때문에 프로세스의 메모리 한계에 따라 생성할 수 있는 쓰레드 수가 결정된다.
- 멀티쓰레드는 여러 쓰레드가 한 프로세스 내에서 자원을 공유하여 작업해야 하기 떄문에 동기화, 교착상태와 같은 문제들을 고려하여 프로그래밍해야 한다.
예제는 Thread 참고. 


## I/O
#### 스트림
한쪽에서 다른 쪽으로 데이터를 전달하면, 두 대상을 연결하고 데이터를 전송할 수 있는 무언가가 필요한데, 이것을 스트림이라고 한다.
스트림은 연속적인 데이터의 흐름을 물에 비유하여 붙여진 이름이다. 스트림은 단방향 통신만 가능하기에, 하나의 스트림으로 입력과 출력을 동시에 처리할 수는 없다.
스트림은 먼저 보낸 데이터를 먼저 받게 된다. Queue형태이며, FIFO 구조이다.
사용하고 닫지 않은 스트림은 자동으로 JVM이 닫아주지만, close()를 이용해서 스트림을 닫아 자원을 반환하는 것을 권장한다.
flush()는 버퍼가 있는 출력스트림의 경우에만 의미가 있으며, 모든 내용을 출력 소스에 쓰는 역할을 한다. OutputStream에 정의된 flush()는 아무 일도 하지 않는다. 
- 출력스트림
- 입력스트림

#### 바이트기반 스트림
바이트 단위로 데이터를 전송하는 스트림이다.
입출력 대상 종류에 따라 다름과 같이 구분 한다.
스트림 / 입출력 대상
FileInput/OutputStream / File
ByteArrayInput/OutputStream / Memory(ByteArray)
PipedInput/OutputStream / Process (프로세스 간의 통신)
AudioInput/OutputStream / Audio 장치

#### 문자기반 스트림
바이트 기반 스트림은, 입출력의 단위가 1 byte이다.
Java에서는 char형이 2 byte이기 때문에 바이트기반 스트림으로 문자를 처리하기에는 어려움이 있다.
따라서 문제 데이터를 입출력 할 때는 문자 기반 스트림을 이용한다.
Input/OutputStream -> Reader/Writer
문자 기반 스트림 / 입출력 대상
FileReader/Writer / File
CharArrayReader/Writer / Memort(ByteArray)
PipedReader/Writer / Process (프로세스 간의 통신)
StringReader/Writer

#### 보조 스트림
실제 데이터를 주고 받는 스트림은 아니지만, 스트림의 기능을 향상시키거나 새로운 기능을 추가시는 것을 목적으로 하는 스트림이다.
스트림을 먼저 생성한 후에 보조 스트림을 생성하여 사용한다.
* DataInputStream은 더이상 읽을 데이터가 없는 경우, EOFException을 발생시킨다. 따라서 catch문을 이용해서 데이터를 읽는다.
* 또한 DataInputStream을 닫을 때, null이라면 NullPointerException이 발생하므로, 스트림이 null인지 체크한 후에 close()를 호출해야 한다. close()는 IOException이 발생할 수 있으므로, try/catch로 감싸주어야 하는데, 작업 중 예외로 try 블록을 모두 실행하지 못하는 경우도 발생할 수 있으니 finally안에 넣어주는 것이 더 확실한 방법이다.
ex) FileInputStream을 사용할 때, 보조스트림 BufferedInputStream을 사용하면 버퍼를 사용하여 입력 성능을 향상시킬 수 있다. 읽어들인 데이터를 버퍼에 채워두었다가 버퍼가 가득차면, 출력 소스에 출력한다. 다만, 버퍼가 가득 차야만 출력하기 때문에 마지막에는 버퍼에 남는 데이터가 있을 수 있다. 보조스트림 close()나 flush()를 호출에서 마지막 버퍼에 남은 데이터를 출력소스에 쓸 수 있도록 한다. close()는 flush를 호출한 후에 close되도록 설계되어있다. 
- 바이트 기반 보조스트림 종류 871p 참고.
- 문자 기반 보조스트림 종류 873p 참고.
HashCode 예제 참고.

## 지네릭스
다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입체크를 해주는 기능이다.
#### 장점
- 타입 안정성 제공 : 의도하지 않은 타입의 객체가 저장되는 것을 막고, 저장된 객체를 꺼내올 때 원래의 타입과 다른 타입으로 잘못 형변환되어 발생할 수 있는 오류를 줄인다.
- 타입 체크와 형변환 생략으로 코드가 간결해짐
Generics 예제 참고.

## 람다식
람다식은 메서드를 하나의 식으로 표현한 것이다. 
메서드를 람다식으로 표현하면, 메서드의 이름과 반환값이 없어지므로, 람다식을 익명함수라고도 한다.
메서드는 클래스에 포함되어야 하므로, 클래스도 새로 만들어야 하고, 객체도 생성해야만 비로소 호출 가능하지만, 람다식은 이 모든 과정없이 오직 람다식 자체만으로 메서드의 역할을 대신할 수 있다.

Ramda 예제 참고.

## HashCode
#### hashCode 
- hashCode란 객체를 식별하는 하나의 정수 값이다. hashCode()는 heap에 저장된 객체의 메모리 주소를 반환한다.
- String의 경우, hashCode를 생성할 때 문자를 한글자씩 읽어서 정수 값으로 만들기 때문에 같은 문자열인 경우 같은 해시코드를 반환한다. 
- 때로는 문자열 조합에 따라 다른 문자열인데도 같은 해시코드를 반환할 수도 있다. 
- 때문에 haspSet/Map/Table에서 key의 동치성을 비교할 때는 1차적으로 hashCode 값을 비교하고, 이가 같은 경우에 equals로 문자열 자체를 비교한다. 두 조건을 모두 충족한 경우를 같은 값이라고 본다.
- hashCode는 저장 구조 측면에서 객체를 식별하기 위한 정수 값이며, equals를 객체 동치성을 비교하는 것이 목적이다. * equals는 본래 object를 비교. String의 경우 문자비교.
- 하지만 hashCode가 같다고 해서 equals() true이지만은 않다. (해시 충돌이 발생할 수 있기 때문)
- 충돌이 발생하지 않아야 hash 자료구조의 성능이 향상된다. (충돌이 발생하면,, 충돌 처리를 해줘야 하지 떄문.. ex)linkedlist로 연결한다든지..)
