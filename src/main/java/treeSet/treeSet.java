//TreeSet은 이진 검색 트리 형태로 데이터를 저장하는 Collection 클래스이다.
//Set 인터페이스로 구현하여 중복 데이터를 허용하지 않으며, 정렬된 위치에 저장하므로 저장순서를 유지하지 않는다.
//이진 검색 트리 형태로 검색 성능을 향상시켰다.
//객체로 문자도 가능하나 정렬시 소문자, 대문자를 포함시킨다면 원하는 결과와 다를 수 있다. 원하는 결과를 위해서 Comparator를 사용하여 정렬 방식을 지정할 수 있다.

package treeSet;

import java.util.TreeSet;

public class treeSet {

    public static void main(String[] args) {

        TreeSet ts = new TreeSet();

        for(int i=0; ts.size()<6; i++){
            int num = (int) ((Math.random()*45) + 1);
            System.out.println(i+1+"번째 : " + num);
            ts.add(num);
        }

        ts.add(30);
        ts.add(100);

        //TreeSet은 정렬하여 저장한다.
        System.out.println("TreeSet : " + ts);

        //TreeSet의 첫번째 요소
        System.out.println("Min : " + ts.first());

        //TreeSet의 마지막 요소
        System.out.println("Max : " + ts.last());

        //TreeSet의 첫번째 요소 poll. (제일 작은 값의 객체)
        System.out.println("poll Min : " + ts.pollFirst());

        //TreeSet의 마지막 요소 poll. (제일 큰 값의 객체)
        System.out.println("poll Max : " + ts.pollLast());

        //subSet()을 이용한 TreeSet 범위 검색
        System.out.println("Range Search : " + ts.subSet(30, 100));

        //headSet과 tailSet을 이용한 지정 기준 값 기준 객체 얻기
        System.out.println("30보다 작은 값 : " + ts.headSet(30)); // x<30, haedSet(30, true)는 x<=30
        System.out.println("30보다 큰 값 : " + ts.tailSet(30)); // x>=30

        //descendingSet()을 이용하여 역순으로 정렬
        System.out.println("TreeSet : " + ts.descendingSet());

        //clone()을 이용하여 treeSet 복사
        TreeSet ts2 = (TreeSet) ts.clone();
        System.out.println("TreeSet ts2: " + ts2);

        //remove를 이용하여 객체 삭제
        ts2.remove(30);
        System.out.println("TreeSet ts: " + ts);
        System.out.println("TreeSet ts2 remove 30: " + ts2);

        //retainAll을 이용하여 공통된 요소만 남기고 나머지 요소 삭제
        ts.retainAll(ts2);
        System.out.println("TreeSet ts: " + ts);

        //lower() : 지정된 객체보다 작은.. 가장 가까운 값을 반환. 없을 시 null, higher()도 있음.
        System.out.println("lower : " + ts.lower(10));

        //contains() : treeSet에 10이 포함되어 있는지 확인. 반환값 boolean
        System.out.println("lower : " + ts.contains(10));

        //toArray()를 이용하여 treeSet을 객체배열로 반환
        Object[] arr = ts.toArray();
        System.out.print("arr : ");
        for(Object a : arr){
            System.out.print(a + ", ");
        }

     }



}
