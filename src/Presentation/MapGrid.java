package Presentation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logic.Map;
import Logic.Path;

public class MapGrid extends JPanel implements MouseListener{
	
	private int panelWidth,panelHeight, gridRows, gridColumns;
	private int gridSize;
	private boolean startSet;
	private int [][] tempGrid; 
	private int xcor,ycor, xOffset, yOffset;
	private boolean completedView = false;
	private int xpoints[] = new int[3]; // three points for triangles
	private int ypoints[] = new int[3];
	
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
		Path tempPath;
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
					tempPath = (Path)myMap.getGrid(j, i);
					if(tempPath.getPos()!=myMap.getCurrentPos()||completedView){
						g.setColor(Color.BLUE);
						g.fillRect(i*gridSize+xOffset, j*gridSize+yOffset, gridSize, gridSize);
						// drawTriangle(3, i, j, g); // Testing to see if each case works
						drawTriangle(tempPath.getDirection(tempPath.getExit()), i, j, g); // Drawing triangle to show direction of path
						// http://forum.processing.org/one/topic/the-opposite-of-a-color.html
						// Link for complementary color calculation
					}
					else{
						// To show the current position of the path
						g.setColor(Color.YELLOW);
						g.fillRect(i*gridSize+xOffset, j*gridSize+yOffset, gridSize, gridSize);
					}
				}
				else{
					g.setColor(Color.GREEN);
					g.fillRect(i*gridSize+xOffset, j*gridSize+yOffset, gridSize, gridSize);
				}
				g.setColor(Color.BLACK);
				g.drawRect(i*gridSize+xOffset, j*gridSize+yOffset, gridSize, gridSize);
			}
		}
		
		// how polygons are drawn
		/*
		int xpoints[] = {0,10,0};
		int ypoints[] = {0,10,20};
		g.drawPolygon(xpoints, ypoints, 3);
		*/
	}
	
	public void drawTriangle(int exitPoint, int icoor, int jcoor, Graphics g){
		switch(exitPoint){
			// North
			case 0:
				xpoints[0] = icoor*gridSize+xOffset+(gridSize)/4;
				ypoints[0] = jcoor*gridSize+yOffset+3*(gridSize)/4;
				xpoints[1] = xpoints[0] + gridSize/4;
				ypoints[1] = ypoints[0] - gridSize/2;
				xpoints[2] = xpoints[1] + gridSize/4;
				ypoints[2] = ypoints[0];
				break;
			// East
			case 1:
				xpoints[0] = icoor*gridSize+xOffset+(gridSize)/4;
				ypoints[0] = jcoor*gridSize+yOffset+(gridSize)/4;
				xpoints[1] = xpoints[0] + gridSize/2;
				ypoints[1] = ypoints[0] + gridSize/4;
				xpoints[2] = xpoints[0];
				ypoints[2] = ypoints[1] + gridSize/4;
				break;
			// South
			case 2:
				xpoints[0] = icoor*gridSize+xOffset+(gridSize)/4;
				ypoints[0] = jcoor*gridSize+yOffset+(gridSize)/4;
				xpoints[1] = xpoints[0] + gridSize/2;
				ypoints[1] = ypoints[0];
				xpoints[2] = xpoints[0] + gridSize/4;
				ypoints[2] = ypoints[0] + gridSize/2;
				break;
			// West (Enter correct logic)
			case 3:
				xpoints[0] = icoor*gridSize+xOffset+3*(gridSize)/4;
				ypoints[0] = jcoor*gridSize+yOffset+(gridSize)/4;
				xpoints[1] = xpoints[0];
				ypoints[1] = ypoints[0] + gridSize/2;
				xpoints[2] = xpoints[0] - gridSize/2;
				ypoints[2] = ypoints[0] + gridSize/4;
				break;
			default:
				break;
		}
		/*
		for(int i=0;i<xpoints.length;i++){
			System.out.println(xpoints[i]+ " " + ypoints[i]);
		}
		*/
		g.setColor(Color.BLACK); // Always set a color before drawing
		g.drawPolygon(xpoints, ypoints, 3);
	}
	
	
	public void setCompletedView(boolean completedView) {
		this.completedView = completedView;
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
			else if(myMap.getGrid(xcor, ycor).isPath()){
				myMap.deleteLastPathTile();
				setCompletedView(false);
			}
				
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
	
	
	// TODO Need to change the way dimensions are taken;
	// Different case for when we open a file or a new map
	public void setDimensions(int gridRows, int gridColumns){
		this.gridRows = gridRows;
		this.gridColumns = gridColumns;
		tempGrid = new int[gridRows][gridColumns];
		startSet = true;
		repaint();
	}


}
