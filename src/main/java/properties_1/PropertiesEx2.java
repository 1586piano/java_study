package properties_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx2 {

    static class TextFile{
        private String fileName;
        private String fileBody;

        TextFile(){
            this.fileName = "제목없음";
            this.fileBody = "내용없음";
        }

        public void setFileName(String fileName){
            this.fileName = fileName;
        }

        public void setFileBody(String fileBody){
            this.fileBody = fileBody;
        }

        public String getFileName(){
            return this.fileName.toString();
        }

        public String getFileBody(){
            return this.fileBody.toString();
        }
    }

    //파일 오픈
    public static TextFile openFile(String fileName) throws IOException {
        TextFile f = new TextFile();
        FileReader fr = null;
        BufferedReader br = null;
        try{
            long start = System.currentTimeMillis();

            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String fileBody = "";
            while((br.readLine())!=null){
                fileBody+=br.readLine();
            }

            long end = System.currentTimeMillis();

            System.out.println("파일 오픈 시간: " + (end - start) + " ms");

            f.setFileName(fileName);
            f.setFileBody(fileBody);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }finally {
            if(br!=null) br.close();
            if(fr!=null) fr.close();
        }
        return f;
    }

    public static void readProperties(Properties prop, TextFile file){
        System.out.println(file.getFileBody());
        String[] argsFile = file.getFileBody().split(",");
        for( String line : argsFile){
            System.out.println("line: "+ line);
            String[] property = line.split("=");
            System.out.println("prop[0]: "+ property[0]);
            System.out.println("prop[1]: "+ property[1]);
            prop.setProperty(property[0], property[1]);
        }
    }

    public static void main(String[] args){
        TextFile file = null;
        try {
             file = openFile("propertiesTest.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Properties prop = new Properties();
        readProperties(prop, file);

        System.out.println("Result...");
        System.out.println(prop);

    }
}
