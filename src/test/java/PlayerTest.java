import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void testGetMarker_X() {
        Player player = new Player('X');

        assertEquals('X', player.getMarker());
    }

    @Test
    public void testGetMarker_O() {
        Player player = new Player('O');

        assertEquals('O', player.getMarker());
    }
}