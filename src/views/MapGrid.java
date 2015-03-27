package views;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		if(xcor<0){
			this.xcor=0;
		}
		else if(xcor>=gridRows){
			this.xcor = gridRows-1;
		}
		else{
			this.xcor = xcor;
		}
	}

	public int getYcor() {
		return ycor;
	}

	public void setYcor(int ycor) {
		if(ycor<0){
			this.ycor = 0;
		}
		else if(ycor>=gridColumns){
			this.ycor = gridColumns-1;
		}
		else{
			this.ycor = ycor;
		}
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
	

}
