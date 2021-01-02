package comparator_comparable;

import java.util.Comparator;

public class Descending implements Comparator{
    public int compare(Object o1, Object o2){
        if( o1 instanceof Comparable && o2 instanceof Comparable){
            Comparable c1 = (Comparable)o1;
            Comparable c2 = (Comparable)o2;
            return c1.compareTo(c2) * -1 ; //-1을 곱해서 기본 정렬 방식의 역으로 변경. 객체의 순서를 바꿔도 된다.
        }
        return -1;
    }
}
