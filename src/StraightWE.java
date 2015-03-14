
public class StraightWE extends Path implements IPathActions {
	
	public StraightWE(int pos, int width){
		super(pos,width);
		setParameters(pos);
	}

	public void setParameters(int pos) {
		
		ent = pos-1; // calculate entrance
		exit = pos+1; // Calculate exit
		
	}

}
