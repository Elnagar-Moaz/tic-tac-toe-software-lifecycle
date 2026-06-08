import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testIsCellEmpty_Positive() {
        Board board = new Board();
        // Ein frisch erstelltes Feld muss leer sein
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellEmpty_Negative() {
        Board board = new Board();
        board.place(0, 0, 'X');
        // Feld ist jetzt besetzt, darf also nicht mehr als leer gelten
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlace_Positive() {
        Board board = new Board();
        // Symbol erfolgreich auf ein leeres Feld setzen
        assertTrue(board.place(1, 1, 'X'));
        assertEquals('X', board.getCell(1, 1));
    }

    @Test
    public void testPlace_Negative() {
        Board board = new Board();
        board.place(2, 2, 'X');
        // Erneutes Platzieren auf derselben Zelle muss fehlschlagen
        assertFalse(board.place(2, 2, 'O'));
        assertEquals('X', board.getCell(2, 2)); // Es muss immer noch 'X' drin stehen
    }
}