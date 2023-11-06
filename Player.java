import java.util.Scanner;

public class Player {
  private String name;
  private int points;
//This is the constructor for the Player class. It takes no parameters and sets the name of the player to the user's input which is found using scanner. The program will then welcome the user with the stored name they had entered.
  public Player() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter player name:");
    String newName = sc.nextLine();
    name = newName;
    points = 0;
    System.out.println("Hello and welcome to our game, " + name);
  }
  public Player(String inputName){
    int points= 0;
    String name=inputName;
    System.out.println("Hello and welcome to our game, "+ name);
  }
  
  public String getName() {
    return name;
  }

  public int getPoints() {
    return points;
  }

  public void updatePoints(int value) {
    this.points += value;
  }
}