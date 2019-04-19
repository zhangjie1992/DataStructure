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








}
