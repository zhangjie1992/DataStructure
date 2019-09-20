package lanchong.iloveu.algorithm;


import org.junit.Test;

public class ArrayUnitTest {


    @Test
    public void magic_square() {
        int[][] matrix = new Array().magic_square(6);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int ar = matrix[i][j];
                System.out.print((ar < 10 ? " " : "") + ar + " ");
            }
            System.out.println("====");
        }
    }


    @Test
    public void Sudoku() {
        char[][] sudoku = {
                {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '3', '.', '.', '2', '.', '4', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '3', '4', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '5', '2', '.', '.'}};
        System.out.print("result:" + new Array().isValidSudoku(sudoku));
    }

    @Test
    public void threeSum() {
//        int[] arr = {-1, 0, 1, 2, -1, -4};
//        int[] arr = {0,0,0,0};
//        int[] arr = {0,0,0};
        int[] arr = {-2,0,0,2,2};
//        int[] arr = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//        int[] arr = {3,0,-2,-1,1,2};
//        int[] arr = {-2,-1,0,1,2,3};
//        int[] arr = {-2,-1,0,2};
        System.out.print("result:" + new Array().threeSum(arr));
    }

    @Test
    public void majorityElement() {
//        int[] arr = {2,0,0,2,2};
        int[] arr = {3,2,3};
//        int[] arr = {2,2,1,1,1,2,2};
        System.out.print("result:" + new Array().majorityElement(arr));
    }











}
