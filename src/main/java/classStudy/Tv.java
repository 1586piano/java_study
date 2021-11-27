package classStudy;

public class Tv {

    //인스턴스 변수 : 인스턴스의 독립적인 변수
    String color;
    boolean power;
    //제어자를 통해 변수의 값을 직접 변경하지 못하도록 한다. 아래 setChannel, getChannel등의 메서드를 통해 값을 변경하도록 한다.
    private int channel = 1;

    //클래스변수 : 클래스 공유변수. 모든 인스턴스가 공통된 저장공간을 공유한다. 한 클래스의 모든 인스턴스들이 공통된 값을 유지해야 하는 경우 사용.
    //인스턴스 변수와 달리 인스턴스를 생성하지 않고 바로 사용하능하며, 클래스이름.클래스변수 와 같은 형식으로 사용한다.
    //클래스가 메모리가 로딩될 때 생성되어 프로그램 종료까지 유지된다.
    static int width = 100;
    static int height = 80;

    void power(){
        power = !power;
    }

    void setChannelUp(){
        if(this.channel<10){
            this.channel++;
        }
    }

    void setChannelDown(){
        if(this.channel>0){
            this.channel--;
        }
    }

    void setChannel(int channel){
        if(channel>0 && channel<=10){
            this.channel=channel;
        }
    }

    int getChannel(){
        return this.channel;
    }
}
