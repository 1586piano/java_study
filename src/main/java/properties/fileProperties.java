//데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공한다.
package properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class fileProperties {

    static Properties props = new Properties();

    public static void main(String[] args) {

        //파일로부터 프로퍼티를 읽어온다.
        loadProperties("properties.txt");
        props.list(System.out);

        props.setProperty("size", "100");

        //프로퍼티를 파일로 저장한다.
        saveProperties("properties2.txt");

    }

    public static void loadProperties(String inputFile){
        try {
            props.load(new FileInputStream(inputFile));
        } catch (IOException e) {
            System.out.println("could not find any file matching " + inputFile);
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void saveProperties(String outputFile){
        try {
            props.store(new FileOutputStream(outputFile),"testFile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
