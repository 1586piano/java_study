package hashcode;

//Hashing : 데이터 관리 기법 중 하나로 다량의 데이터를 저장하고 검색하는 데 유용
//해시함수는 찾고자하는 값을 입력하면, 그 값이 저장된 위치를 알려주는 해시코드를 반환한다.
//해시코드는 중복될 수 있다..
//클래스의 인스턴스 변수 값으로 객체의 같고 다름을 판단해야 하는 경우라면, equals 메서드 뿐 만아니라 hashCode메서드도 적절히 오버라이딩 해야 한다.
//같은 객체라면 hashCode 메서드를 호출했을 때의 결과 값인 해시코드도 같아야하기 때문이다. 11장에서 자세히 설명.
public class HashcodeTest {
    public static void main(String[] args){
        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println(str1.equals(str2));
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
    }
}
