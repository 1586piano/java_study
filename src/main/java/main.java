import java.util.ArrayList;
import java.util.Collections;

public class main {

    public static void main(String[] args) {
        //실제 크기보다 여유있게 설정한다. 크기를 넘어서면 새로운 객체를 생성하여 복사하는 일을 반복하게 된다.
        ArrayList list1 = new ArrayList(10);
        list1.add(new Integer(1));
        list1.add(new Integer(1));
        list1.add(new Integer(3));
        list1.add(new Integer(2));

        ArrayList list2 = (ArrayList) list1.clone();
        list2.add(new Integer(4));
        list2.add(new Integer(5));
        list2.add(new Integer(6));

        System.out.println("list1 : "+list1);
        System.out.println("list2 : "+list2);

        //정렬
        Collections.sort(list1);
        System.out.println("[sort] list1 : "+list1);

        //list2는 list1의 모든 요소를 포함하고 있다.
        System.out.println("[containsAll] list2.containsAll(list1) : "+list2.containsAll(list1));

        //set을 이용하여 특정 인덱스의 객체를 다른 객체로 변경한다.
        list1.set(1,"A");
        System.out.println("[set] list1 : "+list1);

        //get 특정 위치의 객체를 반환한다.
        System.out.println("[get] list1.get(1) list(1) : "+list1.get(1));

        //list2에서 list1과 겹치는 부분만 남기고 나머지는 삭제한다.
        System.out.println("[retainAll result] list2.retainAll(list1) : "+list2.retainAll(list1));
        System.out.println("[retainAll] list1 : "+list1);
        System.out.println("[retainAll] list2 : "+list2);

        //리스트 내 모든 객체 삭제
        list1.clear();
        System.out.println("[clear] list1 : "+list1);
    }

}