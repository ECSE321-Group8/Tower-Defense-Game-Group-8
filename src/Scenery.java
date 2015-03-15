
public class Scenery extends Tile{
	
	
	private boolean towerPresent;
	
	public Scenery(int pos){
		this.pos = pos;	
		towerPresent=false;
	}
	
	public boolean isTowerPresent(){
		return towerPresent;
	}
	
	public boolean towerPlaced(){
		if(!isTowerPresent()){//if there are no towers 
			towerPresent=true;// a tower is placed 
			return true;
		}
		else//there is already a tower there 
			return false;
	}	

}
