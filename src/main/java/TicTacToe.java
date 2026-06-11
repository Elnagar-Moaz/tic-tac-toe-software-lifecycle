import java.util.Scanner;

public class TicTacToe {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;

    public TicTacToe() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
        this.board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            board.clear();
            currentPlayer = player1;
            playMatch(scanner);

            System.out.print("Do you want to play again? (y/n): ");
            char choice = scanner.next().toLowerCase().charAt(0);
            if (choice != 'y') {
                running = false;
            }
        }
        System.out.println("Thanks for playing!");
    }

    private void playMatch(Scanner scanner) {
        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("Current Player: " + currentPlayer.getMarker());
            board.print();

            int[] move = getValidMove(scanner);
            board.place(move[0], move[1], currentPlayer.getMarker());

            if (board.checkWin(currentPlayer.getMarker())) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                gameOver = true;
            } else if (board.isFull()) {
                board.print();
                System.out.println("The game is a draw!");
                gameOver = true;
            } else {
                switchCurrentPlayer();
            }
        }
    }

    private int[] getValidMove(Scanner scanner) {
        int row = -1;
        int col = -1;
        boolean validMove = false;

        while (!validMove) {
            System.out.print("Row [1-3]: ");
            if (scanner.hasNextInt()) {
                row = scanner.nextInt()-1;
            }
            System.out.print("Column [1-3]: ");
            if (scanner.hasNextInt()) {
                col = scanner.nextInt()-1;
            }

            if (board.isCellEmpty(row, col)) {
                validMove = true;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
        return new int[]{row, col};
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}