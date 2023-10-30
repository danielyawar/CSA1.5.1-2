/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */

  /* your code here - constructor(s) */ 
  public Player(){
    int points= 0;
    System.out.println("enter player name:");
    Scanner sc= new Scanner(System.in);
    String newName= sc.nextLine();
    String name=newName;
    System.out.println("Hello and welcome to our game, "+ name);
  }
  public Player(String inputName){
    int points= 0;
    String name=inputName;
    System.out.println("Hello and welcome to our game, "+ name);
  }
  /* your code here - accessor(s) */ 
  
  /* your code here - mutator(s) */ 
}