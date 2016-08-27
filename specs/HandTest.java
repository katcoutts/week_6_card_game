import static org.junit.Assert.*;
import org.junit.*;
import card_game.*;

public class HandTest {

  Hand hand;
  Card card;
  Card card2;
  Card card3;
  Deck deck;
  Player player;
  
  
  @Before 
  public void before(){
    hand = new Hand();
    card = new Card(RankType.THREE, SuitType.CLUBS);
    card2 = new Card(RankType.JACK, SuitType.HEARTS);
    card3 = new Card(RankType.ACE, SuitType.HEARTS);
    deck = new Deck();
    player = new Player("Katrina");
  }

  @Test
  public void handStartsEmpty(){
    assertEquals(hand.getCount(), 0);
  }

  @Test
  public void canReceiveACard(){
    hand.receiveACard(card);
    assertEquals(hand.getCount(), 1);
  }

  @Test
  public void canGetACardFromDeck(){
    deck.fullDeck();
    Card card = deck.dealACard();
    hand.receiveACard(card);
    assertEquals(hand.getCount(), 1);
  }

  @Test
  public void canShowHandAsString(){
    hand.receiveACard(card);
    hand.receiveACard(card2);
    assertEquals("THREE of CLUBS\nJACK of HEARTS\n", hand.toString());
  }

  @Test
  public void canGetAHandsValue(){
    hand.receiveACard(card);
    hand.receiveACard(card2);
    int value = hand.getHandsValue();
    assertEquals(13, value);
    int score = hand.alterHandScoreForRanks();
    assertEquals(14, score);
  }

  @Test
  public void canReturnTrueIfFindsAnAce(){
    hand.receiveACard(card2);
    hand.receiveACard(card3);
    assertEquals(true, hand.checkForAnAce());
  } 

  @Test
  public void canReturnFalseIfFindsAnAce(){
    hand.receiveACard(card2);
    hand.receiveACard(card);
    assertEquals(false, hand.checkForAnAce());
  }




}