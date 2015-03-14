
public class StraightNS extends Path implements IPathActions {

	public StraightNS(int pos, int width) {
		super(pos, width);
		setParameters(pos);
	}

	@Override
	public void setParameters(int pos) {

		ent = pos - width; // calculate entrance
		exit = pos + width; // calculate exit
		
	}

}
