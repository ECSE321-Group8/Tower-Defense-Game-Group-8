
public class Path extends Tile{
	
	// Will try them as public first then see if can change the variables to private
	public int ent; // Tile from where critter will enter
	public int exit; // Till which the critter will exit
	//public int width; // width of the Map Used to calculate exit/entrance of tile
	public boolean isEdge; // If this tile is an entrance or exit or if it is part of path
	public boolean edgeType; // If it is an entrance or exit
	public boolean visited; // Check if the tile was visited during verification process
	
	/*
	 * How the subclasses of Path or named:
	 * First its the description of the Path
	 * Then, the first capital letter describes where the entrance is from
	 * The second capital letter describes where the exit is
	 * Both the entrance and exit are relative to the current position of the Path 
	 */
	
	//Constructor 
	public Path(int pos/*,int width*/){
		this.pos = pos;
		//this.width = width;
	}
	 	
	public void rotate() { // Rotate piece
		int temp = ent;
		ent = exit;
		exit = temp; 
	}
	

	
	public void setisEdge(){ //setting that there it may be either an entrance or exit
		isEdge = true;
	}
	
	public boolean getisEdge(){ //know if its a regular path or either entrance or exit
		return isEdge;
	}
	
	public void setEntry(){ //setting tile as entry point
		setisEdge();
		edgeType = true;
		ent = pos;
	}
	public int getEntry(){
		return ent;
	}
	

	public void setExit(){ //setting tile as exit point
		setisEdge();
		edgeType = false;
		exit = pos;
	}
	public int getExit(){ // return exit of tile
		return exit;
	}
	
	
//	public boolean getedgeType(){ // getting the boolean which denotes if entry or exit point
//		return edgeType;
//	}
	
	public void setVisited(boolean visited){
		this.visited = visited;
	}
	
	public boolean getVisited(){
		return visited;
	}
	
	
	//Methods to return the col and row of the entry and exit of the Path
	public int getEntryCol(){
		return getCol(this.getEntry());
	}
	public int getEntryRow(){
		return getRow(this.getEntry());
	}
	
	public int getExitCol(){
		return getCol(this.getExit());
	}
	public int getExitRow(){
		return getRow(this.getExit());		
	}
	
	
	
}
