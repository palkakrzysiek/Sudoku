package pl.lodz.p.sudoku;


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


    private int[][] currentBoard = new int[9][9];

    public int[][] getCurrentBoard() {
        return currentBoard;
    }

    public void setCurrentBoard(int[][] currentBoard) {
        this.currentBoard = currentBoard;
    }

    public void setXY(int x, int y, int val) {
        if (x > 9 || x < 1) {
            throw new IndexOutOfBoundsException("Index of x -- " + x + " is out of bounds!");
        }
        if (y > 9 || y < 1) {
            throw new IndexOutOfBoundsException("Index of y -- " + y + " is out of bounds!");
        }
        if (val > 9 || val < 1) {
            throw new IndexOutOfBoundsException("Value of cell -- " + val + " is out of bounds!");
        }
        if (!checkCell(currentBoard, x, y)) {
            throw new RuntimeException("Conflict with existing number in current row, column or group of cells ");
        }
        currentBoard[x][y] = val;
    }

    public int getXY(int x, int y) {
        if (x > 9 || x < 1) {
            throw new IndexOutOfBoundsException("Index of x -- " + x + " is out of bounds!");
        }
        if (y > 9 || y < 1) {
            throw new IndexOutOfBoundsException("Index of y -- " + y + " is out of bounds!");
        }
        return currentBoard[x][y];
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
