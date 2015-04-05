package Logic;

public class TowerFast extends Tower{
	static final int cost = 6;
	
	
	public TowerFast(int x, int y) {
		super();


		//pos=5
		cooldown=3;
		timer=cooldown;
		range=10;
		shotpower=10;
		targetingstrategy=5;
		screenx=x;
		screeny=y;
		upgraded=0;
		g.addMoney(-cost);
		type=1;
		// TODO Auto-generated constructor stub
	}	
	
	
}