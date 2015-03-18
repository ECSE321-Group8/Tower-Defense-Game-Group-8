
public class TurnWS extends Path implements IPathActions{

	public TurnWS(int pos) {
		super(pos);
		setParameters(pos);
	}

	public void setParameters(int pos) {
		
		ent = pos -1; // calculate entrance
		exit = pos + Map.getWidth(); // calculate exit
		
	}
	
	
}
