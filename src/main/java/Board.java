public class Board {
    private char[][] cells;


    public Board() {
        cells = new char[3][3];
        clear();
    }


    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }


    public boolean isCellEmpty(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }
        return cells[row][col] == ' ';
    }


    public boolean place(int row, int col, char player) {
        if (isCellEmpty(row, col)) {
            cells[row][col] = player;
            return true;
        }
        return false;
    }


    public char getCell(int row, int col) {
        return cells[row][col];
    }
}