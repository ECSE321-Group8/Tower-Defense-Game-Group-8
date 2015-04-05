package Critters;

public class WaveAlert implements Iobserver {

	public WaveAlert(Game myGame) {
		// TODO Auto-generated constructor stub
		super();
		this.observedGame=myGame;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		int critters=observedGame.getNumberOfCritters();
		System.out.println("New number of Critters"+critters);
	}
	private Game observedGame;
}
