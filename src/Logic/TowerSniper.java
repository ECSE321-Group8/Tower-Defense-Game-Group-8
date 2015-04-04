package Logic;


public class TowerSniper extends Tower{

	static final int cost = 8;	
	
	public TowerSniper(int x, int y) {
		super();

		//pos=5
		cooldown=30;
		timer=cooldown;
		range=6;
		shotpower=1;
		targetingstrategy=3;
		screenx=x;
		screeny=y;
		upgraded=0;
		g.addMoney(-cost);
		// TODO Auto-generated constructor stub
	}	
	
	
}