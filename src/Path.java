
public class Path extends Tile{
	
	// Will try them as public first then see if can change the variables to private
	public int ent; // Tile from where critter will enter
	public int exit; // Till which the critter will exit
	public int width; // width of the Map Used to calculate exit/entrance of tile
	public boolean isEdge; // If this tile is an entrance or exit or if it is part of path
	public boolean edgeType; // If it is an entrance or exit
	public boolean visited; // Check if the tile was visited during verification process
	
	//Constructor 
	public Path(int pos,int width){
		this.pos = pos;
		this.width = width;
	}
	
	public void rotate() { // Rotate piece
		int temp = ent;
		ent = exit;
		exit = temp; 
	}
	
	public int getEntrance(){ // return entrance of tile
		return ent;
	}
	
	public int getExit(){ // return exit of tile
		return exit;
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
	
	public void setExit(){ //setting tile as exit point
		setisEdge();
		edgeType = false;
		exit = pos;
	}
	
	public boolean getedgeType(){ // getting the boolean which denotes if entry or exit point
		return edgeType;
	}
	
	public void setVisited(boolean visited){
		this.visited = visited;
	}
	
	public boolean getVisited(){
		return visited;
	}

}
