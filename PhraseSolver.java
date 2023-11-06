import java.util.Scanner;

//The Phrase Solver class uses both the Player and Board files to piece together a working concept with context for this game. This class sorts all of the different elements from board to make them more easily comprehendable when printed for the user, alongside switching between each player and checking if the conditions are met for the game to end.

public class PhraseSolver {
  private boolean solved;
  private Player currentPlayer;
  private Board board;
  private Player p1;
  private Player p2;

  public PhraseSolver() {
    p1 = new Player();
    p2 = new Player();
    board = new Board();
    solved = false;
    currentPlayer = p1;
  }

  public void play() {
    Scanner input = new Scanner(System.in);
    while (!solved) {
      System.out.println("Player: " + currentPlayer.getName());
      System.out.println("Current Points: " + currentPlayer.getPoints());
      System.out.println("Current Phrase: " + board.getSolvedPhrase());
      board.setLetterValue();
      // System.out.println("Phrase: " + solvedPhrase.substring(0,solvedPhrase.length()/2));
      System.out.println("Current Letter Value: " + board.getCurrentLetterValue());
      System.out.println("Enter '1' to guess a letter, '2' to solve: ");
      int choice = input.nextInt();
      input.nextLine(); // Consume newline character

      if (choice == 1) {
        System.out.println("Enter a letter to guess: ");
        char guess = input.nextLine().toLowerCase().charAt(0);
        boolean letterFound = board.guessLetter(guess);
        if (letterFound) {
          
          currentPlayer.updatePoints(board.getCurrentLetterValue());
        } else {
          System.out.println("Letter not found in the phrase. Turn skipped.");
        }
      } else if (choice == 2) {
        System.out.println("Enter the full phrase to solve: ");
        String solveAttempt = input.nextLine().toLowerCase();
        if (solveAttempt.equals(board.getPhrase().toLowerCase())) {
          solved = true;
          
          currentPlayer.updatePoints(board.getCurrentLetterValue());
          break;
        } else {
          System.out.println("Incorrect solution. Turn skipped.");
        }
      } else {
        System.out.println("Invalid choice. Please enter '1' to guess a letter or '2' to solve.");
      }

      if (currentPlayer == p1) {
        currentPlayer = p2;
      } else {
        currentPlayer = p1;
      }
    }

    System.out.println("Game Over! Player " + currentPlayer.getName() + " wins with " + currentPlayer.getPoints() + " points!");
  }
}