//Properties(String, String)는 Hashtable을 상속받아 구현한 것으로, Hashtable(Object, Object)에 비해 단순화된 컬럭션클래스이다.
//주로 애플리케이션의 환경설정과 관련된 속성을 저장하는데 사용된다.
//Hashtable을 상속받았으므로, 저장순서를 유지하지 않는다

package properties;

import java.util.Enumeration;
import java.util.Properties;

public class properties {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("timeout", "30");
        props.setProperty("size", "10");
        props.setProperty("capacity", "10");

        //컬럭션 프레임웍의 이전 버전이므로 Iterator가 아닌 Enumeration을 사용한다.
        Enumeration e = props.propertyNames();
        while (e.hasMoreElements()){
            String element = (String) e.nextElement();
            System.out.println(element + " = " + props.getProperty(element));
        }
        System.out.println();

        //size의 값을 20으로 변경
        props.setProperty("size", "20");
        System.out.println("size = " + props.getProperty("size"));
        System.out.println();

        //list를 이용하면 편리하게 출력할 수 있다.
        System.out.println(props);
        props.list(System.out);

        //getProperty로 저장된 값을 읽어온다. 만일 저장된 값이 존재하지 않으면 기본값을 반환한다.
        System.out.println("language = " + props.getProperty("language", "kr"));

    }
}
