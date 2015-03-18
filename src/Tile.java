
public abstract class Tile {
	
	public int pos;
	
	public int getPos(){
		
		return pos;
		
	}
	
	/*
	 * Method that returns the Row coordinate of a Tile
	 */
	public int getRow(){
		return (pos/Map.getWidth());
	}
	public int getRow(int n){
		return (n/Map.getWidth());
	}
	

	/*
	 * Method that returns the Col coordinate of the Tile 
	 */
	public int getCol(){
		return pos%(Map.getWidth());
	}
	public int getCol(int n){
		return n%(Map.getWidth());
	}
	
	
	public boolean isPath(){
		if (this instanceof Path)
			return true;
		else
			return false;
	}
}
