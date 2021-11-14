//Visitor Pattern ? 로직과 구조를 분리하는 방식으로, 구조를 수정하지 않고도 새로운 동작을 기존 객체 구조에 추가할 수 있다.
//1. 언제 Visitor Pattern을 사용할까? 적용해야 할 대상 객체가 잘 바뀌지 않을 때. 만약 Member가 늘어나면 모든 Benefit 구상 객체가 수정되어야 함.
//2. 적용할 알고리즘이 추가될 가능성이 많은 경우. 혜택이 많아지면 Benefit만 새로 구현하면 됨.
//적용할 알고리즘과 객체를 분리함으로써 코드의 응집도가 높아진다.
//객체에 적용되는 알고리즘을 보고 싶다면, 알고리즘 구상 클래스(여기서는 benefit 구상 클래스)만 보면 된다.
//만약 위 1, 2번의 조건에 만족하는데, 이러한 방식으로 구현하지 않고, 객체 내에 알고리즘이 포함된 방식이면 헤택이 늘어날 때 마다 로직을 전부 손대야 하며, 이러한 과정에서 정확도 또한 떨어질 수 있다.
package visitor_pattern;

import visitor_pattern.benefit.Discount;
import visitor_pattern.benefit.FreeBeverage;
import visitor_pattern.benefit.Point;
import visitor_pattern.member.Gold;
import visitor_pattern.member.Vip;
import java.util.ArrayList;
import java.util.Iterator;

public class visitor_pattern {
    public static void main(String[] args){
        Member vip = new Vip();
        Member gold = new Gold();

        Benefit point_benefit = new Point();
        Benefit discount_benefit = new Discount();
        //새로운 혜택 추가 시 benefit 구현
        Benefit freeBeverage = new FreeBeverage();

        ArrayList<Member> members = new ArrayList<>();
        members.add(vip);
        members.add(gold);


        Iterator<Member> it = members.iterator();

        while( it.hasNext() ){
            Member member = it.next();
            member.getBenefit(point_benefit);
            member.getBenefit(discount_benefit);
            //새로운 혜택 추가
            member.getBenefit(freeBeverage);
        }
    }
}
