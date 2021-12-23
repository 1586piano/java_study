package hashcode;

import properties_1.PropertiesEx2;

import java.io.*;
import java.util.Scanner;

public class FileChecksumBuffered {
    //1. 파일 생성 : 제목과 내용을 입력받아 파일(객체)을 생성한다.
    //2. 파일 확인 : 생성한 파일 내용을 확인한다.
    //3. 파일 저장 : 생선한 파일을 txt 파일로 특정 경로에 저장한다.
    //4. 파일 일치 검사 : 두 파일명을 입력받아서 해시코드를 생성하여 파일 일치 여부를 반환한다.

    //파일 생성
    public static void createFile() throws IOException {

        TextFile file = new TextFile();

        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("파일명과 내용을 입력하시오.");
        System.out.println("--------------------------------");
        System.out.print("파일명 : ");
        String fileName = scan1.nextLine();
        System.out.println("--------------------------------");

        System.out.print("내용 : ");
        String fileBody = "";

        while( scan2.hasNext() ){
            String readLine = scan2.nextLine();
            if(readLine.equals("quit")){
                break;
            }else{
                fileBody += readLine + "\n";
            }
        }

        file.setFileName(fileName);
        file.setFileBody(fileBody);

        System.out.println(">> 입력한 파일 내용입니다.");
        readFile(file);
        saveFile(file);
        System.out.println(">> 파일을 생성하였습니다.");
    }

    //파일 내용 확인
    public static void readFile(TextFile file){
        System.out.println("--------------------------------");
        System.out.println("파일 제목 : " + file.getFileName());
        System.out.println("--------------------------------");
        System.out.println("파일 내용 : " + file.getFileBody());
        System.out.println("--------------------------------");
    }

    //파일 저장
    public static void saveFile(TextFile file) throws IOException {
        long start = System.currentTimeMillis();

        FileWriter fw = null;
        BufferedWriter bw = null;

        try{
            fw = new FileWriter(file.getFileName()+".txt");
            bw = new BufferedWriter(fw);
            bw.write(file.getFileBody());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //버퍼 안에 남은 데이터를 모두 flush한 후에 close한다.
            if(bw!=null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw!=null) fw.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("파일 저장 시간: " + (end - start) + " ms");
    }

    //파일 오픈
    public static TextFile openFile(String fileName) throws IOException {

        TextFile f = new TextFile();
        FileReader fr = null;
        BufferedReader br = null;
        StringBuilder bodyBuilder = new StringBuilder();

        try{
            long start = System.currentTimeMillis();

            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line ="";
            while((line = br.readLine())!= null){
                bodyBuilder.append(line);
            }

            long end = System.currentTimeMillis();

            System.out.println("파일 오픈 시간: " + (end - start) + " ms");

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

    //파일 일치 검사
    public static boolean checksum(){

        TextFile f1 = new TextFile();
        TextFile f2 = new TextFile();

        try {
            f1 = openFile("file1.txt");
            f2 = openFile("file1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if( (f1.getFileBody().hashCode()) == f2.getFileBody().hashCode() ){
            System.out.println("두 파일의 내용은 같습니다.");
        }else {
            System.out.println("두 파일의 내용은 다릅니다.");
        }
        //객체 고유의 값을 비교하는 경우 사용한다.
        if( (System.identityHashCode(f1)) == (System.identityHashCode(f2)) ){
            System.out.println("두 객체는 같습니다.");
        }else{
            System.out.println("두 객체는 다릅니다.");
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        System.out.println("작업 번호를 입력하시오 : ");
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()){
            case 1: createFile();
                    break;
            case 2: checksum();
                    break;
            case 3: readFile(openFile("properties2.txt"));
            default: System.out.println("작업 번호를 입력하시오 : ");
                    break;
        }
    }
}



