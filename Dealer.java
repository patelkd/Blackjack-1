public class Dealer extends Player {

        public Dealer(Card initialCard, int maxScore) {
                super("Dealer", initialCard, maxScore, false);
        }

    
        //gives information on original starting hand
        public void startHand(Deck d) {
                getPanel().hideScore(false);

                getHand().setAllFaceUp();
                getHand().validate();

                while (getScore() < getMaxScore()) {
                        dealCard(d, false);
                }
        }

        //resets the hand of the player or dealer
        public void resetHand(Card card) {
                card.setCardDown(true);
                super.resetHand(card);
        }
}
