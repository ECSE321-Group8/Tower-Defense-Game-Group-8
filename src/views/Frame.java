package views;

/*
 * Classes Related to this example
 * Screen.java
 * Room.java
 */

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame implements KeyListener{

	final static String APPNAME = "FRAME!";
	public static Dimension size = new Dimension (1000,550);
	private MapGrid mG;
	// Try to add this to the layout:
	// http://docs.oracle.com/javase/tutorial/uiswing/components/splitpane.html
	
	
	public Frame(){
		setTitle(APPNAME);
		setSize(size);
		// setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel blankPanel = new JPanel();
		int sizeofSplit = 200;
		
		addKeyListener(this); // Does not work in the JPanel
		System.out.println(this.getWidth());
		System.out.println(this.getHeight());
		setVisible(true);
		// Not this gets the the size of the actual frame (without borders)
		mG = new MapGrid(this.getContentPane().getSize().width-sizeofSplit,this.getContentPane().getSize().height,10,20);
		// TODO: Need to make left side grid of Map and right side where we set size of map and other options
		// Can only have this after panels initialized
		SplitPane sP = new SplitPane(blankPanel,mG,sizeofSplit);
		// add(mG);
		add(sP);
		
		/*
		 * Doesn't work
		Dimension size = mG.getSize();
		System.out.println(size.width);
		System.out.println(size.height);
		*/
		init();
		
	}
	
	public static void main (String args []){
		Frame frame = new Frame();
	}
	
	public void init(){
		setVisible(true);
		// This must always happen after the setVisible has been activated as true or else it will be zero
		// http://stackoverflow.com/questions/13474795/get-the-real-size-of-a-jframe-content
		Dimension actualSize = this.getContentPane().getSize();
		System.out.println("Here " + actualSize.width);
		System.out.println(actualSize.height);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("Pressed Key!");
		
		// Link for KeyCodes: http://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
		
		// Must create cases not going back to an already colored part of grid
		// Need to also know if first piece was added or not
		if(e.getKeyCode() == KeyEvent.VK_UP){
			mG.setXcor(mG.getXcor()-1);
			mG.setGrid(mG.getXcor(), mG.getYcor(), 1);
			mG.repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			mG.setXcor(mG.getXcor()+1);
			mG.setGrid(mG.getXcor(), mG.getYcor(), 1);
			mG.repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			mG.setYcor(mG.getYcor()-1);
			mG.setGrid(mG.getXcor(), mG.getYcor(), 1);
			mG.repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			mG.setYcor(mG.getYcor()+1);
			mG.setGrid(mG.getXcor(), mG.getYcor(), 1);
			mG.repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			System.out.println("BACKSPACE!");
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
