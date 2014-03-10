package pl.lodz.p.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursiveBacktraceSolverTest {

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



    @Test
    public void test() {
        //fail("Not yet implemented");
        System.out.println("Verify correctness of Recursive Backtracing Solver...");
        SudokuBoard board = new SudokuBoard();
        SudokuSolver solver = new RecursiveBacktraceSolver();
        solver.slove(board);
        board.printBoard();
        int[][] currentBoard = board.getCurrentBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertTrue(checkField(currentBoard, i, j));
            }
        }
        System.out.println("OK.");
    }

}
