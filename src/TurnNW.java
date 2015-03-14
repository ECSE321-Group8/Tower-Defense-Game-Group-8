
public class TurnNW extends Path implements IPathActions {

	public TurnNW(int pos, int width) {
		super(pos, width);
		setParameters(pos);
	}

	@Override
	public void setParameters(int pos) {

		ent = pos + width; // calculate exit
		exit = pos + 1; // calculate exit
		
	}

}
