package lanchong.iloveu.algorithm;


import org.junit.Test;

public class DynamicProgrammingUnitTest {


    @Test
    public void fibFromTop() {
        System.out.println("result:" + new DynamicProgramming().fibFromTop(5));
    }

    @Test
    public void fibFromBtm() {
        System.out.println("result:" + new DynamicProgramming().fibFromBtm(5));
    }


}
