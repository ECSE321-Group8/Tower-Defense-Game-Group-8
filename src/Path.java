		
public class Path extends Tile{
	
	
	//privacy of the attributes might change 
	//Attributes of the tile itself
	public int entry;
	public int exit;
	
	
	//Validate
	public boolean isEdge;//entry or exit of the Path
	public boolean isStart;//or isExit
	public boolean isVisited;

	/*
	 * How the subclasses of Path or named:
	 * First its the description of the Path
	 * Then, the first capital letter describes where the entrance is from
	 * The second capital letter describes where the exit is
	 * Both the entrance and exit are relative to the current position of the Path 
	 */
	
	//Constructor 
	public Path(int pos){
		this.pos=pos;	
		isVisited=false;
	}
	 	
	
	public void rotate(){
		int temp=entry;
		entry =exit;
		exit = temp;
	}
	
	
	//SETTERS
	public void setIsEdge(){//either Star or End
		isEdge=true;
	}
	public void setStart(){
		setIsEdge();
		isStart = true;
		entry = pos;
	}
	public void setEnd(){
		setIsEdge();
		isStart=false;
		exit=pos;
	}
	public void setVisited(boolean visited){
		isVisited = visited;
	}
	
	
	//GETTERS
	public boolean getIsEdge(){
		return isEdge;
	}
	public int getEntry(){
		return entry;
	}
	public int getExit(){
		return exit;
	}
	public boolean getVisited(){
		return isVisited;
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
		
	
	//Get position of the tiles connected
	public int getNorth(){
		return pos-Map.getWidth();
	}
	public int getSouth(){
		return pos+Map.getWidth();
	}
	public int getWest(){
		return pos-1;
	}
	public int getEast(){
		return pos+1;
	}

	
	
}
