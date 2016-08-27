package card_game;
import java.util.*;
// TO RUN THIS GO INTO THE BIN AND TYPE THIS - java card_game.Runner
public class Runner {
  public static void main(String[] args) {

    ArrayList<Player> players = new ArrayList<Player>();
    Deck deck = new Deck();
    Game game = new Game(deck);
    Scanner input = new Scanner(System.in);

    System.out.println("Please enter first player's name : ");
    String name1 = input.next(); 
    Player player1 = new Player(name1);
    System.out.println("\nPlease enter second player's name : ");
    String name2 = input.next();
    Player player2 = new Player(name2);

    game.addAPlayer(player1);
    game.addAPlayer(player2);
    game.dealToPlayers();

// NEED TO WORK OUT WHY LOOPING THROUGH THIS ISN'T WORKING
    // for (Player player : players){
    //     System.out.println("\n" + player.getName() + " your hand is:");
    //     System.out.println(player.getHand().toString()); 
    //     Boolean burn = false;
    //     String burnChoice;
    //     if (player.getHand().burnableHand() == true){
    //       do {
    //         System.out.println("\n" + player.getName() + " do you want to burn this hand? (y/n)");
    //         burnChoice = input.next();
    //         if (burnChoice.equals("y")){
    //           burn = true;
    //           player.getHand().burnHand();
    //           game.playerTwist(player);
    //           System.out.println("\n" + player.getName() + " your new hand is:");
    //           System.out.println(game.playerTwist(player));
    //         }
    //         else if (burnChoice != "y"){
    //           burn = false;
    //         }
    //       }
    //       while ((player.getHand().burnableHand() == true) && (burn));
    //     }

    //     String answer;
    //     boolean good = false;
    //     do
    //     {
    //       System.out.println(player.getName() + " would you like to twist or stick (t/s) : ");
    //       answer = input.next();
    //       if(answer.equals("t")){
    //         good = true;
    //         game.playerTwist(player1);
    //         System.out.println(game.checkIfPlayerOut(player1));
    //       }
    //       else if((answer != "t") && (player.getHand().getHandsHighValue() < 15)){
    //         good = true;
    //         System.out.println("Sorry, you need at least 15 to be able to win so you're twisting");
    //         game.playerTwist(player);
    //         System.out.println(game.checkIfPlayerOut(player));
    //       }
    //       else{
    //         good = false;
    //         System.out.println(game.checkIfPlayerOut(player));
    //       }
    //     }
    //     while ((good) && (player.getHand().getHandsValue() < 21));
    //   }




// BELOW IS ALL GOOD BUT AS NOT LOOPING THROUGH ALL PLAYERS ITS LIMITED TO TWO PLAYERS

    System.out.println("\n" + player1.getName() + " your hand is:");
    System.out.println(player1.getHand().toString()); 
    Boolean burn = false;
    String burnChoice;
    if (player1.getHand().burnableHand() == true){
      do {
        System.out.println("\n" + player1.getName() + " do you want to burn this hand? (y/n)");
        burnChoice = input.next();
        if (burnChoice.equals("y")){
          burn = true;
          player1.getHand().burnHand();
          game.playerTwist(player1);
          System.out.println("\n" + player1.getName() + " your new hand is:");
          System.out.println(game.playerTwist(player1));
        }
        else if (burnChoice != "y"){
          burn = false;
        }
      }
      while ((player1.getHand().burnableHand() == true) && (burn));
    }


// // THIS SECTION GETS PLAYER ONES CHOICES AND FINAL HAND
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
      // NB ADDED IN High to gethands value below
      else if((answer != "t") && (player1.getHand().getHandsHighValue() < 15)){
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


// THIS SECTION GIVES PLAYER 2 THEIR CARDS AND LETS THEM BURN IF 13.
    System.out.println("\n" + player2.getName() + " your hand is:");
    System.out.println(player2.getHand().toString()); 
    Boolean burn2 = false;
    String burnChoice2;
    if (player2.getHand().burnableHand() == true){
      do {
        System.out.println("\n" + player2.getName() + " do you want to burn this hand? (y/n)");
        burnChoice2 = input.next();
        if (burnChoice2.equals("y")){
          burn2 = true;
          player2.getHand().burnHand();
          game.playerTwist(player2);
          System.out.println("\n" + player2.getName() + " your new hand is:");
          System.out.println(game.playerTwist(player2));
        }
        else if (burnChoice2 != "y"){
          burn = false;
        }
      }
      while ((player2.getHand().burnableHand() == true) && (burn));
    }


// // THIS SECTION ALLOWS PLAYER TWO TO TWIST OR STICK AND GET A FINAL HAND
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
      // NB ADDED IN High to gethands value below
      else if((answer != "t") && (player2.getHand().getHandsHighValue() < 15)){
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

 // HERE WE WORK OUT THE WINNER

    if (game.playerCount() == 0){
      System.out.println("You've both blown it!");
    }

    else if (game.getWinner() != null){
      System.out.println("The winner is: ");
      System.out.println(game.revealWinner());
    }

    else if (game.getAdvancedWinner() != null){
      System.out.println("The winner is: ");
      System.out.println(game.getAdvancedWinner().getName());
    }

    else if (game.getWinnerByHandsLength() != null){
      System.out.println(game.getWinnerByHandsLength().getName());
    }

    else if (game.getWinnerByHandsLength() == null){
      System.out.println("It's a draw!");
    }
    
    // }





  }
}
