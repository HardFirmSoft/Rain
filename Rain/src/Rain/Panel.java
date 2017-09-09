package Rain;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel{
	private static int DEFAULT_WIDTH = 750;
	private static int DEFAULT_HEIGHT = 750;
	
	private Drop[] drops = new Drop[500];
	
	public Panel() {
		createDrops();
		createPanel();
	}
	
	private void createRainDrop(int i) {
		int randomX = (int) (Math.random()*(this.getWidth()));
		int randomY = (int) (Math.random()*200);
		int randomV = (int) (Math.random()*10);
		drops[i] = new Drop(randomX,randomY,randomV);
	}
	
	private void createDrops() {
		for(int i=0; i<drops.length; i++) {
			createRainDrop(i);
		}
	}
	
	
	public void createPanel() {
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setBackground(Color.BLACK);
	}
	
	@Override
	public void paint(Graphics g) {
		
		for(int i=0;i<drops.length; i++) {
			
			drops[i].paint(g);
			
			if(drops[i].y>=this.getHeight()-20) {

				Splash splshLeft = new Splash(drops[i].x,drops[i].y, false);
				Splash splshRight = new Splash(drops[i].x,drops[i].y, true);
				splshLeft.paint(g);
				splshRight.paint(g);
			}
			if(drops[i].y >= this.getHeight() || drops[i].x>=this.getWidth()) {
				createRainDrop(i);
				
			}
		}
	}
	
}
