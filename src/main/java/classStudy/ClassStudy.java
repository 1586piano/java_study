package classStudy;

public class ClassStudy {
    public static void main(String[] args){
        Tv tv = new Tv();
        tv.setChannelDown();

        System.out.println("Tv color: "+tv.color);
        System.out.println("Tv channel: "+tv.getChannel());
        tv.setChannel(11);
        System.out.println("Tv channel: "+tv.getChannel());

        //클래스를 배열에 담아보자~
        Tv[] tvArr = new Tv[3];

        for(int i=0; i<tvArr.length; i++){
            tvArr[i] = new Tv("red"); //같은 타입의 객체만 배열에 담았다. 다형성을 배우면 하나의 배열로 여러 종류의 객체를 다룰 수 있다.
        }

        //클래스변수 직접 접근
        System.out.println("가로 : "+Tv.width+" 세로 : "+Tv.height);
        System.out.println("가로 : "+tv.width+" 세로 : "+tv.height);
        Tv.width=200;
        //클래스변수를 변경하면, 모든 인스턴스의 값이 바뀐다.
        System.out.println("가로 : "+tv.width+" 세로 : "+tv.height);
        System.out.println("가로 : "+tvArr[0].width+" 세로 : "+tvArr[0].height);

        Tv tv2 = new Tv(tv);
        System.out.println("Tv1 color: "+tv.color);
        System.out.println("Tv1 channel: "+tv.getChannel());
        System.out.println("Tv1 power: "+tv.power);

        System.out.println("Tv2 color: "+tv2.color);
        System.out.println("Tv2 channel: "+tv2.getChannel());
        System.out.println("Tv2 power: "+tv2.power);

    }
}
