import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;

public class Hand implements Storable {
    public Card[] cards = new Card[52];
    public int cardCount = 0;

    public void addCard(Card card) {

        if (cardCount >= 52) {
            throw new DuplicateCardException("Hand is full");
        }
        for (int i = 0; i < cardCount; i++) {
            if (cards[i].equals(card)) {
                throw new DuplicateCardException("Duplicate card found: " + card);
            }
        }
        cards[cardCount] = card;
        cardCount++;
    }

    public void deleteCard(Card card) {

        if (cardCount == 0) {
            throw new DuplicateCardException("Hand is empty");
        }

        for (int i = 0; i < cardCount; i++) {
            if (cards[i].equals(card)) {
                for (int j = i; j < cardCount - 1; j++) {
                    cards[j] = cards[j + 1];
                }
                cardCount--;
                return;
            }
        }

        throw new DuplicateCardException("Card not found: " + card);

    }

    public Card removeLastCard() {
        if (cardCount == 0) {
            throw new DuplicateCardException("Hand is empty");
        }

        Card tempCard = cards[cardCount - 1];
        cards[cardCount - 1] = null;
        cardCount--;

        return tempCard;
    }


    public void display() {
        for (int i = 0; i < cardCount; i++) {
            System.out.println(i+1 + ". " + cards[i]);
        }
    }

    @Override
    public void Store(String file) {
        try (FileWriter fileWriter = new FileWriter(file);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (int i = 0; i < cardCount; i++) {
                if (cards[i] != null)
                    printWriter.println(cards[i]);
            }
            System.out.println("Hand contents have been saved to " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sort() {
        Arrays.sort(cards, 0, cardCount);
    }
}
