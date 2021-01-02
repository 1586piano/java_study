//LinkedList는 ArrayList와 마찬가지로 List 인터페이스를 구현했기 때문에 메소드의 종류는 거의 동일하다.
//컬렉션             읽기    추가/삭제                   비고
//ArrayList         빠름      느림      순차적인 추가/삭제는 빠름. 비효율적인 메모리 사용
//LikedList         느림      빠름      데이터가 많을수록 접근성이 떨어짐.

//실행 결과(데이터의 크기와 양에 따라 결과가 달라질 수 있다.)
//- 처음부터 순차적으로 객체 추가 -
// ArrayList : 246
// LinkedList : 3414
//
// - 중간에 객체 추가 -
// ArrayList : 8916
// LinkedList : 58
//
// - 뒤에서부터 순차적으로 삭제 -
// ArrayList : 21
// LinkedList : 69
//
// - 처음부터 객체 삭제 -
// ArrayList : 2350
// LinkedList : 541

package linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class linkedList {

    public static void main(String[] args) {

        ArrayList al = new ArrayList(2000000);
        LinkedList ll = new LinkedList();

        System.out.println("- 처음부터 순차적으로 객체 추가 -");
        System.out.println("ArrayList : "+add1(al));
        System.out.println("LinkedList : "+add1(ll));
        System.out.println("");

        System.out.println("- 중간에 객체 추가 -");
        System.out.println("ArrayList : "+add2(al));
        System.out.println("LinkedList : "+add2(ll));
        System.out.println("");

        System.out.println("- 뒤에서부터 순차적으로 삭제 -");
        System.out.println("ArrayList : "+remove1(al));
        System.out.println("LinkedList : "+remove1(ll));
        System.out.println("");

        add3(al);
        add3(ll);
        System.out.println("- 처음부터 객체 삭제 -");
        System.out.println("ArrayList : "+remove2(al));
        System.out.println("LinkedList : "+remove2(ll));
        System.out.println("");

    }

    //순차적으로 객체를 추가하는 함수. 객체를 추가하는 데 걸린 시간을 반환한다.
    public static long add1(List list){
        long start = System.currentTimeMillis();
        for(int i=0; i<1999999; i++) list.add(i+"");
        long end = System.currentTimeMillis();
        return end-start;
    }

    //list의 중간에 계속해서 객체를 추가하는 함수
    public static long add2(List list){
        long start = System.currentTimeMillis();
        for(int i=0; i<10000; i++) list.add(1000,"X");
        long end = System.currentTimeMillis();
        return end-start;
    }


    //가장 뒤에서부터 순차적으로 객체를 삭제하는 함수
    public static long remove1(List list){
        long start = System.currentTimeMillis();
        for(int i=list.size()-1; i>=0; i--) list.remove(i);
        long end = System.currentTimeMillis();
        return end-start;
    }

    //list의 중간객체를 삭제하는 함수
    public static long remove2(List list){
        long start = System.currentTimeMillis();
        for(int i=1000; i<10000; i++) list.remove(i);
        long end = System.currentTimeMillis();
        return end-start;
    }

    //삭제하기 전 데이터를 채워놓는 용도
    public static void add3(List list){
        for(int i=0; i<1000000; i++) list.add(i+"");
    }


}