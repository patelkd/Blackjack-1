import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card {
        
        private String name;
        private int value;
        private Image image;


        public Card(String name, int value) {
            this.name = name;
            this.value = value;
            this.image = Deck.loadImage(name);
        }

        public String name() {
            return this.name;
        }
        
        public void draw(Graphics g, Rectangle r) {
            g.drawImage(image, r.x, r.y, r.width, r.height, null);
        }

    private static Image loadImage(String name) {
        String path = null;
        Image image = null;

        try { //where you put code that could fail
            path = "images" + File.separator + name + ".jpg";
            //images/JurassicPark.jpg
            image = ImageIO.read(new File(path));

        } catch(IOException e) {
            System.out.println("Could not load image at path: " + path);
            System.exit(1);

        }

        return image;
    }
    
}
