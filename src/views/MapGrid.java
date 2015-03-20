package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MapGrid extends JPanel implements MouseListener{
	
	private int panelWidth,panelHeight, gridRows, gridColumns;
	private int gridSize;
	private boolean startSet;
	private int [][] tempGrid; 
	private int xcor,ycor;

	private boolean start = true;
	
	public MapGrid(int panelWidth, int panelHeight, int gridRows, int gridColumns){
		// this.setLayout(new BorderLayout());
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		this.gridRows = gridRows;
		this.gridColumns = gridColumns;
		// addKeyListener(this);
		addMouseListener(this);
		
		tempGrid = new int[gridRows][gridColumns];
		
		repaint();
		setVisible(true);
		System.out.println(this.getWidth());
		System.out.println(this.getHeight());
	}
	
	public void paintComponent(Graphics g){
		
		// Works for a square sized Window
		if(panelHeight/gridRows>=panelWidth/gridColumns){
			gridSize = panelWidth/gridColumns;
		}
		else{
			gridSize = panelHeight/gridRows;
		}
		
		drawGrid(g);
		
	}

	private void drawGrid(Graphics g) {
		// TODO Auto-generated method stub
		
		g.clearRect(0, 0, getWidth(), getHeight()); // Clear the screen
		
		for(int i=0;i<gridColumns;i++){
			for(int j=0;j<gridRows;j++){
				// g.drawRect(i*gridSize, j*gridSize, gridSize, gridSize);
				
				if(tempGrid[j][i]==0){
					
					g.setColor(Color.GRAY);
					g.fillRect(i*gridSize, j*gridSize, gridSize, gridSize);

				}
				else{
					g.setColor(Color.PINK);
					g.fillRect(i*gridSize, j*gridSize, gridSize, gridSize);
				}
				g.setColor(Color.BLACK);
				g.drawRect(i*gridSize, j*gridSize, gridSize, gridSize);
			}
		}
	}
	
	public int getXcor() {
		return xcor;
	}

	public void setXcor(int xcor) {
		this.xcor = xcor;
	}

	public int getYcor() {
		return ycor;
	}

	public void setYcor(int ycor) {
		this.ycor = ycor;
	}
	
	public void setGrid(int x, int y, int value){
		tempGrid[x][y]= value;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(start){ // For the start piece; can only make one
			System.out.println("X: " + e.getX() + "\tY: " + e.getY());
			ycor = e.getX();
			xcor = e.getY();
			tempGrid[xcor/gridSize][ycor/gridSize] = 1;
			xcor = xcor/gridSize;
			ycor = ycor/gridSize;
			repaint();
			start = false;
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		System.out.println("key code = " + keyCode
                + " ("
                + KeyEvent.getKeyText(keyCode)
                + ")");
		if(e.getKeyCode() == 38){
			System.out.println("Pressed Up!");
			xcor = xcor-1;
			tempGrid[xcor][ycor] = 1;
			repaint();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		System.out.println("key code = " + keyCode
                + " ("
                + KeyEvent.getKeyText(keyCode)
                + ")");
	}
	*/
	

}
