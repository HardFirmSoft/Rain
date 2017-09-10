package Rain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel{
	private static int DEFAULT_WIDTH = 750;
	private static int DEFAULT_HEIGHT = 750;
	
	private ArrayList<Drop> drops = new ArrayList<Drop>();
	
	public Panel() {
		createPanel();
		createDrops();
	}
	
	private void createDrops() {
		for(int i=0; i<(this.getWidth()+this.getHeight())/2; i++) {
			int randomX = (int) (Math.random()*(this.getWidth()));
			int randomY = (int) (Math.random()*200);
			int randomV = (int) (Math.random()*10);
			drops.add(new Drop(randomX,randomY,randomV));
			//createRainDrop(i);
		}
	}
	
	private void changeDropsRandom(int i) {
			int randomX = (int) (Math.random()*(this.getWidth()));
			int randomY = (int) (Math.random()*200);
			int randomV = (int) (Math.random()*10);
			drops.set(i,new Drop(randomX,randomY,randomV));
			//createRainDrop(i);
	}
	
	public void createPanel() {
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setBackground(Color.BLACK);
	}
	
	
	@Override
	public void paint(Graphics g) {
		if(drops.size() < (this.getHeight()+this.getWidth())/2) {
			createDrops();
		}else if(drops.size()>(this.getHeight()+this.getWidth())/2) {
			drops.clear();
			createDrops();
		}
		
		for(int i=0;i<drops.size(); i++) {
			
			drops.get(i).paint(g);
			
			if(drops.get(i).y>=this.getHeight()-15) {

				Splash splshLeft = new Splash(drops.get(i).x,drops.get(i).y, false);
				Splash splshRight = new Splash(drops.get(i).x,drops.get(i).y, true);
				splshLeft.paint(g);
				splshRight.paint(g);
			}
			
			if(drops.get(i).y >= this.getHeight() || drops.get(i).x>=this.getWidth()) {
				changeDropsRandom(i);
			}
		}
	}
	
}
