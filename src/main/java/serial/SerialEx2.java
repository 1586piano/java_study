package serial;

import java.io.*;

public class SerialEx2 {
    public static void main(String[] args) throws Exception {

        Student student = new Student("JS", 123);

        // serialization
        TextFile file = new TextFile();
        file.setFileName("test");
        file.setFileBody("testFile");
        try (FileOutputStream fos = new FileOutputStream(String.valueOf(file));
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(student);
            oos.flush();
        }

        // deserialization
        Student result = null;
        try (FileInputStream fis = new FileInputStream(String.valueOf(file));
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Student) ois.readObject();
        }

        System.out.println(result.toString());
    }

    public static class Student implements Serializable {
        private String name;
        private int id;

        Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return "name : " + name + ", id : " + id;
        }
    }
}
