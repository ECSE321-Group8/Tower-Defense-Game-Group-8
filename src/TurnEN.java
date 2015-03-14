
public class TurnEN extends Path implements IPathActions {

	public TurnEN(int pos, int width) {
		super(pos, width);
		setParameters(pos);
	}

	public void setParameters(int pos) {

		ent = pos + 1; // calculate entrance
		exit = pos - width; // calculate exit
		
	}
	
}
