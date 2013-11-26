import javax.swing.*;
import java.awt.*;

public class NumberPanel extends JPanel {

        JButton hit;
        JButton stay;
        JButton newHand;
        JButton reset;
        JButton doubleDown;
        JButton bet;

        //setting button labels and telling them the actions to perform
        public NumberPanel() {
                this.hit = new JButton("Hit");
                this.stay = new JButton("Stay");
                this.newHand = new JButton("New Hand");
                this.reset = new JButton("Reset");
                this.doubleDown = new JButton("Double Down");
                this.bet = new JButton("Bet");


                add(this.hit);
                add(this.stay);
                add(this.newHand);
                add(this.reset);
                add(this.doubleDown);
                add(this.bet);

                this.setMaximumSize(new Dimension(650, 100));
        }

        //adds action listener to each button type; tells program what to
        //do when each button is clicked graphically
        public void addActionListeners(Blackjack applet) {
                this.hit.addActionListener(applet);
                this.stay.addActionListener(applet);
                this.newHand.addActionListener(applet);
                this.reset.addActionListener(applet);
                this.doubleDown.addActionListener(applet);
                this.bet.addActionListener(applet);
        }

        //makes the hit method work; returns hit
        public JButton getButtonByName(String name) {
       
                return this.hit;

        }
}
