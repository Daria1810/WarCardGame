public class WarTest {
    
    public static void main(String[] args) throws Exception {
        
        Deck deck = new Deck();
        deck.print();
        System.out.println("\n");
        System.out.println("Shuffling... \n \n");
        deck.shuffle();
        //deck.print();

        System.out.println("\n");
        
        Player[] players = new Player[2];
        players[0] = new Player("Player 1");
        players[1] = new Player("Player 2");

        deck.dealDeck(players);

        System.out.println("Player 1's hand: ");
        players[0].getHand().display();

        System.out.println("\n");

        System.out.println("Player 2's hand: ");
        players[1].getHand().display();

        War war = new War(2, players, deck);
        war.Play();
        war.printTest();


}



}
