import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.List;
import java.util.ArrayList;

public class Hand extends JPanel {

        private Card[] cards;
        private int amountOfCards;

        public Hand(Card card) {
                this.cards = new Card[11];
                this.cards[0] = card;
                this.amountOfCards = 1;

                add(card);
        }

        //faces cards up
        public void setAllFaceUp() {
                for (int i = 0 ; i < amountOfCards ; i++) {
                        this.cards[i].setCardDown(false);
                }
        }
        //adds an additional card
        public int addCard(Card c, boolean cardDown, int maxScore) {
                if (amountOfCards < 11) {
                        c.setCardDown(cardDown);
                        cards[amountOfCards] = c;
                        amountOfCards++;

                        add(c);
                }

                return calculateScore(c, maxScore);
        }

        //adds score value
        public int calculateScore(Card newCard, int maxScore) {

                int newScore = 0;
                List<Card> aces = new ArrayList<Card>(4);

                for (int i = 0 ; i < countCards() ; i++) {
                        if (getCards()[i].getValues().length == 2) {
                                aces.add(getCards()[i]);
                        } else {
                                newScore += getCards()[i].getValues()[0];
                        }
                }

                for (Card ace : aces) {
                        if (newScore + ace.getValues()[1] <= 21 && newScore + ace.getValues()[1] != maxScore) {
                                newScore += ace.getValues()[1];
                        } else {
                                newScore += ace.getValues()[0];

                        }
                }

                return newScore;
        }

        public Card[] getCards() {
                return this.cards;
        }

        public int countCards() {
                return this.amountOfCards;
        }

        public String toString() {
                String output = "";
                for (Card c : this.cards) {
                        output += c + " ";
                }

                return output;
        }

}
