import static org.junit.Assert.*;
import org.junit.*;
import card_game.*;

public class CardTest {

  Card card;
  Card card1;
  
  @Before 
  public void before(){
    card = new Card(RankType.THREE, SuitType.CLUBS);
  }

  @Test
  public void canGetSuit(){
    assertEquals(card.getSuit(), SuitType.CLUBS);
  }

  @Test
  public void canGetRank(){
    assertEquals(card.getRank(), RankType.THREE);
  }

  // @Test
  // public void canGetValue(){
  //   assertEquals(card.getRank().getValue(), 3);
  // }

  @Test
  public void canGetLowValue() {
    assertEquals(card.getLowValue(), 3);
  }

  @Test
  public void canGetHighAce(){
    card1 = new Card(RankType.ACE, SuitType.CLUBS);
    assertEquals(11, card1.getHighValue());
  } 

  @Test
  public void canGetLowAce(){
    card1 = new Card(RankType.ACE, SuitType.CLUBS);
    assertEquals(1, card1.getLowValue());
  } 

  @Test
  public void canGetLowAceDirect(){
    card1 = new Card(RankType.ACE, SuitType.CLUBS);
    assertEquals(1, card1.getLowValue());
  }

  @Test 
  public void canGetStringOfCard(){
    assertEquals("THREE of CLUBS", card.toString());
  }


}