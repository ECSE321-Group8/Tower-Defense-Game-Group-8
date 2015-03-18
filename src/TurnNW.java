
public class TurnNW extends Path implements IPathActions {

	public TurnNW(int pos) {
		super(pos);
		setParameters(pos);
	}

	@Override
	public void setParameters(int pos) {

		ent = pos - Map.getWidth(); // calculate exit
		exit = pos - 1; // calculate exit
		
	}

}
