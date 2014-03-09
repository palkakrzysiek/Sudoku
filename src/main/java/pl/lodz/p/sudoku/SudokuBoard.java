/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.sudoku;

import java.util.Arrays;

/**
 *
 * @author Krzysiek Palka
 */
public class SudokuBoard {


    private Boolean checkCell(int[][] currentBoard, int x, int y) {
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

    private Boolean done = false;

    private Boolean createBoard(int[][] previousBoard, int currentCell) {
        /*
         *for (int i = 0; i < 9; i++) {
         *   for (int j = 0; j < 9; j++) {
         *       System.out.print(previousBoard[i][j]);
         *       System.out.print(' ');
         *   }
         *   System.out.print('\n');
         *}
         *System.out.print('\n');
         *System.out.print('\n');
         */

        if (done) {
            return true;
        }

        if (currentCell == 81) {
            for (int i = 0; i < 9; i++) {
                System.arraycopy(previousBoard[i], 0, currentBoard[i], 0, 9);
            }
            done = true;
            return true;
        }

        int y = currentCell / 9;
        int x = currentCell % 9;

        Boolean[] used = new Boolean[9];
        Arrays.fill(used, false);
        int usedCount = 0;
        while (true) {
            if (usedCount == 8) {
                return false;
            }
            int rand;
            while (true) {
                rand = (int) (Math.random() * 9);
                if (used[rand] == true) {
                    continue;
                }
                used[rand] = true;
                usedCount++;
                break;
            }
            previousBoard[x][y] = rand + 1;
            if (!checkCell(previousBoard, x, y)) {
                previousBoard[x][y] = 0;
                continue;
            }
            else {
                if (createBoard(previousBoard.clone(), currentCell + 1)) {
                    return true;
                }
            }
        }

    }

    /*
     *final private int[][] goodField = new int[][] {
     *{1, 2, 3, 4, 5, 6, 7, 8, 9},
     *{4, 5, 6, 7, 8, 9, 1, 2, 3},
     *{7, 8, 9, 1, 2, 3, 4, 5, 6},
     *{2, 3, 4, 5, 6, 7, 8, 9, 1},
     *{5, 6, 7, 8, 9, 1, 2, 3, 4},
     *{8, 9, 1, 2, 3, 4, 5, 6, 7},
     *{3, 4, 5, 6, 7, 8, 9, 1, 2},
     *{6, 7, 8, 9, 1, 2, 3, 4, 5},
     *{9, 1, 2, 3, 4, 5, 6, 7, 8}};
     */


    public int[][] getCurrentBoard() {
        return currentBoard;
    }

    private int[][] currentBoard = new int[9][9];

    public void createBoard() {
        createBoard(currentBoard, 0);
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
           for (int j = 0; j < 9; j++) {
               System.out.print(currentBoard[i][j]);
               System.out.print(' ');
           }
           System.out.print('\n');
        }
    }
}
