import static org.junit.Assert.*;
import org.junit.*;
import card_game.*;

public class HandTest {

  Hand hand;
  Card card;
  
  @Before 
  public void before(){
    hand = new Hand();
    card = new Card(RankType.THREE, SuitType.CLUBS);
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

}