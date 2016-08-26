import static org.junit.Assert.*;
import org.junit.*;
import card_game.*;

public class PlayerTest {

  Hand hand;
  Player player;
  Card card;
  Card card1;
  
  
  @Before 
  public void before(){
    hand = new Hand();
    player = new Player("Katrina");
    card = new Card(RankType.SIX, SuitType.CLUBS);
    card1 = new Card(RankType.KING, SuitType.CLUBS);
  }

  @Test
  public void playerHasAName(){
    assertEquals( "Katrina" , player.getName());
  }

  @Test
  public void handStartsEmpty(){
    assertEquals(0, player.getHand().getCount());
  }

  // @Test
  // public void playerCanGetPrettyHand(){
  //   player.getHand().receiveACard(card);
  //   player.getHand().receiveACard(card1);
  //   assertEquals("SIX of CLUBSKING of CLUBS", player.getHand().toString());
  // }

  @Test
  public void canGetAHand(){
    player.getHand().receiveACard(card);
    player.getHand().receiveACard(card1);
    assertEquals(16, player.getHand().getHandsValue());
  }


}