import java.awt.*;
import java.applet.*;

public class TestApplet extends Applet {

	private Deck test;

	public void init() {
		test = new Deck("card");
	}

	public void paint(Graphics g) {
		test.draw(g, new Rectangle(50, 50, 200, 300));
	}

}
