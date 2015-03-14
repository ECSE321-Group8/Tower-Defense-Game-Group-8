
public class TurnSE extends Path implements IPathActions {

	public TurnSE(int pos, int width) {
		super(pos, width);
		setParameters(pos);
	}

	public void setParameters(int pos) {
		
		ent = pos - width; // calculate entrance
		exit = pos - 1; // calculate exit
	}
	
}
