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

    @Test
    public void testPlace_ValidMove() {
        Board board = new Board();

        board.place(1, 1, 'X');

        assertFalse(board.isCellEmpty(1, 1));
    }

    @Test
    public void testPlace_OutOfBoundsDoesNothing() {
        Board board = new Board();

        board.place(5, 5, 'X');
        board.place(-1, 0, 'O');

        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(1, 1));
        assertTrue(board.isCellEmpty(2, 2));
    }

    @Test
    public void testClear_FullBoardBecomesEmpty() {
        Board board = new Board();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }

        board.clear();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }

    @Test
    public void testCheckWin_Column() {
        Board board = new Board();

        board.place(0, 1, 'O');
        board.place(1, 1, 'O');
        board.place(2, 1, 'O');

        assertTrue(board.checkWin('O'));
    }

    @Test
    public void testCheckWin_DiagonalLeftToRight() {
        Board board = new Board();

        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');

        assertTrue(board.checkWin('X'));
    }

    @Test
    public void testCheckWin_DiagonalRightToLeft() {
        Board board = new Board();

        board.place(0, 2, 'O');
        board.place(1, 1, 'O');
        board.place(2, 0, 'O');

        assertTrue(board.checkWin('O'));
    }



    @Test
    public void testPrint_EmptyBoardContainsCoordinates() {
        Board board = new Board();

        java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(output));

        board.print();

        String printed = output.toString();

        assertTrue(printed.contains("1"));
        assertTrue(printed.contains("2"));
        assertTrue(printed.contains("3"));
    }

    @Test
    public void testPrint_BoardWithMarkerContainsMarker() {
        Board board = new Board();
        board.place(0, 0, 'X');

        java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(output));

        board.print();

        String printed = output.toString();

        assertTrue(printed.contains("X"));
    }
}