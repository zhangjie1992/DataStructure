package lanchong.iloveu.algorithm;


import org.junit.Test;

import java.util.ArrayList;

public class GreedyAlogrithmUnitTest {


    @Test
    public void predictPartyVictory() {
        GreedyAlgorithm s = new GreedyAlgorithm();
        System.out.println("result:" + s.predictPartyVictory("RD"));
        System.out.println("result:" + s.predictPartyVictory("RDD"));
        System.out.println("result:" + s.predictPartyVictory("DDRRRR"));
    }

    @Test
    public void removeKdigits() {
        GreedyAlgorithm s = new GreedyAlgorithm();
        System.out.println("result:" + s.removeKdigits("10",1));
        System.out.println("result:" + s.removeKdigits("1000",2));
        System.out.println("result:" + s.removeKdigits("901",2));
        System.out.println("result:" + s.removeKdigits("229",2));
        System.out.println("result:" + s.removeKdigits("1432219",3));
        System.out.println("result:" + s.removeKdigits("10200",1));
        System.out.println("result:" + s.removeKdigits("10",2));
    }


    @Test
    public void canJump() {
        GreedyAlgorithm s = new GreedyAlgorithm();
//        int[] nums = {3,2,1,0,4};
//        int[] nums = {2,3,1,1,4};
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println("result:" + s.canJump(nums));
    }






}
