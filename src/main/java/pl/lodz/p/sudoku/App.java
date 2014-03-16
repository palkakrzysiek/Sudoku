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
        SudokuSolver solver = new RecursiveBacktraceSolver();
        solver.slove(board);
        board.printBoard();
    }

}
