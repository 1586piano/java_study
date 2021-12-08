package hashcode;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileChecksum {
    //1. 파일 생성 : 제목과 내용을 입력받아 파일(객체)을 생성한다.
    //2. 파일 확인 : 생성한 파일 내용을 확인한다.
    //3. 파일 저장 : 생선한 파일을 txt 파일로 특정 경로에 저장한다.
    //4. 파일 일치 검사 : 두 파일명을 입력받아서 해시코드를 생성하여 파일 일치 여부를 반환한다.

    //파일 생성
    public static void createFile(){

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
    public static void saveFile(TextFile file){
        try{
            FileWriter fw = new FileWriter(file.getFileName()+".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(file.getFileBody());
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //파일 오픈
    public static TextFile openFile(String fileName) throws IOException {
        TextFile f = new TextFile();
        try{
            FileInputStream fos = new FileInputStream(fileName);
            DataInputStream dos = new DataInputStream(fos);
            String fileBody = dos.readUTF();
            f.setFileName(fileName);
            f.setFileBody(fileBody);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
        //f가 비어있지 않다면 return
        return f;
    }

    //디렉토리 내 파일 전부 오픈
    public static TextFile openFiles(String fileName) throws IOException {
        ArrayList<TextFile> fileList = new ArrayList<>();
        TextFile f = new TextFile();
        try{
            FileInputStream fos = new FileInputStream(fileName);
            DataInputStream dos = new DataInputStream(fos);
            String fileBody = dos.readUTF();
            f.setFileName(fileName);
            f.setFileBody(fileBody);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
        //f가 비어있지 않다면 return
        return f;
    }

    //파일 일치 검사
    public static boolean checksum(){

        TextFile f1 = new TextFile();
        TextFile f2 = new TextFile();
        try {
            f1 = openFile("file1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            f2 = openFile("file2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if( (f1.getFileBody().hashCode()) == f2.getFileBody().hashCode() ){
            System.out.println("두 파일의 내용은 같습니다.");
        }else {
            System.out.println("두 파일의 내용은 다릅니다.");
        }
        if( (System.identityHashCode(f1)) == (System.identityHashCode(f2)) ){
            System.out.println("두 파일은 같습니다.");
        }else{
            System.out.println("두 파일은 다릅니다.");
        }
        return true;
    }

    public static void main(String[] args){

        System.out.println("작업 번호를 입력하시오 : ");
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()){
            case 1: createFile();
                    break;
            case 2: checksum();
                    break;
            default: System.out.println("작업 번호를 입력하시오 : ");
                    break;
        }
    }
}



