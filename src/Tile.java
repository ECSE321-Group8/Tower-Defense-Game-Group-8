
public abstract class Tile {
	
	public int pos;
	
	public int getPos(){
		
		return pos;
		
	}
	
	/*
	 * Method that returns the Row coordinate of the Tile
	 */
	public int getRow(int pos){
		return (pos/Map.width);
	}
	
	/*
	 * Method that returns the Col coordinate of the Tile 
	 */
	public int getCol(int pos){
		return pos%(Map.width);
	}
	
}
