package Logic;

import java.util.ArrayList;

import Critters.Game;

public class TowerList extends ArrayList<Tower>{

	
	public void buyTower(int n, int x, int y){
		switch(n){
		case 0:
			if (Game.myMoney.getMoney()>(TowerSniper.cost)){
				this.add(new TowerSniper(x,y));
			}			
			break;
		case 1:
			if (Game.myMoney.getMoney()>(TowerFast.cost)){
				this.add(new TowerFast(x,y));
			}			
		break;
		case 2:
			if (Game.myMoney.getMoney()>(TowerStrong.cost)){
				this.add(new TowerStrong(x,y));
			}			
			break;
		}
		return;	
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TowerList() {
		// TODO Auto-generated constructor stub
	}
	
	public void sellTower(int i){
		Game.myMoney.changeMoney(((int)(this.get(i).getCost())*0.75));
		this.remove(i);
	}	
	public void update(){
		for(int i=0; i<this.size(); i++){//++to put in gameclock		
			this.get(i).tick();//++to put in gameclock
		}//++t put in gameclock
	}
	
	
}
