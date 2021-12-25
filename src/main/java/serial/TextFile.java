package serial;

class TextFile {
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