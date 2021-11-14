package visitor_pattern.benefit;

import visitor_pattern.Benefit;
import visitor_pattern.member.Gold;
import visitor_pattern.member.Vip;

public class Discount implements Benefit {
    @Override
    public void getBenefit(Vip member) {
        System.out.println("VIP discount : 30%");
    }

    @Override
    public void getBenefit(Gold member) {
        System.out.println("GOLD discount : 20%");
    }
}
