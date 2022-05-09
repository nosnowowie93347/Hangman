import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.net.ssl.TrustManager;
import org.w3c.dom.CharacterData;
import java.util.ArrayList;
import java.util.Collections;

class Main {
  
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    try {FileReader file = new FileReader("Automation.txt");
    BufferedReader in = new BufferedReader(file);
    String str;
    
    
      while((str = in.readLine()) != null){
      list.add(str);
    }
    }
    catch (IOException ex){
      System.out.println(ex);
      System.out.println("Error");
  }
  Random random = new Random();
  Collections.shuffle(list);
    String word = list.get(0);
    int lives = 8;
    ArrayList<Character> display = new ArrayList<Character>();
    for (int i = 0; i < word.length(); i++){
      display.add('_');
    }
    String head = "  :___: \n  |   |\n  O   |\n      |\n      |\n      |\n     _|_ _";
    String none = "  :___: \n  |   |\n      |\n      |\n      |\n      |\n     _|_ _";
    String neck = "  :___: \n  |   |\n  O   |\n  |   |\n      |\n      |\n     _|_ _";
    String arm1 = "  :___: \n  |   |\n  O   |\n  |   |\n /    |\n      |\n     _|_ _";
    String arm2 = "  :___: \n  |   |\n  O   |\n  |   |\n / \\  |\n      |\n     _|_ _";
    String body = "  :___: \n  |   |\n  O   |\n  |   |\n /|\\  |\n      |\n     _|_ _";
    String body2 = "  :___: \n  |   |\n  O   |\n  |   |\n /|\\  |\n  |   |\n     _|_ _";
    String leg1 = "  :___: \n  |   |\n  O   |\n  |   |\n /|\\  |\n  |   |\n /   _|_ _";
    String leg2 = "  :___: \n  |   |\n  O   |\n  |   |\n /|\\  |\n  |   |\n / \\_|_ _";
    String image = none;
    Boolean checkOutput = true;
    while (checkOutput){
      System.out.println(image);
      Scanner input = new Scanner(System.in);
      System.out.println(display);
      System.out.println("Guess a letter");
      char letter = Character.toLowerCase(input.nextLine().charAt(0));
      
      System.out.println(letter);
      if (word.indexOf(letter) == -1){
        // when a letter is wrong
        lives -= 1;
        System.out.println("That letter is not in the word. -1 life. You have " + lives + " remaining");
        switch(lives){
          case 8:
            image = none;
          break;
          case 7:
            image = head;
          break;
          case 6:
            image = neck;
          break;
          case 5:
            image = arm1;
          break;
          case 4:
            image = arm2;
          break;
          case 3:
            image = body;
          break;
          case 2:
            image = body2;
          break;
          case 1:
            image = leg1;
          break;
          case 0:
            image = leg2;
          break;}
    if (lives == 0){
    checkOutput = false;
  }

      }else{
        // when a letter is right
       for (int i = 0; i < word.length(); i++){
         if (letter==(word.charAt(i))){
           display.set(i, letter);}
       }
       if (!display.contains('_')){
         checkOutput = false;
       }

      }
    }
    if (display.contains('_') && lives == 0){
      System.out.println("You lost. Better Luck Next Time!");
    }
      else{
        System.out.println("You Won! Congrats!");
      }
  }



  }
