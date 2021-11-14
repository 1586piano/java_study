package visitor_pattern.benefit;

import visitor_pattern.Benefit;
import visitor_pattern.member.Gold;
import visitor_pattern.member.Vip;

public class Point implements Benefit {
    @Override
    public void getBenefit(Vip member) {
        System.out.println("VIP point : 10% point");
    }

    @Override
    public void getBenefit(Gold member) {
        System.out.println("GOLD point : 5% point");
    }
}
