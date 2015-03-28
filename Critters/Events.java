
public class Events implements Iobserver {

	public Events(Game observedGame) {
		super();
		this.observedGame=observedGame;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("stuff happenning");
		int recentlife = observedGame.getMyLife();
		
		System.out.println("newlife="+recentlife);
	}
	private Game observedGame;
}
