// StringTokenizer, Split 비교

//실행 결과
// P|||S||H| -> result.length() : 6
// P|S|H| -> Token num : 3
import java.util.StringTokenizer;

public class main {

    public static void main(String[] args) {
        String data = "P,,,S,,H";

        //split은 데이ㅓ를 토큰으로 잘라낸 결과를 배열에 담는다.상대적으로 성능이 떨어진다.
        String[] result = data.split(",");
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] +"|");
        }
        System.out.println(" -> result.length() : "+result.length);

        //Stringtokenizer는 토큰을 반환하여 바로 사용하고, 빈 문자열을 토큰으로 인식하지 않는다.
        StringTokenizer st = new StringTokenizer(data,",");
        int i=0;
        for(; st.hasMoreTokens(); i++){
            System.out.print(st.nextToken() +"|");
        }
        System.out.println(" -> Token num : "+i);

    }

}