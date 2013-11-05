public class Card {
        
        private String value;
        private String suit;
        private int value2;


        public Card(String suit, String value) {
            this.value = value;
            this.suit = suit;
        }
        public Card(String suit, String value, int value2) {
            this.suit = suit;
            this.value = value;
            this.value2 = value2;
        }
        
}
