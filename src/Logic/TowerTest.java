package Logic;

import Critters.Game;

public class TowerTest extends Tower{

	
	
	public TowerTest(int x, int y) {
		super();
		cost=5;

		//pos=5
		cooldown=2;
		timer=2;
		range=3;
		shotpower=1;
		targetingstrategy=3;
		screenx=x;
		screeny=y;
		clip=1;
		Game.myMoney.changeMoney(-cost);
		// TODO Auto-generated constructor stub
	}	
	
	
}
