package Logic;


public class TowerRegular extends Tower{
	static final int cost = 6;
	
	
	public TowerRegular(int x, int y) {
		super();

		//pos=5
		cooldown=25;
		timer=cooldown;
		range=3;
		shotpower=2;
		targetingstrategy=3;
		screenx=x;
		screeny=y;
		upgraded=0;
		g.addMoney(-cost);
		type=3;
		// TODO Auto-generated constructor stub
	}	
	
	
}