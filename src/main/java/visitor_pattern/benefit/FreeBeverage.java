package visitor_pattern.benefit;

import visitor_pattern.Benefit;
import visitor_pattern.member.Gold;
import visitor_pattern.member.Vip;

public class FreeBeverage implements Benefit {
    @Override
    public void getBenefit(Vip member) {
        System.out.println("VIP : 2");
    }

    @Override
    public void getBenefit(Gold member) {
        System.out.println("GOLD : 1");
    }
}
