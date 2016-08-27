package card_game;

public enum RankType {

  ACE(1, 11),
  TWO(2, 2),
  THREE(3, 3),
  FOUR(4, 4),
  FIVE(5, 5),
  SIX(6, 6),
  SEVEN(7, 7),
  EIGHT(8, 8),
  NINE(9, 9),
  TEN(10, 10),
  JACK(10, 10),
  QUEEN(10, 10),
  KING(10, 10);

  // int value;

  // RankType(int value) {
  //     this.value = value;
  // }

  // public int getValue() {
  //     return value;
  // }


  int low;
  int high;

  RankType(int low, int high){
   this.low = low;
   this.high = high;
 }

  public int getLowValue() {
   return this.low;
  }

  public int getHighValue() {
    return this.high;
  }



}