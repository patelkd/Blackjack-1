import java.awt.*;
import java.applet.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Blackjack extends Applet implements ActionListener {

        private Deck deck;
        private Player player;
        private Player dealer;
        private JLabel cards;
        private JPanel resultPanel = new JPanel();
        private JLabel resultLabel = new JLabel(" ");
        private JLabel label;
        private int value = 0;


//layout of the table
        public void init() {


                this.deck = new Deck();

                deck.shuffle();

                label = new JLabel(value + " ");
                label.setFont(new Font("sansserif", Font.BOLD, 32));
                this.add(label);

                this.cards = new JLabel();

                add(this.cards);

                player = new Human("Player", deck.dealCards(), 20, true);
                Card one = deck.dealCards();
                one.setCardDown(true);
                dealer = new Dealer(one, 17);

                player.getButtons().addActionListeners(this);

                add(player.getPanel());
                add(dealer.getPanel());

                player.dealCard(deck, false);
                dealer.dealCard(deck, false);

                dealer.getPanel().hideScore(true);

                if (player.getScore() >= 21) {
                        dealerTurn();
                }
        }

        //getting graphics
        public void paint(Graphics g) {
                super.paint(g);
        }

        //sets button actions when clicked
        public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source.getText().equals("Hit")) {
                        player.dealCard(deck, false);
                        validate();

                        if (player.getScore() > 21) {
                        resultLabel = new JLabel("You bust! Better luck next time! You lost " + value + " dollars.");
                        resultPanel.add(resultLabel);
                        this.add(resultPanel);
                        validate();
                        repaint();
                        dealerTurn();
                        }
                        return;
                } else if (source.getText().equals("Stay")) {
                        dealerTurn();
                        if (dealer.getScore() < player.getScore() && player.getScore() <= 21 || (dealer.getScore() > 21 && player.getScore() <= 21)) {
                        resultLabel = new JLabel("You win! Congratulations :-) You won " + value + " dollars");
                        } else if ((dealer.getScore() == player.getScore()) || (dealer.getScore() > 21 && player.getScore() > 21)) {
                                resultLabel = new JLabel("You draw with the dealer...");
                        } else {
                                resultLabel = new JLabel("Sorry, you bust! Better luck next time :-( You lost " + value + " dollars.");
                        }
                        resultPanel.add(resultLabel);
                        this.add(resultPanel);
                        validate();
                        repaint();
                        
                        return;
                        
                } else if (source.getText().equals("Reset")) {
                        value = 0;
                        reset();
                        value = 0;
                        resultPanel.remove(resultLabel);
                        value = 0;
                        return;
                } else if (source.getText().equals("New Hand")) {
                        resultPanel.remove(resultLabel);
                        value = 0;

                        dealer.getPanel().hideScore(true);

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

        //reveals dealer's cards
        public void dealerTurn() {
               
                dealer.startHand(this.deck);

                player.getButtons().getButtonByName("New Hand").setEnabled(true);
        }


        //starts a new game when someone has won
        public void reset() {
                label.setText("You bet: $" + 0);
                resultPanel.remove(resultLabel);
                deck = new Deck();
                deck.shuffle();
                player.setScore(0);
                player.resetHand(deck.dealCards());
                dealer.setScore(0);
                dealer.resetHand(deck.dealCards());
                dealer.setMaxScore(17);

                player.dealCard(deck, false);
                dealer.dealCard(deck, false);
                dealer.getPanel().hideScore(true);
                validate();
        }

}
