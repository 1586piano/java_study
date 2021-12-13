package generics;

interface Eatable{}

class Fruit implements Eatable {
    public String toString(){
        return "Fruit";
    }
}

class Apple extends Fruit{
    public String toString(){
        return "Apple";
    }
}
class Grape extends Fruit{
    public String toString(){
        return "Grape";
    }
}