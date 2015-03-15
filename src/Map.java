import java.util.LinkedList;


public class Map {
	
	private Tile grid [][]; // hold the Map path and scenery
	private int height; // height of map
	private int width; // Width of Map
	LinkedList <Path> temp = new LinkedList<Path>(); // List of the Path
	Path entryPoint; // Entry point
	Path exitPoint; // Exit point
	private String heading = ""; // To determine next logical path piece
	
	public Map(int height, int width){
		
		this.height = height;
		this.width = width;
		grid = new Tile [height][width];
		
	}
	
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
