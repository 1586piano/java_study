package serial;

import java.io.Serializable;

class TextFile implements Serializable {

    private String fileName;
    private String fileBody;
    //password와 같이 보안상 직렬화가 되면 안되는 값의 경우 transient를 붙인다.
    //transient가 붙은 인스턴스변수의 값은 그 타입의 기본값으로 직렬화된다.
    transient private String password;

    TextFile(){
        this.fileName = "제목없음";
        this.fileBody = "내용없음";
        this.password = "1234";
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public void setFileBody(String fileBody){
        this.fileBody = fileBody;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getFileName(){
        return this.fileName.toString();
    }

    public String getFileBody(){
        return this.fileBody.toString();
    }

    public String getPassword(){ return this.password.toString();
    }

    @Override
    public String toString() {
        return "fileName : " + this.fileName + ", fileBody : " + this.fileBody + ", pw : " + this.password;
    }

}