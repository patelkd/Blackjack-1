public class Dealer extends Player {

        public Dealer(Card initialCard, int maxScore) {
                super("Dealer", initialCard, maxScore, false);
        }

        public void resetHand(Card card) {
                card.setFaceDown(true);
                super.resetHand(card);
        }

        public void startHand(Deck d) {
                getPanel().changeScoreHidden(false);

                getHand().setAllFaceUp();
                getHand().validate();

                while (getScore() < getMaxScore()) {
                        dealCard(d, false);
                }
        }

}
