package generics_1;

class Juice{
    public Juice(String juice){
        System.out.println(juice+"주스 완성!");
    }
}

class Juicer {
    //FruitBox<Fruit>으로 제한해버리면, Apple, Graple 등은 매개변수가 될 수 없다.
    //이 때, 와일드 카드 ? 를 사용한다. ? extends T는 T와 그 자손까지 가능, ? super T는 T와 그 조상들만, ? 만 사용하면, Object(모든 타입 가능)와 같다.
    static Juice makeJuice(Generics.FruitBox<? extends Fruit> box){
        String tmp="";
        for(Fruit f : box.getList()) tmp += f + " ";
        return new Juice(tmp);
    }
}
