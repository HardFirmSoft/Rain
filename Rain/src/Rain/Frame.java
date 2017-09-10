package Rain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Frame extends JFrame implements ActionListener {
	private int DEFAULT_HEIGHT = 750;
	private int DEFAULT_WIDTH = 750;
	
	private Panel Panel = new Panel();
	private Timer timer = new Timer(30, null);
	
	public Frame() {
		timer.addActionListener(this);
		initializeFrame();
	}
	
	public void initializeFrame() {
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Rain");
		this.setBackground(Color.BLACK);
		this.setResizable(true);
		
		this.setContentPane(Panel);
		
		this.setVisible(true);
	}
	
	public void start() {
		timer.start();
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(),this.getHeight());
		g.setColor(Color.WHITE);
		Panel.paint(g);
	}
	
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
	public static void main(String [] args) {
		Frame frame = new Frame();
		
		frame.start();
	}
}
