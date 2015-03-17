import java.util.LinkedList;


public class Map {
	
	private Tile grid [][]; // hold the Map path and scenery
	static int height; // height of map
	static int width; // Width of Map
	LinkedList <Path> temp = new LinkedList<Path>(); // List of the Path
	Path entryPoint; // Entry point
	Path exitPoint; // Exit point
	private String heading = ""; // To determine next logical path piece
	
	/*
	 *  //Make the map a singleton 
	 * private static Map myMap= new Map(int height, int width);
	 *
	 * private Map(int height, int width){
	 * 		this.height=height;
	 * 		this.width=width;
	 * 		grid= new Tile[height][width];
	 * }
	 * 
	 * public static Map getInstance(){
	 * 		return myMap;
	 * }
	 * 
	 * //Method to setHeight
	 * //Method to setWidth
	 * //Method to initialize the Grid (I am not sure we need this
	 * //Could be done in the constructor since no variables are needed to be passed)
	 *  
	 * 
	 *	//all other methods included and modified
	 
	 * 
	 */
	
	
	//Constructor 
	public Map(int height, int width){
		
		this.height = height;
		this.width = width;
		grid = new Tile [height][width];
		
	}
	
	public boolean inValidSpot(Path p1){
		// Checks to see it the path piece placed expects an entrance or exit piece out of bounds
		
		int largestRow = (height*width-1)/width;
		
		// if entrance or exit pos expected is negative, know it is expecting a path outside the top bound
		if(p1.getEntrance()<0 || p1.getExit()<0){
			return false;
		}
		// if entrance or exit's row greater than the maximum row, know it is expecting a path outside bottom bound
		if(calculaterow(p1.getEntrance())>largestRow || calculaterow(p1.getExit())>largestRow){
			return false;
		}
		int currentRow = calculaterow(p1.getPos());
		int nextRow=0;
		if(Math.abs(p1.getPos()-p1.getEntrance())==1){
			// If the absolute value of the difference between the current position and its entrance is 1 ...
			// Checking to see if the entrance is expected to be outside of the left or right edges of Map
			nextRow = calculaterow(p1.getEntrance());
			if(currentRow!=nextRow){
				// This means that the entrance expected is not to the left or to the right
				// In other words, the entrance is expected in another row
				return false;
			}
		}
		if(Math.abs(p1.getPos()-p1.getExit())==1){
			// If the absolute value of the difference between the current position and its exit is 1 ...
			// Checking to see if the exit is expected to be outside of the left or right edges of Map
			nextRow = calculaterow(p1.getExit());
			if(currentRow!=nextRow){
				// This means that the exit expected is not to the left or to the right
				// In other words, the exit is expected in another row
				return false;
			}
		}
		if(Math.abs(p1.getPos()-p1.getEntrance())==width){
			nextRow = calculaterow(p1.getEntrance());
			if(p1.getEntrance()<0 || nextRow>(calculaterow(height*width-1))){
				//Less than zero would make it on top of the top edge
				//First term calculated in this manner because any negative entrance between -1 and 
				// -width+1 will have an integer rounded to zero. The double casting will give an 
				// accurate number without losing the sign
				
				//Greater than height*width-1 would make in lower than the bottom edge
				return false;
			}
		}
		if(Math.abs(p1.getPos()-p1.getExit())==width){
			nextRow = calculaterow(p1.getExit());
			if(p1.getEntrance()<0 || nextRow>(calculaterow(height*width-1))){
				return false;
			}
		}
		return true;
		
	}
	
	public boolean connected(Path p1,Path p2){
		// Checks if p1 and p2 are connected
		if(p1.getExit()==p2.getPos()&&p1.getPos()==p2.getEntrance()){
			// If the exit of the first tile is equal to the position of the second tile
			// AND if the entrance of the second tile is equal to the position of the first tile
			return true;
		}
		else{
			return false;
		}
	
	}
	
	/*
	 * WORK ON THESE TWO METHODS TO CREATE 2D array 
	 */
	
	public void addPathPiece(Path p){ 
		// add path p to temp linked list
		temp.add(p);
		
		
	}
	
	public void removePathPiece(Path p){
		// remove path p from temp linked list
		temp.remove(p);
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int calculaterow(int pos){// calculate row index
		return pos/width;
	}
	
	public int calculatecolumn(int pos){// calculate column index
		return pos%width;
	}
	
}
