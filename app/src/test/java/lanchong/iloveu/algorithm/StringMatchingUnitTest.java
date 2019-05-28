package lanchong.iloveu.algorithm;


import org.junit.Test;

public class StringMatchingUnitTest {

    @Test
    public void bf() {
        StringMatching s = new StringMatching();
        System.out.println("result:" + s.bf("aaab","aab"));
    }

    @Test
    public void rk() {
        StringMatching s = new StringMatching();
        System.out.println("result:" + s.rk("aaaaab","aab"));
    }

}
