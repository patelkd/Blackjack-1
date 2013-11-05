public class Deck {
       
        private String[][] deck;
        private String[] cardNames = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        private String[] suitNames = {"Diamonds", "Hearts", "Clubs", "Spades"};
       private int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

        public Deck() {
                Deck deck = {};

                for (int i=0; i<4; i++) {
                        for (int j=0; j<13; j++) {
      
                        
                                deck[i][j] = new Card(suitNames[i], cardNames[j]);
                       
                        System.out.println(deck[i][j].value + "of" + deck[i][j].suit);
                         }
                
                 }
        
        }
}
