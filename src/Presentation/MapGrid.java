package Presentation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logic.Map;

public class MapGrid extends JPanel implements MouseListener{
	
	private int panelWidth,panelHeight, gridRows, gridColumns;
	private int gridSize;
	private boolean startSet;
	private int [][] tempGrid; 
	private int xcor,ycor, xOffset, yOffset;
	
	private boolean start = true;
	
	private Map myMap;
	
	
	public MapGrid(int panelWidth, int panelHeight){
		
		startSet = false; // Do not want to paint until the Dimension has been set
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		myMap=Map.getInstance();
		
		addMouseListener(this);
		
		setVisible(true);
	}

	public void paintComponent(Graphics g){
		
		
		if(startSet){
		// Works for a square sized Window
		if(panelHeight/gridRows>=panelWidth/gridColumns){
			gridSize = panelWidth/gridColumns;
		}
		else{
			gridSize = panelHeight/gridRows;
		}
		xOffset = (panelWidth - gridSize*gridColumns)/2;
		yOffset = (panelHeight - gridSize*gridRows)/2;
		
		drawGrid(g);
		}
	}

	private void drawGrid(Graphics g) {
		// TODO Auto-generated method stub
		
		g.clearRect(0, 0, getWidth(), getHeight()); // Clear the screen
		
		for(int i=0;i<gridColumns;i++){
			for(int j=0;j<gridRows;j++){
				// g.drawRect(i*gridSize, j*gridSize, gridSize, gridSize);
				//MAP GRID (LOGIC)
				if(myMap.getGrid(j, i)==null){
					
					g.setColor(Color.WHITE);
					g.fillRect(i*gridSize+xOffset, j*gridSize+yOffset, gridSize, gridSize);

				}
				else if(myMap.getGrid(j, i).isPath()){
					g.setColor(Color.BLUE);
					g.fillRect(i*gridSize+xOffset, j*gridSize+yOffset, gridSize, gridSize);
				}
				else{
					g.setColor(Color.GREEN);
					g.fillRect(i*gridSize+xOffset, j*gridSize+yOffset, gridSize, gridSize);
				}
				g.setColor(Color.BLACK);
				g.drawRect(i*gridSize+xOffset, j*gridSize+yOffset, gridSize, gridSize);
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
			
		// TODO: Catch exception where clicked outside of area
		if(startSet){
			System.out.println("X: " + e.getX() + "\tY: " + e.getY());
			ycor = e.getX()-xOffset;
			xcor = e.getY()-yOffset;
			tempGrid[xcor/gridSize][ycor/gridSize] = 1;
			xcor = xcor/gridSize;
			ycor = ycor/gridSize;
			
			//X AND Y COORDINATE ARE INVERTED!!! 
			//Y=WIDTH and X=HEIGHT

			if (myMap.getGrid(xcor,ycor)==null)//||myMap.getGrid(ycor, xcor).isScenery())
				myMap.setCellToPath(xcor*Map.getWidth()+ycor);
			else if(myMap.getGrid(xcor, ycor).isPath())
					myMap.deleteLastPathTile();
			else	{
				
			}		

			
			myMap.printGrid();
			myMap.printPath();
			System.out.println();
			//add path Tile METHOD
			//delete 
			
			repaint();
			// start = false;
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
	
	public void setDimensions(int gridRows, int gridColumns){
		this.gridRows = gridRows;
		this.gridColumns = gridColumns;
		tempGrid = new int[gridRows][gridColumns];
		myMap.setMap(gridRows, gridColumns);
		startSet = true;
		repaint();
	}


}
