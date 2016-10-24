package Task8a_Snake;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class Frame extends JFrame{
	public Frame() {
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setTitle("Snake");
		super.setResizable(false);
		init();
	}
	
	public void init() {
		super.setLayout(new GridLayout(1, 1, 0, 0));
		Screen screen = new Screen();
		super.add(screen);
		super.pack();
		super.setLocationRelativeTo(null);
		super.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Frame();
	}
}
