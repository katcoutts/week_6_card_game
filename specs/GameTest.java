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
  Card card6;
  Card card7;
  Card card8;
  Card card9;
  Card card10;
  Card card11;

  @Before
  public void before(){
    players = new ArrayList<Player>();
    player = new Player("Katrina");
    player2 = new Player("Charley");
    player3 = new Player("Hannah");
    deck = new Deck();
    game = new Game ();
    card = new Card(RankType.SIX, SuitType.CLUBS);
    card1 = new Card(RankType.KING, SuitType.CLUBS);
    card2 = new Card(RankType.NINE, SuitType.CLUBS);
    card3 = new Card(RankType.EIGHT, SuitType.CLUBS);
    card4 = new Card(RankType.QUEEN, SuitType.SPADES);
    card5 = new Card(RankType.JACK, SuitType.HEARTS);
    card6 = new Card(RankType.EIGHT, SuitType.HEARTS);
    card7 = new Card(RankType.ACE, SuitType.HEARTS);
    card8 = new Card(RankType.ACE, SuitType.SPADES);
    card9 = new Card(RankType.KING, SuitType.SPADES);
    card10 = new Card(RankType.TEN, SuitType.SPADES);
    card11 = new Card(RankType.FOUR, SuitType.SPADES);
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
    // game.addAPlayer(player3);
    player.getHand().receiveACard(card);
    player.getHand().receiveACard(card1);
    player2.getHand().receiveACard(card2);
    player2.getHand().receiveACard(card3);
    // player3.getHand().receiveACard(card4);
    // player3.getHand().receiveACard(card5);
    Player winner = game.getWinner();
    assertEquals("Charley", winner.getName());
  }


  @Test
  public void canRevealWinner(){
    game.addAPlayer(player);
    game.addAPlayer(player2);
    // game.addAPlayer(player3);
    player2.getHand().receiveACard(card);
    player2.getHand().receiveACard(card1);
    player.getHand().receiveACard(card2);
    player.getHand().receiveACard(card3);
    // player3.getHand().receiveACard(card4);
    // player3.getHand().receiveACard(card5);
    assertEquals("Katrina", game.revealWinner());
  }

  @Test
  public void canTreatAceAs11IfGetsHigherScore(){
    game.addAPlayer(player);
    game.addAPlayer(player2);
    player.getHand().receiveACard(card8);
    player.getHand().receiveACard(card9);
    player2.getHand().receiveACard(card3);
    player2.getHand().receiveACard(card6);
    assertEquals("Katrina", game.revealWinner());
  }  

  @Test
  public void advancedWinnerCanTreatAceAs11(){
    game.addAPlayer(player);
    game.addAPlayer(player2);
    player.getHand().receiveACard(card8);
    player.getHand().receiveACard(card9);
    player2.getHand().receiveACard(card7);
    player2.getHand().receiveACard(card10);
    assertEquals("Katrina", game.getAdvancedWinner().getName());
  }

  @Test
  public void testIfFiveCardsTrumpsLess(){
    game.addAPlayer(player);
    game.addAPlayer(player2);
    player.getHand().receiveACard(card9);
    player.getHand().receiveACard(card10);
    player2.getHand().receiveACard(card6);
    player2.getHand().receiveACard(card7);
    player2.getHand().receiveACard(card8);
    player2.getHand().receiveACard(card);
    player2.getHand().receiveACard(card11);
    assertEquals("Charley", game.getAdvancedWinner().getName());
  }

  @Test
  public void returnsNullIfNoBasicWinner(){
    game.addAPlayer(player);
    game.addAPlayer(player2);
    player.getHand().receiveACard(card3);
    player.getHand().receiveACard(card4); 
    player2.getHand().receiveACard(card5);
    player2.getHand().receiveACard(card6);
    assertEquals(null, game.getWinner());
   }

  @Test
  public void canGetAdvancedWinner(){
    game.addAPlayer(player);
    game.addAPlayer(player2);
    player.getHand().receiveACard(card3);
    player.getHand().receiveACard(card4); 
    player2.getHand().receiveACard(card5);
    player2.getHand().receiveACard(card6);
    assertEquals("Katrina", game.getAdvancedWinner().getName());
   }

   @Test
   public void canSeparateEqualScoresBasedOnHandLength(){
    game.addAPlayer(player);
    game.addAPlayer(player2);
    player.getHand().receiveACard(card);
    player.getHand().receiveACard(card1);
    player.getHand().receiveACard(card7);
    player.getHand().receiveACard(card8);
    player2.getHand().receiveACard(card6);
    player2.getHand().receiveACard(card9);
    assertEquals("Katrina", game.getWinnerByHandsLength().getName());
   }


  // @Test
  // public void cantWinIfOver21(){
  //   game.addAPlayer(player);
  //   game.addAPlayer(player2);
  //   player.getHand().receiveACard(card);
  //   player.getHand().receiveACard(card1);
  //   player2.getHand().receiveACard(card2);
  //   player2.getHand().receiveACard(card3);
  //   player2.getHand().receiveACard(card4);
  //   assertEquals("Katrina", game.revealWinner());
  // }

  @Test
  public void canGetTwoCards(){
    game.addAPlayer(player);
    game.addAPlayer(player2);
    game.dealToPlayers();
    assertEquals(2, player.getHand().getCount());
  }

  @Test
  public void playerCanTwist(){
    game.addAPlayer(player);
    game.addAPlayer(player2);
    game.dealToPlayers();
    game.playerTwist(player);
    assertEquals(3, player.getHand().getCount());
  }

  // @Test
  // public void canTellPlayerIfTheyreOver21(){
  //   game.addAPlayer(player);
  //   player.getHand().receiveACard(card);
  //   player.getHand().receiveACard(card1);
  //   player.getHand().receiveACard(card2);
  //   String value = game.checkIfPlayerOut(player);
  //   assertEquals("Sorry, you've gone over 21. You're out.", value);
  // }


}