package card_game;
import java.util.*;

public class Game{

  private ArrayList<Player> players;
  private Deck deck;
  private int currentPlayerIndex;

  public Game(ArrayList<Player> players, Deck deck){
    this.players = new ArrayList<Player>();
    this.deck = deck;
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
      if (score > winner.getHand().getHandsValue()){
        winner = currentPlayer;
      }
    }
    return winner;
  }
// SHOULD SOME DEALING STUFF GO IN A DEALER??
  public void dealToPlayers(){
    deck.fullDeck();
    for(int i = 0; i < 2; i++){
      for (Player player : players){
      player.getHand().receiveACard(deck.dealACard());
    }
  }
  }


  // public void playGame(){

  // }



}