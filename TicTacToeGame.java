import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    static String[][] gameBoard = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    static String playerMarker;
    static String computerMarker;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        displayGameBoard();

        // Player chooses X or O
        while (true) {
            System.out.println("Choose X or O:");
            String choice = input.nextLine().toUpperCase();
            if (choice.equals("X") || choice.equals("O")) {
                playerMarker = choice;
                computerMarker = (playerMarker.equals("X")) ? "O" : "X";
                break;
            } else {
                System.out.println("Invalid choice! Please choose X or O.");
            }
        }

        while (true) {
            askPlayerPosition(input);

            if (checksIfWon(playerMarker)) {
                System.out.println("Congrats!The player won!");
                break;
            }

            if (isBoardFull()) {
                System.out.println("The result of the game is a draw!!");
                break;
            }

            askComputerPosition(random);

            if (checksIfWon(computerMarker)) {
                System.out.println("Congrats! The computer won! ");
                break;
            }

            if (isBoardFull()) {
                System.out.println("The result of the game is a draw!!");
                break;
            }
        }
    }

    // 1-Use 2D Array.
    // 2-Use method.
    // 3-Should Display a Game Board.
    private static void displayGameBoard() {
        String horizontalLine = "-----------";

        System.out.println(" " + gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2]);
        System.out.println(horizontalLine);
        System.out.println(" " + gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2]);
        System.out.println(horizontalLine);
        System.out.println(" " + gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2]);
    }

    // 4-Ask player position.
    // 5-Check if the position available, if not available keep asking the player to enter a valid position.
    static void askPlayerPosition(Scanner input) {
        int position;
        while (true) {
            try {
                System.out.println("Enter Your position in the board (1-9): ");
                position = Integer.parseInt(input.nextLine());

                if (position >= 1 && position <= 9) {
                    int row = (position - 1) / 3;
                    int col = (position - 1) % 3;

                    if (gameBoard[row][col].equals(String.valueOf(position))) {
                        gameBoard[row][col] = playerMarker;
                        break;
                    } else {
                        System.out.println("Position not available! Please enter again.");
                    }
                } else {
                    System.out.println("Invalid position! Please enter a number between 1 and 9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
        displayGameBoard();
    }

    // 6-Computer chose random position and check valid position.
    static void askComputerPosition(Random random) {
        int position;
        while (true) {
            position = random.nextInt(9) + 1;
            int row = (position - 1) / 3;
            int col = (position - 1) % 3;
            if (gameBoard[row][col].equals(String.valueOf(position))) {
                gameBoard[row][col] = computerMarker;
                break;
            }
        }
        System.out.println("After playing computer's move: ");
        displayGameBoard();
    }

    //7- Checks if either player or Computer has won.
    static boolean checksIfWon(String player) {
        for (int i = 0; i < 3; i++) {
            if ((gameBoard[i][0].equals(player) && gameBoard[i][1].equals(player) && gameBoard[i][2].equals(player)) ||
                    (gameBoard[0][i].equals(player) && gameBoard[1][i].equals(player) && gameBoard[2][i].equals(player))) {
                return true;
            }
        }
        return (gameBoard[0][0].equals(player) && gameBoard[1][1].equals(player) && gameBoard[2][2].equals(player)) ||
                (gameBoard[0][2].equals(player) && gameBoard[1][1].equals(player) && gameBoard[2][0].equals(player));
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!gameBoard[i][j].equals("X") && !gameBoard[i][j].equals("O")) {
                    return false;
                }
            }
        }
        return true;
    }
}
