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
        StringBuilder bodyBuilder = new StringBuilder();
        try{
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line ="";
            while((line = br.readLine())!= null){
                bodyBuilder.append(line);
            }
            f.setFileName(fileName);
            f.setFileBody(bodyBuilder.toString());
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
        String fileBody = file.getFileBody();
        String[] argsFile = fileBody.split(",");
        for( String line : argsFile){
            String[] property = line.split("=");
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
