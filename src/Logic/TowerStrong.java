package Logic;

import Critters.Game;

public class TowerStrong extends Tower{

	static final int cost=10;	
	
	public TowerStrong(int x, int y) {
		super();


		//pos=5
		cooldown=30;
		timer=cooldown;
		range=1;
		shotpower=4;
		targetingstrategy=3;
		screenx=x;
		screeny=y;
		upgraded=0;
		Game.myMoney.changeMoney(-cost);
		// TODO Auto-generated constructor stub
	}	
	
	
}