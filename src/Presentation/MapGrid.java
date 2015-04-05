package Presentation;
import Crittters2.Critter;
import Crittters2.CritterWave;
import Crittters2.Game;
import Crittters2.IObserver;
import Logic.Tower;
import Logic.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logic.Map;
import Logic.Path;
import Logic.Scenery;
import Logic.TowerList;

public class MapGrid extends JPanel implements MouseListener, IObserver{
	
	private int panelWidth,panelHeight, gridRows, gridColumns;
	private int gridSize;
	private boolean startSet;
	private int [][] tempGrid; 
	private int xcor,ycor, xOffset, yOffset;
	private boolean completedView = false;
	private int xpoints[] = new int[3]; // three points for triangles
	private int ypoints[] = new int[3];

	private boolean start = true;
	private boolean playing = false;
	private JPanel myOptions;
	private CardLayout layout;
	private Game myGame;
	private CritterWave myWave;
	private TowerList myTowerList;
	
	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
	
	private Map myMap;
	
	
	public MapGrid(int panelWidth, int panelHeight, JPanel myOptions, CardLayout layout){
		
		startSet = false; // Do not want to paint until the Dimension has been set
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		myMap=Map.getInstance();
		this.myOptions = myOptions;
		this.layout = layout;
		myGame = Game.getInstance();
		// myWave.getListCritters();
		
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
		// drawTowers(g);
		}
	}

	private void drawTowers(Graphics g,int i, int j) {
		// TODO Auto-generated method stub
		// TODO Change the colors according to methods
		//if(false){ // To test; take out if statement after
		//for(int i=0;i<gridRows;i++){
			//for(int j=0;j<gridColumns;j++){
		myTowerList = myGame.getMytowerlist();
				
				//Tower t; // Get the tower object if it exists
				g.setColor(towerBaseColour(myTowerList.getTower(i, j)));
				
				// g.setColor(Color.LIGHT_GRAY);
				g.fillRect(i*gridSize+xOffset+gridSize/8, j*gridSize+yOffset+gridSize/8, 3*gridSize/4, 3*gridSize/4);
				
				g.setColor(towerTypeColour(myTowerList.getTower(i, j)));
				
				g.setColor(Color.RED);
				g.fillOval(i*gridSize+xOffset+gridSize/4, j*gridSize+yOffset+gridSize/4, gridSize/2, gridSize/2);
			//}
		//}
		//}
	}

	private Color towerTypeColour(Tower t) {
		// TODO Auto-generated method stub
		// Would get the type of tower:
		//int towerType=t.getType();
		if(t.isTowerFast()){ // Regular
			return Color.RED;
		}
		else if(t.isTowerSniper()){
			return Color.BLUE;
		}
		else if(t.isTowerStrong()){
			return Color.YELLOW;
		}
		return null;
	}

	private Color towerBaseColour(Tower t) {
		// TODO Auto-generated method stub
		// would get the upgrade level of the towers:
		Tower tempTower;
		if(t.isTowerFast()){
			tempTower = (TowerFast)t;
		}
		else if(t.isTowerSniper()){
			tempTower = (TowerSniper)t;
		}
		else if(t.isTowerStrong()){
			tempTower = (TowerStrong)t;
		}
		int upgradeLevel=t.getUpgraded();
		if(upgradeLevel==0){ // Level 1
			return Color.LIGHT_GRAY;
		}
		else if(upgradeLevel==1){
			return Color.DARK_GRAY;
		}
		else if(upgradeLevel==2){
			return Color.BLACK;
		}
		return null;
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
					Scenery tempScenery = (Scenery)myMap.getGrid(j, i);
					if(tempScenery.isTowerPresent()){
						//drawTowers(g, i, j);
					}
				}
				g.setColor(Color.BLACK);
				g.drawRect(i*gridSize+xOffset, j*gridSize+yOffset, gridSize, gridSize);
			}
		}
		
		drawCritters(g);
		
		// how polygons are drawn
		/*
		int xpoints[] = {0,10,0};
		int ypoints[] = {0,10,20};
		g.drawPolygon(xpoints, ypoints, 3);
		*/
	}
	
	private void drawCritters(Graphics g) {
		// TODO Auto-generated method stub
		myWave = myGame.getCritterWave();
		for(Critter c: myWave.getListCritters()){
			g.setColor(critterColour(c.getID()));
			if(c.getPosition()>=0){
				g.drawOval(c.getPosX()*gridSize+xOffset+gridSize/4,c.getPosY()*gridSize+yOffset+gridSize/4 , gridSize/2, gridSize/2);
			}
			// g.drawOval(0, 0, gridSize/2, gridSize/2);
		}
	}

	private Color critterColour(int id) {
		// TODO Auto-generated method stub
		if(id%3==0){
			return Color.RED;
		}
		else if(id%3==1){
			return Color.WHITE;
		}
		else if(id%3==2){
			return Color.CYAN;
		}
		return null;
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
	
	public void placeTower(){
		Scenery tempScenery = (Scenery)myMap.getGrid(xcor, ycor);
		tempScenery.towerPlaced();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		ycor = e.getX()-xOffset;
		xcor = e.getY()-yOffset;
		// TODO: Catch exception where clicked outside of area
		if(startSet && !playing){
			System.out.println("X: " + e.getX() + "\tY: " + e.getY());
			/*
			 ycor = e.getX()-xOffset;
			 xcor = e.getY()-yOffset;
			*/
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
				
				

			
			myMap.printGrid();
			myMap.printPath();
			System.out.println();
			//add path Tile METHOD
			//delete 
			
			repaint();
			// start = false;
		}
		else{
			System.out.println("In the game mode!");
			xcor = xcor/gridSize;
			ycor = ycor/gridSize;
			if(myMap.getGrid(xcor, ycor).isScenery()){
				Scenery tempScenery = (Scenery)myMap.getGrid(xcor, ycor);
				System.out.println("Is Scenery");
				if(!tempScenery.isTowerPresent()){
					layout.show(myOptions, "Tower Purchase");
				}
				else{
					/*
					System.out.println("Removed Tower");
					tempScenery.towerRemoved();
					repaint();
					*/
					layout.show(myOptions, "Tower");
				}
				setVisible(true);
			}
			else{
				System.out.println("Is Path");
				layout.show(myOptions, "Critter");
			}
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Printing from Game");
		myGame.getMytowerlist().update();
		this.repaint();
		setVisible(true);
	}


}
