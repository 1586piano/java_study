//HashMap학습을 위해 전화번호부를 구현한다.
//번호를 key로 hashMap을 생성하고, 번호와 이름을 포함하는 객체를 묶을 group을 생성한다.
//group은 그룹명을 key로 하고, key:번호 value:이름의 HashMap 객체를 value로 한다.

package hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class phoneBook {

    static HashMap phoneBook = new HashMap();

    public static void main(String[] args) {
        addPhoneNo("친구", "서라", "010-1234-0000");
        addPhoneNo("친구", "소현", "010-1234-0001");
        addPhoneNo("동아리", "연희", "010-1234-0002");
        addPhoneNo("기타", "핸드폰가게","010-1234-0003");
        addPhoneNo("기타", "중국집","010-1234-0004");
        addPhoneNo("기타", "AS센터","010-1234-0005");

        printList();
    }

    static void addPhoneNo(String groupName, String name, String tel){
        addGroup(groupName);
        //그룹을 추가하면서 생성한 객체를 group 객체로 생성
        HashMap group = (HashMap) phoneBook.get(groupName);
        group.put(name, tel);
    }

    static void addGroup(String groupName){
        //기존에 그룹이 존재하지 않으면 새로운 그룹을 생성하고, value는 이름과 번호가 들어갈 hashMap객체
        if(!phoneBook.containsKey(groupName)){
            phoneBook.put(groupName, new HashMap());
        }
    }

    static void printList(){
        Set set = phoneBook.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();

            Set subset = ((HashMap)entry.getValue()).entrySet();
            Iterator subIt = subset.iterator();

            System.out.println(" -" + entry.getKey() + "[" + subset.size() + "]");
            while(subIt.hasNext()){
                Map.Entry subEntry = (Map.Entry) subIt.next();
                String tel = (String) subEntry.getKey();
                String name = (String) subEntry.getValue();
                System.out.println("name : " + name + ", tel : " + tel);
            }
            System.out.println();

        }
    }

}

