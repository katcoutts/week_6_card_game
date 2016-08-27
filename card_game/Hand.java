package card_game;
import java.util.*;

public class Hand{

  private ArrayList<Card> hand;
  private Card card;


  public Hand(){
    this.hand = new ArrayList<Card>();
  }

  public void receiveACard(Card card){
    hand.add(card);
  }

  public int getCount(){
    return hand.size();
  }

  public String toString(){
    String string = "";
    for( Card card : hand){
      string += card.toString() + "\n";
    }
    return string;
  }

 public int alterHandScoreForRanks(){
  int score = getHandsValue();   
  for (Card card : hand){
    if (card.getRank() == RankType.JACK){
      score ++; 
    }  
    if (card.getRank() == RankType.QUEEN){
      score += 2;
    }
    if (card.getRank() == RankType.KING){
      score +=3;
    }
  }
  return score;
 }

 public int alterHighHandScoreForRanks(){
  int score = getHandsHighValue();   
  for (Card card : hand){
    if (card.getRank() == RankType.JACK){
      score ++; 
    }  
    if (card.getRank() == RankType.QUEEN){
      score += 2;
    }
    if (card.getRank() == RankType.KING){
      score +=3;
    }
  }
  return score;
 }

  public int getHandsValue(){
    int counter = 0;
    for (Card card : hand){
      counter += card.getRank().getLowValue();
    }
    return counter;
  } 

  public int getHandsHighValue(){
    int counter = 0;
    for (Card card : hand){
      counter += card.getRank().getHighValue();
    }
    return counter;
  }

  public boolean checkForAnAce(){
    for (Card card : hand){
      if (card.getLowValue() == 1)
        return true;
    }
    return false;
  }

}