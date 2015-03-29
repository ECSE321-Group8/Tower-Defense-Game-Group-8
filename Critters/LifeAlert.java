
public class LifeAlert implements Iobserver {
	
	public LifeAlert(Game myGame) {
		super();
		this.observedGame=myGame;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		int newLife=observedGame.getLife();
		System.out.println("newLife"+newLife);

	}
	private Game observedGame;
	
}
