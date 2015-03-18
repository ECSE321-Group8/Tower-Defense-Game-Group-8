
public class StraightNS extends Path implements IPathActions {

	public StraightNS(int pos) {
		super(pos);
		setParameters(pos);
	}

	@Override
	public void setParameters(int pos) {

		ent = pos - Map.getWidth(); // calculate entrance
		exit = pos + Map.getWidth(); // calculate exit
		
	}

}
