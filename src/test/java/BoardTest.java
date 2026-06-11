import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testIsCellEmpty_Positive() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellEmpty_Negative() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellEmpty_OutOfBounds() {
        Board board = new Board();
        assertFalse(board.isCellEmpty(5, -1));
    }

    @Test
    public void testIsFull_Positive() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsFull_Negative() {
        Board board = new Board();
        assertFalse(board.isFull());
    }

    @Test
    public void testClear() {
        Board board = new Board();
        board.place(1, 1, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    public void testCheckWin_Row() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    public void testCheckWin_Blocked() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        assertFalse(board.checkWin('X'));
    }
}