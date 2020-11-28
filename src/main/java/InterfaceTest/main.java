package InterfaceTest;
public class main {

    public static void main(String[] args) {
        Tank tank = new Tank("tank1");
        Dropship dropship = new Dropship("dropship1");
        Marine marine = new Marine("marine1");
        SCV scv = new SCV("scv1");

        Action action = new Action();

        //scv는 탱크를 수리한다.
        action.repair(scv, tank);

        //탱크는 드랍쉽과 마린을 공격한다.
        action.attack(tank, dropship);
        action.attack(tank, marine);

        //마린은 기계가 아니라서 고칠 수 없다.
        //action.repair(scv, marine);

        //scv는 공격형 유닛이 아니라서 공격할 수 없다.
        //action.attack(scv, tank);
    }
}

//가장 큰 틀 Unit
class Unit{
    int hp;
    final int MAX_HP;
    final String NAME;
    final int POWER;

    Unit(int hp, int power, String name){
        this.hp = hp;
        MAX_HP = hp;
        POWER = power;
        NAME = name;
    }
}

//Unit 타입 공격
class AttackUnit extends Unit{
    AttackUnit(int hp, String name, int power){
        super(hp, power, name);
    }
}

//Unit 타입 공격x
class NonviolenceUnit extends Unit{
    NonviolenceUnit(int hp, String name){
        super(hp, 0, name);
    }
}

//Unit이 취할 수 있는 행동
class Action implements Repairable, Attackable {

    void repair(Unit repairMan, Repairable r){
        if(r instanceof Unit) {
            Unit u = (Unit) r;
            if (u.hp == u.MAX_HP) {
                System.out.println("HP is full");
                return;
            }
            while(u.hp!=u.MAX_HP){
                u.hp++;
            }
            System.out.println(repairMan.toString() + " fixed " + u.toString() + "." );
        }
    }

    void attack(Attackable attacker, Unit u){
        if(attacker instanceof Unit){
            u.hp -= ((Unit)attacker).POWER;
            System.out.println("The " + u.toString() + " was attacked by a " +  attacker.toString() + "," + u.toString() + " HP " + u.hp);
            if(u.hp<=0){
                System.out.println(u.toString() + " is dead.");
            }
        }
    }

}

//탱크는 공격, 수리가 가능한 유닛
class Tank extends AttackUnit implements Repairable, Attackable {

    final String NAME;
    Tank(String name){
        super(150, name, 50);
        hp = MAX_HP;
        NAME = name;
    }

    public String toString(){
        return NAME;
    }

}

class Dropship extends AttackUnit implements Repairable {
    final String NAME;

    Dropship(String name){
        super(125, name, 30);
        hp = MAX_HP;
        NAME = name;
    }

    public String toString(){
        return NAME;
    }

}

//마린은 공격은 가능하나 인간이기 때문에 수리 불가능
class Marine extends AttackUnit implements Attackable{
    final String NAME;

    Marine(String name){
        super(40, name, 15);
        hp = MAX_HP;
        NAME = name;
    }

    public String toString(){
        return NAME;
    }
}

//scv는 공격이 불가능한 유닛으로, 파워가 없음. 수리는 가능
class SCV extends NonviolenceUnit implements Repairable {
    final String NAME;

    SCV(String name){
        super(60, name);
        hp = MAX_HP;
        NAME = name;
    }

    public String toString(){
        return NAME;
    }

    void repair(Unit repairMan, Repairable r) {
        if(r instanceof Unit) {
            Unit u = (Unit) r;
            if (u.hp == u.MAX_HP) {
                System.out.println("HP is full");
                return;
            }
            while(u.hp!=u.MAX_HP){
                u.hp++;
            }
            System.out.println(repairMan.toString() + " fixed " + u.toString() + "." );
        }
    }
}

