package array;

import java.util.Arrays;

public class ArrayStudy {
    public static void main(String[] args){

        //배열 선언. 배열을 다루기 위한 참조변수를 선언한 것
        int[] score;

        //new 연산자를 통해 int형 데이터 5개를 저장할 수 있는 공간 생성
        //4byte * 5
        //인덱스는 0~4
        score = new int[5];
        //score = new int[5] {1, 2, 3, 4, 5} 배열 생성과 초기화를 동시에

        //한줄로도 표현 가능
        // int[] score = new int[5];
        //int[] score = {1, 2, 3, 4, 5} new int[배열길이] 생략 가능(선언과 함께 할 때만 생략 가능)

        //인덱스 범위를 넘어서면 ArrayIndexOutOfBoundsException 발생
        //배열의 길이를 직접 적어넣기보다는 score.length를 사용하여 인덱스 범위를 넘어서는 일이 없도록 한다.
        for(int i=0; i<5; i++){
            score[i]=(int)(Math.random()*10) + 1;
        }

        //출력1
        System.out.print("반복문을 이용한 출력 : ");
        for(int s : score){
            System.out.print(s+" ");
        }
        System.out.println("");

        //출력2
        System.out.println("Arrays.배열 메서드를 이용한 출력 : " + Arrays.toString(score));

        //길이가 0인 배열 생성
        int[] arr = new int[0];
        System.out.println("길이가 0인 배열 : " + arr.length);
        //arr.length=10; 배열의 길이는 한번 생성하면 변경할 수 없다. 그러므로 배열의 길이는 상수이며, 변경 불가능하다.

        //String 배열 생성 - String 배열은 char배열에 여러 기능을 추가하여 확장한 것이다.
        //String 배열과 char배열의 한가지 중요한 차이점은 String은 읽을 수만 있고 내용을 변경할 수 없다. 변경하는 것 처럼 보이지만 새로 생성되는 것.
        String[] name = new String[]{"song", "hee"};
        System.out.println("String 배열 출력 : " + Arrays.toString(name));
        System.out.println("name[0] 문자열에서 0 인덱스의 문자 : " + name[0].charAt(0));
        System.out.println("name[1] 문자열에서 0~1 인덱스의 문자 : " + name[0].substring(0,1));

        String str = "songhee";
        char[] chArr = str.toCharArray();
        String str2 = new String(chArr);
        System.out.println("String -> char 배열 : " + Arrays.toString(chArr));
        System.out.println("char 배열 -> String : " + str2);


        //배열의 길이 변경하기1
        // 1. 더 큰 배열을 생성한다.
        // 2. 기존 배열의 내용을 새로운 배열에 복사한다.
        // 3. 기존 배열(참조변수)가 담고 있는 주소를 새 배열의 주소로 변경한다.
        int[] copyTestArr = new int[5];
        int[] longArr = new int[copyTestArr.length*2];

        for(int i=0; i<copyTestArr.length; i++){
            copyTestArr[i] = (int)(Math.random()*10) + 1;
        }

        for(int i=0; i<copyTestArr.length; i++){
            longArr[i] = copyTestArr[i];
        }

        copyTestArr = longArr;
        System.out.println("변경된 배열의 길이 : " + copyTestArr.length);
        //남는 공간은 int형 기본 값 0으로 초기화
        System.out.println("변경된 배열의 요소를 출력해보자!@ : " + Arrays.toString(copyTestArr));

        //배열의 길이 변경하기2
        char[] rightArr = {'a', 'b', 'c'};
        char[] leftArr = {'1', '2', '3'};
        //복사하려는 내용보다 여유 공간이 없으면 ArrayIndexOutOfBoundsException발생
        char[] resultArr = new char[rightArr.length+leftArr.length];

        //rightArr의 0에서 resultArr의 0으로, rigthArr.length개 복사
        System.arraycopy(rightArr, 0, resultArr, 0, rightArr.length);
        System.arraycopy(leftArr, 0, resultArr, rightArr.length, leftArr.length);
        //char 배열은 참조변수를 넘겨주면 요소가 출력된다.
        System.out.println(resultArr);

        //정리하자면, for문으로 배열 요소 하나하나 접근하는 것보다 arraycopy를 이용하는 것이 더 빠르다.
        //배열의 요소가 연속적으로 저장되어 있기 때문에 arraycopy로 범위를 지정해주면 통째로 복사하기 때문이다.
    }
}
