package card_game;
import java.util.*;

public class Game{

  private ArrayList<Player> players;
  private Deck deck;
  private int currentPlayerIndex;

  public Game(){
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

  public Player giveCurrentPlayer(){
    return players.get(currentPlayerIndex);
  }

  public int changeCurrentPlayer(){
    currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    return currentPlayerIndex;
  }

  public Player getWinner(){
    Player winner = players.get(0);
    for (Player currentPlayer : players){
      int score = currentPlayer.getHand().getHandsValue();
      if ((score > winner.getHand().getHandsValue()) && (score <= 21)){
        winner = currentPlayer;
      }
    }
    return winner;
  }


  public String revealWinner(){
    return getWinner().getName();
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

  public String checkIfPlayerOut(Player player){
    if (player.getHand().getHandsValue() > 21){
      players.remove(player);
      return (player.getHand().toString() + "Sorry " + player.getName() + " , you've gone over 21. You're out.\n");
    }
    else 
      return player.getHand().toString();
  }



  // public void playGame(){

  // }



}