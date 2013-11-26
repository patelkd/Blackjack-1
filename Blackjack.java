import java.awt.*;
import java.applet.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Blackjack extends Applet implements ActionListener {

        private Deck deck;
        private Player p;
        private Player dealer;
        private JLabel cards;
        private JPanel winLosePanel = new JPanel();
        private JLabel winLoseLabel = new JLabel(" ");
        private JLabel label;
        private int value = 0;

        public void init() {

                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

                this.deck = new Deck();

                deck.shuffle();

                label = new JLabel(value + " ");
                label.setFont(new Font("sansserif", Font.BOLD, 32));
                this.add(label);

                this.cards = new JLabel();

                add(this.cards);

                p = new Human("Test Player", deck.dealCard(), 20, true);
                Card c = deck.dealCard();
                c.setFaceDown(true);
                dealer = new Dealer(c, 17);

                p.getButtons().addListeners(this);

                add(p.getPanel());
                add(dealer.getPanel());

                p.dealCard(deck, false);
                dealer.dealCard(deck, false);

                dealer.getPanel().changeScoreHidden(true);

                if (p.getScore() >= 21) {
                        playDealer();
                }
        }

        public void paint(Graphics g) {
                super.paint(g);
        }

        public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source.getText().equals("Hit")) {
                        p.dealCard(deck, false);
                        validate();

                        if (p.getScore() > 21) {
                        winLoseLabel = new JLabel("You bust! Better luck next time! You lost " + value + " dollars.");
                        winLosePanel.add(winLoseLabel);
                        this.add(winLosePanel);
                        validate();
                        repaint();
                                playDealer();
                        }
                        return;
                } else if (source.getText().equals("Stay")) {
                        playDealer();
                        if (dealer.getScore() < p.getScore() && p.getScore() <= 21 || (dealer.getScore() > 21 && p.getScore() <= 21)) {
                        winLoseLabel = new JLabel("You win! Congratulations :-) You won " + value + " dollars");
                        } else if ((dealer.getScore() == p.getScore()) || (dealer.getScore() > 21 && p.getScore() > 21)) {
                                winLoseLabel = new JLabel("You draw with the dealer...");
                        } else {
                                winLoseLabel = new JLabel("Sorry, you bust! Better luck next time :-( You lost " + value + " dollars.");
                        }
                        winLosePanel.add(winLoseLabel);
                        this.add(winLosePanel);
                        validate();
                        repaint();
                        
                        return;
                        
                } else if (source.getText().equals("Reset")) {
                        value = 0;
                        reset();
                        value = 0;
                        winLosePanel.remove(winLoseLabel);
                        value = 0;
                        return;
                } else if (source.getText().equals("New Hand")) {
                        winLosePanel.remove(winLoseLabel);
                        value = 0;
                        p.getButtons().setActive(true);
                        p.getButtons().getButtonByName("New Hand").setEnabled(false);
                        p.resetHand(deck.dealCard());
                        dealer.resetHand(deck.dealCard());
                        p.dealCard(deck, false);
                        dealer.dealCard(deck, false);

                        dealer.getPanel().changeScoreHidden(true);

                        validate();

                } else if (source.getText().equals("Bet")) {
                        value = value + 10;
                        label.setText("You bet: $" + value + " ");
                        repaint();
                } else if (source.getText().equals("Double Down")) {
                        value = value *2;
                        label.setText("You bet: $" + value + " ");
                }
        }

        public void playDealer() {
                p.getButtons().setActive(false);
                dealer.startHand(this.deck);

                p.getButtons().getButtonByName("New Hand").setEnabled(true);
        }

        public void reset() {
                label.setText("You bet: $" + 0);
                winLosePanel.remove(winLoseLabel);
                value = 0;
                p.getButtons().setActive(true);
                deck = new Deck();
                deck.shuffle();
                p.setScore(0);
                p.resetHand(deck.dealCard());
                dealer.setScore(0);
                dealer.resetHand(deck.dealCard());
                dealer.setMaxScore(17);

                p.dealCard(deck, false);
                dealer.dealCard(deck, false);
                value =0;
                dealer.getPanel().changeScoreHidden(true);
                value =0;
                validate();
        }

}
