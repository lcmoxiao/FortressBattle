import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> al;
        LinkedList<Integer> ll;
        HashSet<Integer>hs;
        HashMap<Integer,Integer> hm;
    }


    private static class Human {
        int HP;
        int ATK;
        int DEF;
        int SPD;
        //每个职业都要实现的不可变的
        int range;      //攻击范围
        int DOD;        //闪避率
        boolean isAOE;  //范围攻击
        boolean isFLY;  //飞行

        //100  +
        //10ATK，  now/10
        public void setATK() {

        }

        public void setDEF() {

        }

        public void setHP() {

        }

        //  1
        public void setSPD() {

        }
    }
}
