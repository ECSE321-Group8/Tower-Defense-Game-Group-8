package Logic;

import java.util.ArrayList;

import Crittters2.*;

public class TowerList extends ArrayList<Tower>{
	Game g = Game.getInstance();
	
	
	public void buyTower(int n, int x, int y){
		switch(n){
		case 0:
			if (g.getMoney()>(TowerSniper.cost)){
				this.add(new TowerSniper(x,y));
			}			
			break;
		case 1:
			if (g.getMoney()>(TowerFast.cost)){
				this.add(new TowerFast(x,y));
			}			
		break;
		case 2:
			if (g.getMoney()>(TowerStrong.cost)){
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
		g.addMoney((int)(this.get(i).getCost()*0.75));
		this.remove(i);
	}	
	public void update(){
		for(int i=0; i<this.size(); i++){//++to put in gameclock		
			this.get(i).tick();//++to put in gameclock
		}//++t put in gameclock
	}
	
	public void upgradeat(int x, int y){
		for(int i=0; i<this.size(); i++){
			if(this.get(i).getX() == x){
				if(this.get(i).getY() == y){
					this.get(i).upgrade();		
				}
			}
		}
	}	
}
