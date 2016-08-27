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
    // System.out.println(game.playerCount());
    System.out.println(player1.getName() + " your hand is:");
    System.out.println(player1.getHand().toString()); 
    
    // WHY IS THIS FOR LOOP NOT WORKING????
    // String answer;
    // for (Player player : players){
    //   System.out.println(player.getName());
    // }

    // boolean good = false; 
    // do    
    //   {
    //     System.out.println(player.getName() + " would you like to twist or stick (t/s) : ");
    //     String answer = input.next();
    //     if(answer.equals("t")){
    //       good = true;
    //       game.playerTwist(player);
    //       System.out.println(game.checkIfPlayerOut(player));
    //     }
    //     else{
    //       good = false;
    //     System.out.println(game.checkIfPlayerOut(player));
          // }
    //   }
    //   while (good && player.getHand().getHandsValue() < 21);
    // }


// BELOW IS ALL GOOD BUT AS NOT LOOPING THROUGH ALL PLAYERS ITS LIMITED TO TWO PLAYERS
    String answer;
    boolean good = false;
    do
    {
      System.out.println(player1.getName() + " would you like to twist or stick (t/s) : ");
      answer = input.next();
      if(answer.equals("t")){
        good = true;
        game.playerTwist(player1);
        System.out.println(game.checkIfPlayerOut(player1));
      }
      else if((answer != "t") && (player1.getHand().getHandsValue() < 15)){
        good = true;
        System.out.println("Sorry, you need at least 15 to be able to win so you're twisting");
        game.playerTwist(player1);
        System.out.println(game.checkIfPlayerOut(player1));
      }
      else{
        good = false;
        System.out.println(game.checkIfPlayerOut(player1));
      }
    }
      while ((good) && (player1.getHand().getHandsValue() < 21));

   
    
    System.out.println(player2.getName() + " your hand is:");
    System.out.println(player2.getHand().toString());

    String answer2;
    boolean good2 = false;
    do
    {
      System.out.println(player2.getName() + " would you like to twist or stick (t/s) : ");
      answer2 = input.next();
      if(answer2.equals("t")){
        good2 = true;
        game.playerTwist(player2);
        System.out.println(game.checkIfPlayerOut(player2));
      }
      else if((answer != "t") && (player2.getHand().getHandsValue() < 15)){
        good = true;
        System.out.println("Sorry, you need at least 15 to be able to win so you're twisting");
        game.playerTwist(player2);
        System.out.println(game.checkIfPlayerOut(player2));
      }
      else{
        good2 = false;
        System.out.println(game.checkIfPlayerOut(player2));
      }
    }
    while ((good2) && (player2.getHand().getHandsValue() < 21));

    // NOW SORTING OUT A WINNER

    if (game.getWinner() != null){
    System.out.println("The winner is: ");
    System.out.println(game.revealWinner());
    }

    else if ((game.getWinner() == null) && (players.size() >= 2) && (game.getAdvancedWinner() != null)){
    System.out.println("The winner is: ");
    System.out.println(game.getAdvancedWinner().getName());
    }

    else if ((game.getAdvancedWinner() == null) & (game.getWinnerByHandsLength() != null)){
      System.out.println(game.getWinnerByHandsLength().getName());
    }

    else if (game.getWinnerByHandsLength() == null){
      System.out.println("It's a draw!");
    }
  }
}
