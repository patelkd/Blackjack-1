import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class HandPanel extends JPanel {

        private Hand hand;
        private int score;
        private boolean isScoreHidden;
        private JLabel scoreLabel;
        private NumberPanel numberPanel;
        private String scorePrefix;

        public HandPanel(Player p, Card initialCard, boolean hasButtons) {
                this.hand = new Hand(initialCard);
                this.isScoreHidden = false;
                this.score = this.hand.calculateScore(initialCard, p.getMaxScore());
                this.scorePrefix = p.getName() + "'s Score: ";
                this.scoreLabel = new JLabel(scorePrefix + this.score);
                
                if (hasButtons) {
                        this.numberPanel = new NumberPanel();
                }

                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                add(scoreLabel);
                if (hasButtons) {
                        add(numberPanel);
                }
                add(hand);


                validate();
        }

        public NumberPanel getButtons() {
                return this.numberPanel;
        }
        //hides dealer's score
        public void hideScore(boolean state) {
                if (state) {
                        this.scoreLabel.setText(this.scorePrefix + " ");
                
                } else {
                        this.scoreLabel.setText(this.scorePrefix + this.score);

                }

                validate();
        }

        public void setScore(int score) {
                this.score = score;
                this.scoreLabel.setText(this.scorePrefix + this.score);
        } 

        public int getScore() {
                return this.score;
        }

        public Hand getHand() {
                return this.hand;
        }

        public void setHand(Hand hand) {
                remove(this.hand);
                this.hand = hand;
                add(this.hand);
                validate();
        }
}
