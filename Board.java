import java.util.Scanner;
import java.io.File;

//The board class gives the program various elements that will be used to represent the game board. Some of these elements are the ability to view a randomly displayed phrase, to guess a letter or word that may be contained in the phrase, and it sets up the programs structure for checking these guesses against the phrase, giving points accordingly based on the answer. 

public class Board {
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  public Board() {
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue();
    // displayInitialSolvedPhrase();
  }

  public String getPhrase() {
    return phrase;
  }

  public String getSolvedPhrase() {
    return solvedPhrase;
  }

  public int getCurrentLetterValue() {
    return currentLetterValue;
  }

  public void setLetterValue() {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public void displayInitialSolvedPhrase() {
    for (int i = 0; i < phrase.length(); i++) {
      if (phrase.charAt(i) == ' ') {
        solvedPhrase += "  ";
      } else {
        solvedPhrase += "_ ";
      }
    }
    // System.out.println("Phrase: " + solvedPhrase.substring(0,solvedPhrase.length()/2));
  }

  public boolean guessLetter(char guess) {
    boolean foundLetter = false;
    String newSolvedPhrase = "";
    for (int i = 0; i < phrase.length(); i++) {
      if (phrase.charAt(i) == guess) {
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      } else {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    solvedPhrase = newSolvedPhrase;
    return foundLetter;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  
/*
  preconditions: user guess must be stored in a variable and passed into guessLetter
  postconditions: if the user guess is in the phrase, the phrase is updated with the guessed letter. foundLetter is changed to true. If the user guess is not in the phrase, the phrase is not updated. foundLetter is kept at false.

  
  */

}