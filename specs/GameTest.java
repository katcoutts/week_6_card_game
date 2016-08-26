import static org.junit.Assert.*;
import org.junit.*;
import card_game.*;
import java.util.*;

public class GameTest{

  Game game;
  ArrayList<Player> players;
  Deck deck;
  Player player;
  Player player2;
  Player player3;
  Card card;
  Card card1;
  Card card2;
  Card card3;
  Card card4;
  Card card5;

  @Before
  public void before(){
    players = new ArrayList<Player>();
    player = new Player("Katrina");
    player2 = new Player("Charley");
    player3 = new Player("Hannah");
    deck = new Deck();
    game = new Game (players, deck);
    card = new Card(RankType.SIX, SuitType.CLUBS);
    card1 = new Card(RankType.KING, SuitType.CLUBS);
    card2 = new Card(RankType.NINE, SuitType.CLUBS);
    card3 = new Card(RankType.EIGHT, SuitType.CLUBS);
    card4 = new Card(RankType.QUEEN, SuitType.SPADES);
    card5 = new Card(RankType.JACK, SuitType.HEARTS);
  }

  @Test
  public void gameStartsWithNoPlayers(){
    assertEquals(0, game.playerCount());
  }


  @Test
  public void canAddAPlayer(){
    game.addAPlayer(player);
    assertEquals(1, game.playerCount());
  }

  @Test
  public void canGiveCurrentPlayer(){
  game.addAPlayer(player);
  assertEquals("Katrina", game.giveCurrentPlayer().getName());
  }

  @Test
  public void canChangeCurrentPlayer(){
    game.addAPlayer(player);
    game.addAPlayer(player2);
    game.addAPlayer(player3);
    assertEquals("Katrina", game.giveCurrentPlayer().getName());
    game.changeCurrentPlayer();
    assertEquals("Charley", game.giveCurrentPlayer().getName());
    game.changeCurrentPlayer();
    assertEquals("Hannah", game.giveCurrentPlayer().getName());
  }

  @Test
  public void canCalculateWinner(){
    game.addAPlayer(player);
    game.addAPlayer(player2);
    game.addAPlayer(player3);
    player.getHand().receiveACard(card);
    player.getHand().receiveACard(card1);
    player2.getHand().receiveACard(card2);
    player2.getHand().receiveACard(card3);
    player3.getHand().receiveACard(card4);
    player3.getHand().receiveACard(card5);
    Player winner = game.getWinner();
    assertEquals("Hannah", winner.getName());
  }

  @Test
  public void canGetTwoCards(){
    game.addAPlayer(player);
    game.addAPlayer(player2);
    game.dealToPlayers();
    assertEquals(2, player.getHand().getCount());
  }




}