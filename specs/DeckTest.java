import static org.junit.Assert.*;
import org.junit.*;
import card_game.*;

public class DeckTest {

  Deck deck;
  
  @Before 
  public void before(){
    deck = new Deck();
  }

  @Test
  public void deckStartsEmpty(){
    assertEquals(deck.getCount(), 0);
  }

  @Test
  public void canFillDeck(){
    deck.fullDeck();
    assertEquals(deck.getCount(), 52);
  }

  @Test
  public void canTakeCardOutOfDeck(){
    deck.fullDeck();
    Card card = deck.dealACard();
    assertEquals(card.getSuit(), SuitType.HEARTS);
    assertEquals(deck.getCount(), 51);
  }

  // @Test
  // public void canShuffle(){
  //   deck.fullDeck();
  //   deck.shuffle();
  //   Card card = deck.dealACard();
  //   assertEquals(card.getRank(), RankType.ACE);
  // }

}