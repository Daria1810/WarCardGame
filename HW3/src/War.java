import java.util.Arrays;

public class War extends Deck {
    private int playerNum;
    private Player[] players;
    private Deck deck = new Deck();
    public Card[] cardsInPlay = new Card[10];
    private int cardsOnTable = 0;

    public War(int playerNum, Player[] players, Deck deck) {
        this.playerNum = playerNum;
        this.players = players;
        this.deck = deck;
    }

    public void addToTable(Card card) {
        if(cardsOnTable > playerNum) {
            throw new DuplicateCardException("Too many cards on table");
        }
        cardsInPlay[cardsOnTable] = card;
        cardsOnTable++;

    }

    public Card getMaxCard() {
                    Card maxCard = cardsInPlay[0];
                    for (int i = 1; i < cardsOnTable; i++) {
                        if (cardsInPlay[i].getRank().compareTo(maxCard.getRank()) > 0) {
                            maxCard = cardsInPlay[i];
                        }
                    }
                    return maxCard;
                }

    public boolean isGameOver() {
        int numPlayersWithCards = 0;
        for (Player player : players) {
            if (player.hasCards()) {
                numPlayersWithCards++;
            }
        }
        return numPlayersWithCards == 1;
    }

    public void Play() {
        while (true) {
           if (cardsOnTable != 0) {
                throw new DuplicateCardException("Table is not empty");
            }

            for (Player player : players) {
                if (player.hasCards()) {
                    Card playedCard = player.playCard();
                    System.out.println(player.getName() + " plays " + playedCard);
                    addToTable(playedCard);
                } else {
                    System.out.println(player.getName() + " has no cards left");
                    break;
                }
            }

            Card maxCard = getMaxCard();
            System.out.println();
            //System.out.println("Max card is " + maxCard);
            int nMax = 0;
            int index = -1;

            for(int i = 0; i < playerNum; i++) {
                if(cardsInPlay[i] != null && cardsInPlay[i].equals(maxCard)) {
                    nMax++;
                    index = i;
                }
            }

            if (nMax == 1) {

                for(int i=0; i<=playerNum; i++) {
                    if(cardsInPlay[i] != null && cardsInPlay[i].equals(maxCard)) {
                        for(int j=0; j<cardsOnTable; j++) {
                            players[i].addCard(cardsInPlay[j]);
                        }
                    }
                }
            }

            else {
                System.out.println("War!");
                Arrays.fill(cardsInPlay, null);
                cardsOnTable = 0;
                int numCardsToRemove = maxCard.getRank().getValue();
                for (Player player : players) {
                    if (player.getHand().cardCount >= numCardsToRemove) {
                        for (int j = 0; j < numCardsToRemove; j++) {
                                player.getHand().removeLastCard();   
                        }
                        System.out.println("Removed " + numCardsToRemove + " cards from " + player.getName());
                    } else {
                        System.out.println(player.getName() + " has no cards left");
                        break;
                    }
            }
        }
              
             Arrays.fill(cardsInPlay, null);
            cardsOnTable = 0;
            
            if (isGameOver()) {
                System.out.println("Game over");
                break;
            } 

            }
            
           
            
        }

    void printTest() {
        for (int i = 0; i < playerNum; i++) {
            if(players[i].hasCards()) 
                System.out.println(players[i].getName() + " has cards left");
            }
    }

}
    
