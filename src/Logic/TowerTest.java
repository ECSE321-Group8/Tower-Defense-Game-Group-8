package Logic;


public class TowerTest extends Tower{
	static final int cost = 6;
	
	
	public TowerTest(int x, int y) {
		super();


		//pos=5
		cooldown=20;
		timer=2;
		range=3;
		shotpower=1;
		targetingstrategy=3;
		screenx=x;
		screeny=y;
		upgraded=0;
		g.addMoney(-cost);
		type=5;
		// TODO Auto-generated constructor stub
	}	
	
	
}
