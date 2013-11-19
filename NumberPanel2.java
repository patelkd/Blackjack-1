import javax.swing.*;
import java.awt.event.*;

import java.awt.*;



public class NumberPanel extends JPanel implements ActionListener, MouseListener {

	private JLabel label;
	private JButton add, subtract;
	private int value = 0;

	
	public NumberPanel() {
		super();

		label = new JLabel(value+"");
		label.setFont(new Font("sansserif", Font.BOLD, 32));
		this.add(label);

		String title = "+1";
		add = new JButton(title);
		add.setActionCommand(title);
		add.addActionListener(this);
		this.add(add);

		title = "-1";
		subtract = new JButton(title);
		subtract.setActionCommand(title);
		subtract.addActionListener(this);
		this.add(subtract);

		this.addMouseListener(this);

	}
	public void actionPerformed(ActionEvent ae) {
		//action command to tell which button is clicked
		if ("+1".equals(ae.getActionCommand())) { //getActionCommand could be null
			value++;
			label.setText(value+"");
			repaint();
		} else if ("-1".equals(ae.getActionCommand())) {
			value--;
			label.setText(value+"");
			repaint();
		}
	}

	public void mousePressed(MouseEvent e) {
		value++;
		label.setText(value+"");
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		value++;
		label.setText(value+"");
		repaint();
	}

	public void mouseEntered(MouseEvent e) {
		value++;
		label.setText(value+"");
		repaint();
	}

	public void mouseExited(MouseEvent e) {
		value++;
		label.setText(value+"");
		repaint();
	}

	public void mouseClicked(MouseEvent e) {
		
	}

}






















