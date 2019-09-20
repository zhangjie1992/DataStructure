package lanchong.iloveu.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RecursionUnitTest {


    @Test
    public void findAllNumbersDisappears() {
        int[] arr = {5, 3, 4, 6, 7, 8, 9, 9, 2};
        System.out.print(new Recursion().findAllNumbersDisappears(arr));
    }



    @Test
    public void intSeq() {
        new Recursion().intSeq(3,5);
    }

    @Test
    public void generateParenthesis() {
        System.out.println("result:" + new Recursion().generateParenthesis(3));
    }

    @Test
    public void hanoiTower() {
        new Recursion().hanoiTower(3);
    }
    @Test
    public void binaryGrayCode(){
        new Recursion().binaryGrayCode(3,true);
    }



    @Test
    public void letterCasePermutation(){
        System.out.println("result:" + new Recursion().letterCasePermutation("ABCDE2"));
    }





}
