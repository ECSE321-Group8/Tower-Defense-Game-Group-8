package Critters;

public class MoneyAlert implements Iobserver {
	public MoneyAlert(Game myGame) {
		super();
		this.observedGame=myGame;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		double newMoney=observedGame.getMoney();
		System.out.println("newMoney"+newMoney);

	}
	private Game observedGame;
	
}
