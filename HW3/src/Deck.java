import java.util.Random;

public class Deck {
    public Card[] cards = new Card[52];
    private int cardCount = 0;

    public void addCard(Card card) {

        if (cardCount == 52) {
            throw new DuplicateCardException("Deck is full");
        }
        for (int i = 0; i < cardCount; i++) {
            if (cards[i].equals(card)) {
                throw new DuplicateCardException("Duplicate card found: " + card);
            }
        }
        cards[cardCount++] = card;
    }

    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                addCard(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = cardCount - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public void print() {
        if (cardCount < 52) {
            throw new DuplicateCardException("Deck is incomplete");
        }

        if (cardCount > 52) {
            throw new DuplicateCardException("Deck has too many cards? How did you manage that?");
        }

        for (int i = 0; i < cardCount; i++) {
            System.out.println(i+1 + ". " + cards[i]);
        }
    }

    public void dealDeck(Player[] players) {
        int nrPlayers = players.length;
        int handLength = 52 / nrPlayers;

        for (int i = 0; i < nrPlayers; i++) {

            for (int j = 0; j < handLength; j++) {
                players[i].addCard(cards[i * handLength + j]);

            }
        }

        int remainder = 52 % nrPlayers;
        for (int i = 0; i < remainder; i++) {
            players[i].addCard(cards[52 - remainder + i]);
        }

    }

}
