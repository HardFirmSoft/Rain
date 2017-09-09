package Rain;

import java.awt.Graphics;

public class Splash {
	private int x,y;
	private boolean isRight;
	
	public Splash(int x, int y, boolean right) {
		this.x = x;
		this.y = y;
		this.isRight = right;
		
	}
	
	public void paint(Graphics g) {
			if(isRight == true) {
				g.drawLine(x, y, x+5, y-5);
				x= x + 8;
				y= y - 8;
			}
			else {
				g.drawLine(x,y,x-5,y-5);
				x= x -8;
				y= y -8;
			}
	}
}
