package Logic;

public class TowerFast extends Tower{
	static final int cost = 6;
	
	
	public TowerFast(int x, int y) {
		super();


		//pos=5
		cooldown=15;
		timer=cooldown;
		range=1;
		shotpower=1;
		targetingstrategy=3;
		screenx=x;
		screeny=y;
		upgraded=0;
		g.addMoney(-cost);
		// TODO Auto-generated constructor stub
	}	
	
	
}