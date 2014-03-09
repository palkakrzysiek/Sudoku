package pl.lodz.p.sudoku;

/**
 * Sudoku Game
 *
 */
public class App
{
    public static void main( String[] args )
    {
        SudokuBoard board = new SudokuBoard();
        board.createBoard();
        board.printBoard();
    }

}
