package Task8_Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.Console;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;
	
	private Graphics2D g2d;
	private BufferedImage image;
	
	private Thread thread;
	private boolean running;
	private long targetTime;
	
	private final int SIZE = 10;
	private Entity head;
	private Entity apple; 
	private ArrayList<Entity> snake;
	private int score;
	private int level;
	private boolean gameOver;
	
	private int dx;
	private int dy;
	private boolean up;
	private boolean down;
	private boolean right;
	private boolean left;
	private boolean start;
	
	public GamePanel() {
		super.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		super.setFocusable(true);
		super.requestFocus();
		super.addKeyListener(this);
	}
	
	public void addNotify() {
		super.addNotify();
		thread = new Thread(this);
		thread.start();
	}
	
	private void setFPS(int fps) {
		targetTime = 1000 / fps;
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		if(key == KeyEvent.VK_UP) {
			up = true;
		}
		if(key == KeyEvent.VK_DOWN) {
			down = true;
		}
		if(key == KeyEvent.VK_LEFT) {
			left = true;
		}
		if(key == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if(key == KeyEvent.VK_ENTER) {
			start = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		int key = event.getKeyCode();
		if(key == KeyEvent.VK_UP) {
			up = false;
		}
		if(key == KeyEvent.VK_DOWN) {
			down = false;
		}
		if(key == KeyEvent.VK_LEFT) {
			left = false;
		}
		if(key == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if(key == KeyEvent.VK_ENTER) {
			start = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent event) {
		
	}

	@Override
	public void run() {
		if(running) {
			return;
		}
		init();
		long startTime;
		long elapsed;
		long wait;
		while(running) {
			startTime = System.nanoTime();
			update();
			requestRender();
			elapsed = System.nanoTime() - startTime;
			wait = targetTime - elapsed / 1000000;
			if(wait > 0) {
				try {
					Thread.sleep(wait);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	public void init() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		g2d = image.createGraphics();
		running = true;
		setUplevel();
			
		
	}
	
	private void setUplevel() {
		snake = new ArrayList<Entity>(); 
		head = new Entity(SIZE);
		head.setPosition(WIDTH / 2, HEIGHT / 2);
		snake.add(head); 
		for(int index = 1; index < 3; index++) {
			Entity entity  = new Entity(SIZE);
			entity.setPosition(head.getX() + (index * SIZE), head.getY());
			snake.add(entity); 
		}
		
		apple = new Entity(SIZE);
		setApple();
		score = 0;
		gameOver = false;
		level = 1;
		dx = dy = 0;
		setFPS(level * 10);
	}
	
	public void setApple() {
		int x = (int) (Math.random() * (WIDTH - SIZE));
		int y = (int) (Math.random() * (HEIGHT - SIZE));
		x = x - (x % SIZE);
		y = y - (y % SIZE);
		
		apple.setPosition(x, y);
	}
	private void requestRender() {
		render(g2d);
		Graphics graphics = getGraphics();
		graphics.drawImage(image, 0, 0, null);
		graphics.dispose();
	}
	
	private void update() {
		
		if(gameOver) {
			if(start) {
				setUplevel();
			}
			return;
		}
		if(up && dy == 0) {
			dy = -SIZE;
			dx = 0;
		}
		if(down && dy == 0) {
			dy = SIZE;
			dx = 0;
		}
		if(left && dx == 0) {
			dy = 0;
			dx = -SIZE;
		}
		if(right && dx == 0 && dy != 0) {
			dy = 0;
			dx = SIZE;
		}
		
		if(dx != 0 || dy != 0) {
			for(int index = snake.size() - 1; index > 0; index--) {
				snake.get(index).setPosition(
						snake.get(index - 1).getX(), 
						snake.get(index - 1).getY()
				);
			}
			
			head.move(dx, dy);
		} 
		
		for(Entity entity : snake) {
			if(entity.isCollsion(head)) {
				gameOver = true;
				break;
			}
		}
		
		if(apple.isCollsion(head)) {
			score++;
			setApple();
			
			Entity entity  = new Entity(SIZE);
			entity.setPosition(-100, -100);
			snake.add(entity);
			if(score % 10 == 0) {
				level++;
				if(level > 10) {
					level = 10;
					setFPS(level * 10);
				}
			}
		}
		
		if(head.getX() < 0) {
			head.setX(WIDTH);
		}
		
		if(head.getY() < 0) {
			head.setY(HEIGHT);
		}
		
		if(head.getX() > WIDTH) {
			head.setX(0);
		}
		
		if(head.getY() > HEIGHT) {
			head.setY(0);
		}
	}
	
	public void render(Graphics2D g2d) {
		g2d.clearRect(0, 0, WIDTH, HEIGHT);
		g2d.setColor(Color.GREEN);
		for(Entity entity : snake) {
			entity.render(g2d);
		}
		g2d.setColor(Color.RED);
		apple.render(g2d);
		
		if(gameOver) {
			g2d.drawString("GameOver!", 150, 200);
		}
		
		g2d.setColor(Color.WHITE);
		g2d.drawString("Score: " + score + "Level : " + level, 10, 10);
		
		if(dx == 0 && dy == 0) {
			g2d.drawString("Ready!", 150,200);
		}
		
		
	}

}
