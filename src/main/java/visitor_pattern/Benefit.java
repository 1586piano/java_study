package visitor_pattern;

import visitor_pattern.member.Gold;
import visitor_pattern.member.Vip;

public interface Benefit {
    void getBenefit(Vip member);
    void getBenefit(Gold member);
}
