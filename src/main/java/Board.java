public class Board {
    private final char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        }
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
            cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void print() {
        System.out.println("    1   2   3");
        System.out.println("  ┌───┬───┬───┐");

        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " │");

            for (int j = 0; j < 3; j++) {
                char cell = cells[i][j];

                if (cell == '\0') {
                    cell = ' ';
                }

                System.out.print(" " + cell + " │");
            }

            System.out.println();

            if (i < 2) {
                System.out.println("  ├───┼───┼───┤");
            }
        }

        System.out.println("  └───┴───┴───┘");
        System.out.println();
    }

    // Hilfsmethode für die Gewinnprüfung
    public boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((cells[i][0] == player && cells[i][1] == player && cells[i][2] == player) ||
                    (cells[0][i] == player && cells[1][i] == player && cells[2][i] == player)) {
                return true;
            }
        }
        if ((cells[0][0] == player && cells[1][1] == player && cells[2][2] == player) ||
                (cells[0][2] == player && cells[1][1] == player && cells[2][0] == player)) {
            return true;
        }
        return false;
    }
}