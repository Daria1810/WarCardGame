public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return this.name;
    }

    public Hand getHand() {
        return this.hand;
    }

    public void addCard(Card card) {
        this.hand.addCard(card);
    }

    public Card playCard() {
        return this.hand.removeLastCard();

    }

    public boolean hasCards() {
        return this.hand.cardCount > 0;
    }

    public Card getLastCard() {
        return this.hand.cards[this.hand.cardCount - 1];
    }
}
