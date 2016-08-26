package card_game;
import java.util.*;
// TO RUN THIS GO INTO THE BIN AND TYPE THIS - java card_game.Runner
public class Runner {
  public static void main(String[] args) {
    
    ArrayList<Player> players = new ArrayList<Player>();
    Deck deck = new Deck();
    
    
    Game game = new Game();

    Scanner input = new Scanner(System.in);

    System.out.println("Please enter first player's name : ");
    String name1 = input.next(); 
    Player player1 = new Player(name1);
    System.out.println("Please enter second player's name : ");
    String name2 = input.next();
    Player player2 = new Player(name2);
   
    game.addAPlayer(player1);
    game.addAPlayer(player2);
    game.dealToPlayers();
    System.out.println(player1.getName() + " your hand is:");
    System.out.println(player1.getHand().toString()); 
    

    System.out.println(player1.getName() + " would you like to twist or stick (t/s) : ");
    String answer = input.next(); 
    if (answer.equals("t")){
      game.playerTwist(player1);
    System.out.println(game.checkIfPlayerOut(player1));
    }
   
    
    System.out.println(player2.getName() + " your hand is:");
    System.out.println(player2.getHand().toString());

    System.out.println(player2.getName() + " would you like to twist or stick (t/s) : ");
    String answer2 = input.next(); 
    if (answer2.equals("t")){
      game.playerTwist(player2);
    System.out.println(game.checkIfPlayerOut(player2));
    }
   



    System.out.println("The winner is:");
    System.out.println(game.revealWinner());
  }
}