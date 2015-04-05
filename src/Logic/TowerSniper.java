package Logic;


public class TowerSniper extends Tower{

	static final int cost = 6;	
	
	public TowerSniper(int x, int y) {
		super();

		//pos=5
		cooldown=4;
		timer=cooldown;
		range=7;
		shotpower=10;
		targetingstrategy=3;
		screenx=x;
		screeny=y;
		upgraded=0;
		g.addMoney(-cost);
		type=0;
		// TODO Auto-generated constructor stub
	}	
	
	
}