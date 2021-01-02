//System클래스의 getProperties를 호출하여 시스템 관련 속성을 가져올 수 있다.
//실행 결과
//Java version : 1.8.0_131
//User language : ko
//-- listing properties --
//java.runtime.name=Java(TM) SE Runtime Environment
//sun.boot.library.path=C:\Program Files\Java\jdk1.8.0_131\jr...
//...

package properties;

import java.util.Properties;

public class systemProperties {
    public static void main(String[] args) {

        Properties props = System.getProperties();

        System.out.println("Java version : " + props.getProperty("java.version"));
        System.out.println("User language : " + props.getProperty("user.language"));

        props.list(System.out);
    }
}
