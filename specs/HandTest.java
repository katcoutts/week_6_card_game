import static org.junit.Assert.*;
import org.junit.*;
import card_game.*;

public class HandTest {

  Hand hand;
  Card card;
  Card card2;
  Card card3;
  Card card4;
  Card card5;
  Deck deck;
  Player player;
  
  
  @Before 
  public void before(){
    hand = new Hand();
    card = new Card(RankType.THREE, SuitType.CLUBS);
    card4 = new Card(RankType.THREE, SuitType.HEARTS);
    card2 = new Card(RankType.JACK, SuitType.HEARTS);
    card3 = new Card(RankType.ACE, SuitType.HEARTS);
    card5 = new Card(RankType.ACE, SuitType.CLUBS);
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
    int score = hand.handValueAdjustForRank();
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

  @Test
  public void canBurnHand(){
    hand.receiveACard(card2);
    hand.receiveACard(card);
    hand.burnHand();
    assertEquals(0, hand.getCount());
  }

  @Test 
  public void canSpotBurnableHand(){
    hand.receiveACard(card4);
    hand.receiveACard(card2);
    assertEquals(true, hand.burnableHand());
  }

  @Test
  public void canFindHandsBestScore(){
    hand.receiveACard(card2);
    hand.receiveACard(card3);
    assertEquals(21, hand.findBestScore());
  }

  @Test
  public void canGetAdvancedScore(){
    hand.receiveACard(card2);
    hand.receiveACard(card3);
    assertEquals(22, hand.handValueAdjustForRank());
  }

  @Test
  public void canTreatOneAceHighOneAceLow(){
    hand.receiveACard(card3);
    hand.receiveACard(card4);
    hand.receiveACard(card5);
    assertEquals(15, hand.findBestScore());
  }




}