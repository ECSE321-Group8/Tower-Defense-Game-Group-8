package Presentation;

import Logic.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import Logic.Map;
import Logic.*;

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
	private BufferedImage myGrass;
	private BufferedImage myPath;
	private ImageObserver observer;
	
	/**
	 * This method returns if the Player is in the Game mode or not
	 * @return Returns a boolean. If it is true, Player is in Game Mode
	 */
	public boolean isPlaying() {
		return playing;
	}
	
	/**
	 * This method sets if the Player is in Game Mode or not
	 * @param playing Takes in a boolean; if true, the Player is in Game Mode
	 */
	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
	
	private Map myMap;
	
	/**
	 * The constructor for the MapGrid.
	 * @param panelWidth The real width of the panel; excluding the frame's border
	 * @param panelHeight The real height of the panel; excluding the frame's border
	 * @param myOptions The panel which includes the different layouts on the left side of the SplitPane
	 * @param layout The Layout Manager which allows to switch between the different views in the left side of the SplitPane
	 */
	public MapGrid(int panelWidth, int panelHeight, JPanel myOptions, CardLayout layout){
		
		startSet = false; // Do not want to paint until the Dimension has been set
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		myMap=Map.getInstance();
		this.myOptions = myOptions;
		this.layout = layout;
		myGame = Game.getInstance();
		// myWave.getListCritters();
		
		String path = new File (".").getAbsolutePath();
		String grassPath = path.concat("//Assets//grass.png");
		String pathPath = path.concat("//Assets//path.png");
		try {
			myGrass = ImageIO.read(new File (grassPath));
			myPath = ImageIO.read(new File(pathPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addMouseListener(this);
		
		setVisible(true);
	}
	
	/**
	 * Method paints all the necessary items
	 */
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
	
	/**
	 * Prints all the Tower
	 * @param g The Graphics component
	 * @param i The x coordinate of the Tower
	 * @param j The y coordinate of the Tower
	 */
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
	
	/**
	 * Setting the Colour of the Tower
	 * @param t The tower which needs to be displayed
	 * @return The colour of the Tower depending on the type of Tower
	 */
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
	
	/**
	 * Setting the Colour of the Tower base
	 * @param t The tower which needs to be displayed
	 * @return The colour of the base depending on the type of Tower
	 */
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
	
	/**
	 * Draws all the items which should be on the Map: Map, Critters, and Towers
	 * @param g The Graphics component
	 */
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
//						g.setColor(Color.BLUE);
//						g.fillRect(i*gridSize+xOffset, j*gridSize+yOffset, gridSize, gridSize);
						g.drawImage(myPath, i*gridSize+xOffset, j*gridSize+yOffset,gridSize, gridSize, observer);
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
//					g.setColor(Color.GREEN);
//					g.fillRect(i*gridSize+xOffset, j*gridSize+yOffset, gridSize, gridSize);
					g.drawImage(myGrass, i*gridSize+xOffset, j*gridSize+yOffset,gridSize, gridSize, observer);
					Scenery tempScenery = (Scenery)myMap.getGrid(j, i);
					if(tempScenery.isTowerPresent()){
						// drawTowers(g, i, j);
					}
				}
				if(!completedView){
					g.setColor(Color.BLACK);
					g.drawRect(i*gridSize+xOffset, j*gridSize+yOffset, gridSize, gridSize);
				}
			}
		}
		if(playing){
			drawCritters(g);
		}
		
		
		// how polygons are drawn
		/*
		int xpoints[] = {0,10,0};
		int ypoints[] = {0,10,20};
		g.drawPolygon(xpoints, ypoints, 3);
		*/
	}
	
	/**
	 * Draws all the Critters
	 * @param g The Critter Component
	 */
	private void drawCritters(Graphics g) {
		// TODO Auto-generated method stub
		myWave = myGame.getCritterWave();
		for(Critter c: myWave.getListCritters()){
			g.setColor(critterColour(c.getID()));
			if(c.getPosition()>=0){
				g.fillOval(c.getPosX()*gridSize+xOffset+gridSize/4,c.getPosY()*gridSize+yOffset+gridSize/4 , gridSize/2, gridSize/2);
			}
			// g.drawOval(0, 0, gridSize/2, gridSize/2);
		}
	}
	
	/**
	 * Selecting the colour of the Critter depending on its Type 
	 * @param id Used to determine the Type of the Critter
	 * @return Colour of the Critter depending on its Type
	 */
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
	
	/**
	 * Draws an arrow to show the direction of the Path
	 * @param exitPoint Integer which shows which direction the Path is going in
	 * @param icoor The x coordinate of the Path
	 * @param jcoor The y coordinate of the Path
	 * @param g The Graphics component
	 */
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
		// g.setColor(Color.WHITE); // Always set a color before drawing
		float[] triangleColour = new float[3];
		triangleColour = Color.RGBtoHSB(198, 99, 0, new float[3]);
		g.setColor(Color.getHSBColor(triangleColour[0], triangleColour[1], triangleColour[2]));
		g.drawPolygon(xpoints, ypoints, 3);
	}
	
	/**
	 * To see if the Map has been completed or if the Player is in the Game Mode; both situations set True. If the map is being edited, set False
	 * @param completedView If the Map is done editing
	 */
	public void setCompletedView(boolean completedView) {
		this.completedView = completedView;
	}
	
	/**
	 * Get the x coordinate of the the Map Grid
	 * @return The x coordinate of the Map Grid
	 */
	public int getXcor() {
		return xcor;
	}
	
	/**
	 * Set the x coordinate of the Map Grid to avoid errors
	 * @param xcor Taking the current x coordinate
	 */
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
	
	/**
	 * Get the y coordinate of the the Map Grid
	 * @return The y coordinate of the Map Grid
	 */
	public int getYcor() {
		return ycor;
	}
	
	/**
	 * Set the y coordinate of the Map Grid to avoid errors
	 * @param ycor Taking the current y coordinate
	 */
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
	
	/**
	 * Sets the Grid of the Map grid to a certain value; for Testing
	 * @param x The x coordinate of the grid
	 * @param y The y coordinate of the grid
	 * @param value The type of Tile of the Grid
	 */
	public void setGrid(int x, int y, int value){
		tempGrid[x][y]= value;
		
	}
	
	/**
	 * Place the Tower in the Map
	 */
	public void placeTower(){
		Scenery tempScenery = (Scenery)myMap.getGrid(xcor, ycor);
		tempScenery.towerPlaced();
		// repaint();
	}
	
	/**
	 * Creating events to place the Path in the Editing Mode.
	 * If in the Game Mode, allowing user to receive Critter information of to place or edit Towers
	 */
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
			
			//TODO Might have to move this
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
	/**
	 * Set the Dimensions of the tempGrid for the GridView
	 * @param gridRows Number of Rows in the Map
	 * @param gridColumns Number of Columns in the Map
	 */
	public void setDimensions(int gridRows, int gridColumns){
		this.gridRows = gridRows;
		this.gridColumns = gridColumns;
		tempGrid = new int[gridRows][gridColumns];
		startSet = true;
		repaint();
	}
	
	/**
	 * Painting any update from the Map by Observing the Game
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
//		System.out.println("Printing from Game");
		myGame.getMytowerlist().update();
		this.repaint();
		setVisible(true);
	}


}
