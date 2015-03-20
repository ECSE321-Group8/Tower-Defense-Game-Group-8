import java.util.LinkedList;


public class Map {
	
	private Tile grid [][]; // hold the Map path and scenery
	private static int height; // height of map
	private static int width; // Width of Map
	
	//private?
	LinkedList <Path> temp = new LinkedList<Path>(); // List of the Path
	Path entryPoint; // Entry point
	Path exitPoint; // Exit point
	private String heading = ""; // To determine next logical path piece
	
/*
 * Make map a singleton
 */
	private static Map instanceMap=null;
	
	private Map(){
	}
	
	public static Map getInstance(){
		if(instanceMap==null)
			instanceMap=new Map();
		return instanceMap;
	}
	//SETTERS 
	public void setMap(int h, int w){
		height=h;
		width=w;
		grid=new Tile[height][width];
	}
	
	//GETTERS
	public int getHeight(){
		return height;
	}
	
	public static int getWidth(){
		return width;
	}	
	
	//GRID
//	public void setGrid(int y, int x, Tile k){
//		grid[y][x]=k;
//	}
//	
//	public Tile getGrid(int y, int x){
//		return grid[y][x];
//	}
	
	public void setCellToPath(int pos){
		Path p = new Path(pos);
		grid[p.getRow()][p.getCol()]= p;
		temp.add(p);
	}
	
	public void setCellToScenery(int pos){
		Scenery s = new Scenery(pos);
		grid[s.getRow()][s.getCol()]=s;
		
	}
	
	//not sure if we need this
	public void setCellToNull(int pos){
		Empty t = new Empty(pos);
		grid[t.getRow()][t.getCol()]=t;
	}
	
	//TESTS
	public boolean inValidSpot(Path p1){
		// Checks to see it the path piece placed expects an entrance or exit piece out of bounds
		
		int largestRow = (height*width-1)/width;
		
		// if entrance or exit pos expected is negative, know it is expecting a path outside the top bound
		if(p1.getEntry()<0 || p1.getExit()<0){
			return false;
		}
		// if entrance or exit's row greater than the maximum row, know it is expecting a path outside bottom bound
		if(p1.getEntryRow()>largestRow || p1.getExitRow()>largestRow){
			return false;
		}
		int currentRow = p1.getRow();
		int nextRow=0;
		if(Math.abs(p1.getPos()-p1.getEntry())==1){
			// If the absolute value of the difference between the current position and its entrance is 1 ...
			// Checking to see if the entrance is expected to be outside of the left or right edges of Map
			nextRow = p1.getEntryRow();
			if(currentRow!=nextRow){
				// This means that the entrance expected is not to the left or to the right
				// In other words, the entrance is expected in another row
				return false;
			}
		}
		if(Math.abs(p1.getPos()-p1.getExit())==1){
			// If the absolute value of the difference between the current position and its exit is 1 ...
			// Checking to see if the exit is expected to be outside of the left or right edges of Map
			nextRow = p1.getExitRow();
			if(currentRow!=nextRow){
				// This means that the exit expected is not to the left or to the right
				// In other words, the exit is expected in another row
				return false;
			}
		}
		if(Math.abs(p1.getPos()-p1.getEntry())==width){
			nextRow = p1.getEntryRow();
			if(p1.getEntry()<0 || nextRow>(height-1/width)){//it used to be calculaterow(height*width-1
				//Less than zero would make it on top of the top edge
				//First term calculated in this manner because any negative entrance between -1 and 
				// -width+1 will have an integer rounded to zero. The double casting will give an 
				// accurate number without losing the sign
				
				//Greater than height*width-1 would make in lower than the bottom edge
				return false;
			}
		}
		if(Math.abs(p1.getPos()-p1.getExit())==width){
			nextRow = p1.getExitRow();
			if(p1.getEntry()<0 || nextRow>(height-1/width)){//it used to be calculaterow(height*width-1
				return false;
			}
		}
		return true;
		
	}
	
	public boolean connected(Path p1,Path p2){
		// Checks if p1 and p2 are connected
		if(p1.getExit()==p2.getPos()&&p1.getPos()==p2.getEntry())
			// If the exit of the first tile is equal to the position of the second tile
			// AND if the entrance of the second tile is equal to the position of the first tile
			return true;
		else
			return false;	
	}
	
	/*
	 * WORK ON THESE TWO METHODS TO CREATE 2D array 
	 */
	
	public void addPathPiece(Path p){ 
		temp.add(p); //Add to linked list 	
	}
	
	public void removePathPiece(Path p){
		temp.remove(p); //Remove from linked list
	}
	
	
	//PATH FACTORY
	public static PathType createPathTileOfType(int s, int e){
		//N=0, E=1, S=2, W=3
		int type; 
		if ((s==0&&e==1)||(s==1&&e==0))
			type= 0;//NE
		else if ((s==0&&e==2)||(s==2&&e==0))
			type=1;//NS
		else if ((s==0&&e==3)||(s==3&&e==0))
			type = 2;//NW
		else if ((s==1&&e==2)||(s==2&&e==1))
			type = 3;//SE
		else if ((s==1&&e==3)||(s==3&&e==1))
			type=4;//WE
		else if ((s==2&&e==3)||(s==3&&e==2))
			type= 5;//SW
		else 
			type= -1;//error 

		switch(type){
		case 0:
			return PathType.turnEN;
		case 1:
			return PathType.straightNS;
		case 2:
			return PathType.turnNW;
		case 3:
			return PathType.turnSE;
		case 4:
			return PathType.straightWE;
		case 5:
			return PathType.turnWS;
		default:
			return PathType.straightNS;//error
		}
	}	
}
