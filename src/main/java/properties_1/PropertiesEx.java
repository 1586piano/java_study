package properties_1;

import java.util.Enumeration;
import java.util.Properties;

//Properties는 HashTable을 상속받아 구현했다.
//HashTable은 키와 값을 (Object, Object)의 형태로 저장하는데 비해 Properties는 (String, String)형태로 저장하는 보다 단순화된 컬렉션클래스이다.
//주로 애플리케이션 환경설정과 관련된 속정을 저장하는데 사용된다.
public class PropertiesEx {
    public static void main(String[] args){
        Properties prop = new Properties();
        prop.setProperty("timeout", "30");
        prop.setProperty("language", "kr");
        prop.setProperty("size", "10");

        //prop에 저장된 요소를 Enumeration을 이용하여 출력
        Enumeration e = prop.propertyNames();
        while (e.hasMoreElements()){
            String el = (String) e.nextElement();
            System.out.println(el + "=" + prop.getProperty(el));
        }

        System.out.println(prop);
        prop.list(System.out);

        //읽어오려는 key 값이 존재하지 않으면 null을 반환한다.
        String test = prop.getProperty("none");
        System.out.println(test);

        String test2 = prop.getProperty("size");

    }
}
