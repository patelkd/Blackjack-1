import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Dimension;

public class Card extends JLabel {

        private boolean cardDown;
        private int[] values;
        private int cardNumber;
        private String suit;
        

        public Card(int cardNumber, String suit, int[] values) {
                this.cardNumber = cardNumber;
                this.values = values;
                this.suit = suit;
                this.cardDown = false;

                this.setIcon(new ImageIcon(this.loadImage(this.convertString(), this.cardDown, 150, 200)));
        }


//check if the card is face down
        public boolean isCarddown() {
                return this.cardDown;
        }

        //these are the setters

        public void setCardDown(boolean state) {
                this.cardDown = state;
                this.setIcon(new ImageIcon(this.loadImage(this.convertString(), state, 150, 200)));
        }

        //these are the getters
        public String getSuit() {
                return this.suit;
        }

        public int Number() {
                return this.cardNumber;
        }

        public int[] getValues() {
                return this.values;
        }

     
        private static Image loadImage(String name, boolean cardDown, int width, int height) {
                String path = null;
                Image image = null;
                Image scaled = null;

                try {
                        if (cardDown) {
                                path = "cards" + File.separator + "back-blue.png"; 
                        } else {
                                path = "cards" + File.separator + name + ".png";
                        }
                        image = ImageIO.read(new File(path));
                        scaled = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                } catch (IOException e) {
                        System.out.println("Could not load card at path: " + path);
                        e.printStackTrace();
                }

                return scaled;
        }

        //calls card type
        public String getCardFace() {
                switch(this.cardNumber) {
                        case 1:
                                return "A";
                        case 11:
                                return "J";
                        case 12:
                                return "Q";
                        case 13:
                                return "K";
                        default:
                                return ("" + this.cardNumber);
                }
        }

        //Converts card type to a string to be drawn from card folder
        public String convertString() {
                return this.getCardFace() + this.getSuit(); 
        }

}
