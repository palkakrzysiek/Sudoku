package pl.lodz.p.sudoku;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }


    /*
     * @return true if there is no conflicts
     */
    Boolean checkField(int[][] currentBoard, int x, int y) {
        int currentElement = currentBoard[x][y];
        if (currentElement == 0) {
            return true;
        }
        // check row
        for (int i = 0; i < 9; i++) {
            if (i != x && currentBoard[i][y] == currentElement) {
                 return false;
            }
        }
        // check column
        for (int i = 0; i < 9; i++) {
            if (i != y && currentBoard[x][i] == currentElement) {
                 return false;
            }
        }
        // check 3×3 square
        int currentSqareX = x / 3;
        int currentSqareY = y / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((currentSqareX * 3 + i != x) &&
                    (currentSqareY * 3 + j != y) &&
                    (currentBoard[currentSqareX * 3 + i][currentSqareY * 3 +
                     j]) == currentElement) {
                     return false;
                     }
            }
        }

        return true;
    }

    public void testFullGeneratedSudoku() {
        System.out.println("Verify correctness of the board...");
        SudokuBoard instance = new SudokuBoard();
        instance.createBoard();
        instance.printBoard();
        int[][] currentBoard = instance.getCurrentBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertTrue(checkField(currentBoard, i, j));
            }
        }
        System.out.println("OK.");
    }
}
