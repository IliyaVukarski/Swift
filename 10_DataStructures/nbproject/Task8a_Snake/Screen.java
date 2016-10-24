package Task8a_Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	private Thread thread;
	private boolean running = false;
	private BodyPart bodyPart;
	private ArrayList<BodyPart> snake;
	private Apple apple;
	private ArrayList<Apple> apples;
	private Random random;
	private int xCoor = 10;
	private int yCoor = 10;
	private int size = 5;
	private boolean right = true;
	private boolean left = false;
	private boolean up = false;
	private boolean down = false;
	
	private int ticks = 0;
	private Key key;
	public Screen() {
		super.setFocusable(true);
		key = new Key();
		super.addKeyListener(key);
		super.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		random = new Random();
		snake = new ArrayList<BodyPart>();
		apples = new ArrayList<>();
		start();
	}
	
	public void tick() {
		if(snake.size() == 0) {
			bodyPart = new BodyPart(xCoor, yCoor, 10);
			snake.add(bodyPart);
		}
		
		if(apples.size() == 0) {
			int xCoor = random.nextInt(79);
			int yCoor = random.nextInt(79);
			apple = new Apple(xCoor, yCoor, 10);
			apples.add(apple);
		}
		for(int index = 0; index < apples.size(); index++) {
			if(xCoor == apples.get(index).getxCoor() && yCoor == apples.get(index).getyCoor()) {
				size++;
				apples.remove(index);
				index--;
			}
		}
		
		for(int index = 0; index < snake.size(); index++) {
			if(xCoor == snake.get(index).getxCoor() && yCoor == snake.get(index).getyCoor()) {
				if(index != snake.size() -1) {
					stop();
				}
			}
		}
		
		if(xCoor < 0 || xCoor > 79 || yCoor < 0 || yCoor > 79) {
			stop();
		}
		
		ticks++;
		if(ticks > 250000) {
			if(right) {
				xCoor++;
			}
			if(left) {
				xCoor--;
			}
			if(up) {
				yCoor--;
			}
			if(down) {
				yCoor++; 
			}
			
			ticks = 0;
			
			bodyPart = new BodyPart(xCoor, yCoor, 10);
			snake.add(bodyPart);
			
			if(snake.size() >size) {
				snake.remove(0);
			}
		}
	}
	
	
	public void paint(Graphics graphics) {
		graphics.clearRect(0, 0, WIDTH, HEIGHT);
		graphics.setColor(Color.BLACK);
		for(int index = 0; index < WIDTH / 10; index++) {
			graphics.drawLine(index * 10, 0, index * 10, HEIGHT);
		}
		for(int index = 0; index < HEIGHT / 10; index++) {
			graphics.drawLine(0, index * 10, WIDTH, index * 10);
		}
		
		for(int index = 0; index < snake.size(); index++) {
			snake.get(index).draw(graphics);
		}
		
		for(int index = 0; index < apples.size(); index++) {
			apples.get(index).draw(graphics);
		}
	}
	
	public void start() {
		running = true;
		thread = new Thread(this, "Game loop");
		thread.start();
		
	}
	
	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(running) {
			tick();
			repaint();
		}
	}
	
	private class Key implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			int key = event.getKeyCode();
			if(key == KeyEvent.VK_RIGHT && !left) {
				up = false;
				down = false;
				right = true;
			}
			if(key == KeyEvent.VK_LEFT && !right) {
				up = false;
				down = false;
				left = true;
			}
			if(key == KeyEvent.VK_UP && !down) {
				left = false;
				right = false;
				up = true;
			}
			if(key == KeyEvent.VK_DOWN && !up) {
				left = false;
				right = false;
				down = true;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
