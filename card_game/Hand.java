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

  public void burnHand(){
    hand.clear();
  }

  public boolean burnableHand(){
    if (getHandsValue() == 13){
      return true;
    }
    return false;
  }

  public int findBestScore(){
    int playerBestScore = 0;
    if ((getHandsHighValue() > getHandsValue()) && (getHandsHighValue() <= 21)){
      playerBestScore = getHandsHighValue();
    }
    else if (((getHandsHighValue() - 10) > getHandsValue()) && ((getHandsHighValue() - 10) <= 21)){
      playerBestScore = (getHandsHighValue() - 10);
    }
    else if (((getHandsHighValue() - 20) > getHandsValue()) && ((getHandsHighValue() - 20) <= 21)){
      playerBestScore = (getHandsHighValue() - 20);
    }
    else if (getHandsValue() <= 21){
      playerBestScore = getHandsValue();
    }
    else {
      playerBestScore = 0;
    }
    return playerBestScore;
  }

  public int handValueAdjustForRank(){
    int score = findBestScore();
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








}