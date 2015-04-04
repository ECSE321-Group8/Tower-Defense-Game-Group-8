package Logic;

import java.util.ArrayList;

import Critters.Game;

public class TowerList extends ArrayList<Tower>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TowerList() {
		// TODO Auto-generated constructor stub
	}
	
	public void sellTower(int i){
		Game.myMoney.changeMoney((this.get(i).getCost())-20);
		this.remove(i);
	}	
}
