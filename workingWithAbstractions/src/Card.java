public class Card {
    private CardRanks cardRank;
    private CardSuits cardSuit;
    private int power;

    public Card(CardSuits cardSuit, CardRanks cardRank){
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public int getPower(){
        return this.cardRank.getValue() + cardSuit.getSuitPower();
    }
}
