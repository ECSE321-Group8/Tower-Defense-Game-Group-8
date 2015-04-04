package Logic;

import Critters.Game;

public class TowerRegular extends Tower{

	
	
	public TowerRegular(int x, int y) {
		super();
		cost=5;

		//pos=5
		cooldown=25;
		timer=cooldown;
		range=3;
		shotpower=2;
		targetingstrategy=3;
		screenx=x;
		screeny=y;
		upgraded=0;
		Game.myMoney.changeMoney(-cost);
		// TODO Auto-generated constructor stub
	}	
	
	
}