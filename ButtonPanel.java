import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

        JButton hit;
        JButton stay;
        JButton newHand;
        JButton reset;
        JButton doubleDown;
        JButton bet;

        public ButtonPanel() {
                this.hit = new JButton("Hit");
                this.stay = new JButton("Stay");
                this.newHand = new JButton("New Hand");
                this.reset = new JButton("Reset");
                this.doubleDown = new JButton("Double Down");
                this.bet = new JButton("Bet");

                this.newHand.setEnabled(false);

                add(this.hit);
                add(this.stay);
                add(this.newHand);
                add(this.reset);
                add(this.doubleDown);
                add(this.bet);

                this.setMaximumSize(new Dimension(650, 100));
        }

        public void addListeners(Blackjack applet) {
                this.hit.addActionListener(applet);
                this.stay.addActionListener(applet);
                this.newHand.addActionListener(applet);
                this.reset.addActionListener(applet);
                this.doubleDown.addActionListener(applet);
                this.bet.addActionListener(applet);
        }

        public void setActive(boolean state) {
                this.hit.setEnabled(state);
                this.stay.setEnabled(state);
        }

        public JButton getButtonByName(String name) {
                if (name.equalsIgnoreCase("hit")) {
                        return this.hit;
                } else if (name.equalsIgnoreCase("stay")) {
                        return this.stay;
                } else if (name.equalsIgnoreCase("new hand")) {
                        return this.newHand;
                } else if (name.equalsIgnoreCase("reset")) {
                        return this.reset;
                } else if (name.equalsIgnoreCase("bet")) {
                        return this.bet;
                } else if (name.equalsIgnoreCase("double down")) {
                        return this.doubleDown;
                }
                return this.hit;
        }
}
