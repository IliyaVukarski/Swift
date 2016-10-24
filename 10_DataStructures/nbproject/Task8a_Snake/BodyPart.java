package Task8a_Snake;

import java.awt.Color;
import java.awt.Graphics;

public class BodyPart {
	private int xCoor;
	private int yCoor;
	private int width;
	private int height; 
	
	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}

	public BodyPart(int xCoor, int yCoor, int tileSize) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		width = tileSize;
		height = tileSize;
	}
	
	public void tick() {
		
	}
	
	public void draw(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		graphics.drawRect(xCoor * width, yCoor * height, width, height);
		graphics.setColor(Color.GREEN);
		graphics.fillRect(xCoor * width + 2, yCoor * height + 2, width - 2, height - 2);
	}
}
