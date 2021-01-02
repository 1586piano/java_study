//해싱이란 해시함수를 이용해서 데이터를 해시테이블에 저장하고 검색하는 기법을 말한다.
//해시함수는 데이터가 저장되어 있는 곳을 알려주기 때문에 많은 데이터 중 원하는 데이터를 빠르게 찾을 수 있게 한다.
//해싱을 구현한 함수로, HashSet, HashMap, Hashtable 등이 있다. Hashtable보다는 HashMap을 사용하도록 한다.
//해시함수를 이용한 데이터 검색
// 1. 검색하고자 하는 값의 키로 해시 함수를 호출한다.
// 2. 해시함수의 계산결과(해시코드)로 해당 값이 저장되어 있는 링크드 리스트를 찾는다.
// 3. 링크드 리스트에서 검색한 키와 일치하는 데이터를 찾는다.

package hashMap;

import java.util.*;

public class login {
    public static void main(String[] args) {

        HashMap user = new HashMap();
        //key는 중복 불가.unique
        user.put("id1", "1234");
        user.put("id2", "1234");
        user.put("id3", "1234");

        //entrySet을 이용하여 키와 값을 읽어 올 수 있다. getKey, getValue
        Set set = user.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println("ID : " + entry.getKey() + ", PW : " + entry.getValue());
        }

        Scanner s = new Scanner(System.in);

        while(true){
            System.out.print("ID : ");
            String id = s.nextLine().trim();

            if(!user.containsKey(id)){
                System.out.println("ID does not exist. Please try again.");
                continue;
            }else{
                System.out.print("PW : ");
                String pw = s.nextLine().trim();

                if(!(user.get(id)).equals(pw)){
                    System.out.println("Passwords do not match. Please try again.");
                }else {
                    System.out.println("login");
                    break;
                }
            }
        }

    }
}
