package ramda;

import java.util.*;

public class RamdaExpression{

    static void printArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println("");
    }

    static int method1(){
        return (int)(Math.random()*5 +1);
    }

    public static void main(String[] args){
        //메서드
        int[] randomArr1 = new int[5];
        for(int i=0; i<randomArr1.length; i++){
            randomArr1[i] = method1();
        }
        printArr(randomArr1);

        //람다식 표현
        int[] randomArr2 = new int[5];
        Arrays.setAll(randomArr2, (i) -> (int)(Math.random()*5+1));
        printArr(randomArr2);

        //일반적인 String 비교 메서드 오버라이드
        List<String> list1 = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        //람다식 표현
        List<String> list2 = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
        Collections.sort(list2, (o1, o2) -> o2.compareTo(o1));

        list1.forEach(i-> System.out.println(i+", "));
        list2.forEach(i-> System.out.println(i+", "));

        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list3);
        list3.replaceAll(x-> x*10);
        System.out.println(list3);
        Map<String, String> map = new HashMap<>();
        map.put("1", "A");
        map.put("2", "B");
        map.forEach((k,v)-> System.out.println("K : " + k + ", V : " + v));

        //지네릭스, 열거형, 애너테이션 먼저 학습 후 806p하단 부터
    }
    

}
