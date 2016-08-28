package card_game;
import java.util.*;

public class Game{

  private ArrayList<Player> players;
  private Deck deck;
  private int currentPlayerIndex;

  public Game(Deck deck){
    this.players = new ArrayList<Player>();
    this.deck = new Deck();
    currentPlayerIndex = 0;
  }

  public int playerCount(){
    return players.size();
  }

  public void addAPlayer(Player player){
    players.add(player);
  }

  public Deck getDeck(){
    return this.deck;
  }

  public void dealToPlayers(){
    deck.fullDeck();
    deck.shuffle();
    for(int i = 0; i < 2; i++){
      for (Player player : players){
        player.getHand().receiveACard(deck.dealACard());
      }
    }
  }

  public String playerTwist(Player player){
    player.getHand().receiveACard(deck.dealACard());
    return player.getHand().toString();
  }

  public Player giveCurrentPlayer(){
    return players.get(currentPlayerIndex);
  }

  public int changeCurrentPlayer(){
    currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    return currentPlayerIndex;
  }

// TO DO
// the below is for if there are more than 2 players but haven't factored in equal scores
  // need to think about equal scores. Maybe better to check if someone hasn't won and remove them from players and if only one left they're the winner and if more than one left you go to compare advanced scores.
  // public Player getWinner(){
  //   Player winner = players.get(0);
  //   for (Player currentPlayer : players){
  //     int score = currentPlayer.getHand().findBestScore();
  //     if ((score > winner.getHand().findBestScore()) {
  //       winner = currentPlayer;
  //     }
  //   }
  //   return winner;
  // }



  public Player getWinner(){
    Player winner = null;
    int playerNumber = players.size();
    if (playerNumber < 1){
      return winner;
    }
    else if (playerNumber == 1){
      winner = players.get(0);
    }
    else if (playerNumber == 2){
      int player1Score = players.get(0).getHand().findBestScore();
      int player2Score = players.get(1).getHand().findBestScore();
      if (player1Score < player2Score){
        winner = players.get(1);
      }
      else if (player1Score > player2Score){
        winner = players.get(0);
      }   
    }
    return winner;
  }


  public Player getAdvancedWinner(){
    Player newWinner = null;
    int player1NewScore = players.get(0).getHand().handValueAdjustForRank();
    int player2NewScore = players.get(1).getHand().handValueAdjustForRank();
    if (player1NewScore < player2NewScore){
      newWinner = players.get(1);
    }
    if (player1NewScore > player2NewScore){
      newWinner = players.get(0);
    }
    if (player1NewScore == player2NewScore){
      newWinner = null;
    } 
    return newWinner;  
  }



// BELOW IS USED IF THERE'S NO ADVANCED WINNER AS THAT MEANS THEY'VE GOT SAME SCORE SO LOOK AT NUMBER OF CARDS
  public Player getWinnerByHandsLength(){
    Player gameWinner = null;
    int player1Cards = players.get(0).getHand().getCount();
    int player2Cards = players.get(1).getHand().getCount();
    if (player1Cards < player2Cards){
      gameWinner = players.get(1);
    }
    if (player1Cards > player2Cards){
      gameWinner = players.get(0);
    }
    if (player1Cards == player2Cards){
      gameWinner = null;
    } 
    return gameWinner; 
  }


  public String revealWinner(){
    return getWinner().getName();
  }




  public String checkIfPlayerOut(Player player){
    if (player.getHand().getHandsValue() > 21){
      players.remove(player);
      return (player.getHand().toString() + "Sorry " + player.getName() + " , you've gone over 21. You're out.\n");
    }
    else 
      return player.getHand().toString();
  }






}