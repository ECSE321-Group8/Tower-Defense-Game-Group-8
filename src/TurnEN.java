
public class TurnEN extends Path implements IPathActions {

	public TurnEN(int pos) {
		super(pos);
		setParameters(pos);
	}

	public void setParameters(int pos) {

		ent = pos + 1; // calculate entrance
		exit = pos - Map.getWidth(); // calculate exit
		
	}
	
}
