
public class TurnSE extends Path implements IPathActions {

	public TurnSE(int pos, int width) {
		super(pos);
		setParameters(pos);
	}

	public void setParameters(int pos) {
		
		ent = pos + Map.getWidth(); // calculate entrance
		exit = pos + 1; // calculate exit
	}
	
}
