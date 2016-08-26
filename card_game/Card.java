package card_game;

public class Card {

  RankType rank;
  SuitType suit;

  public Card(RankType rank, SuitType suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public SuitType getSuit() {
    return suit;
  }  

  public RankType getRank() {
    return rank;
  }

  public int getValue() {
    return rank.getValue();
  }

  public String toString() {{
      return rank.toString() + " of " + suit.toString();
    }
  }

  // make a method here that prints out nicely what the card is??
  // MAY NEED A toString method - specifically called toString

}