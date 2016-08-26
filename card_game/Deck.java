package card_game;
import java.util.*;

public class Deck {

  private ArrayList<Card> deck;

  public Deck(){
    this.deck = new ArrayList<Card>();
  }

  public void fullDeck(){
    for(SuitType suit : SuitType.values()){
      for(RankType rank : RankType.values()){
        deck.add(new Card(rank, suit));
      }
    }
  }

  public int getCount(){
    return deck.size();
  }

  public Card dealACard(){
    Card card = deck.remove(0);
    return card;
  }

 

  public void shuffle() {
    Collections.shuffle(this.deck); 
  }


}