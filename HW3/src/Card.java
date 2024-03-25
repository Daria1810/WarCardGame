
public final class Card implements Comparable{
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES;
    }

    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), KNIGHT(12), QUEEN(13), KING(14), ACE(15);

        private final int value;

        private Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private final Rank rank;
    private final Suit suit;


    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
public int compareTo(Object o) {
    final int BEFORE = -1;
    final int EQUAL = 0;
    final int AFTER = 1;
    Card c = (Card) o;

    int thisValue = this.rank.getValue();
    int otherValue = c.rank.getValue();

    if (thisValue < otherValue) {
        return BEFORE;
    } else if (thisValue > otherValue) {
        return AFTER;
    }

    return EQUAL;
}
    }
    
    
