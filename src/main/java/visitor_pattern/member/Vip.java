package visitor_pattern.member;

import visitor_pattern.Benefit;
import visitor_pattern.Member;

public class Vip implements Member {
    @Override
    public void getBenefit(Benefit benefit) {
        benefit.getBenefit(this);
    }
}
