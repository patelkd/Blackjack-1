import java.awt.*;
import java.applet.*;

import java.awt.event.*;

import javax.swing.*;

public class MoviePosterApplet extends Applet implements ActionListener{

	private MoviePoster poster;


	private JLabel label;

	private JButton add, subtract;

	private int value = 0;

	public void init() {
		//poster = new MoviePoster("Jurassic Park");
		//
		NumberPanel np = new NumberPanel();
		this.add(np);

		NumberPanel np1 = new NumberPanel();
		this.add(np1);
	}

	public void actionPerformed(ActionEvent ae) {

	}

	public void paint(Graphics g) {
		super.paint(g);

		//poster.draw(g, new Rectangle(50, 50, 200, 300));
	}


}
