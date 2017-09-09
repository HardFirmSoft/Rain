package Rain;

import java.awt.Graphics;

public class Drop {
	protected int velocity;
	protected  int x, y;
	protected int l = 8;
	
	//constructor for the RainDrop
	public Drop(int x, int y, int velocity) {
		this.velocity = velocity;
		this.x= x;
		this.y= y;
	}
	
	
	public void paint(Graphics g) {
		g.drawLine(x, y, x, y+l);
		//x= x+length+velocity;
		y= y+l+velocity;
	}
}
