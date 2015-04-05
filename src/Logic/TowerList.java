package Logic;

import java.util.ArrayList;

import Crittters2.*;

public class TowerList extends ArrayList<Tower>{
	Game g = Game.getInstance();
	ArrayList<int []> buildlog = new ArrayList<int []>();
	
	public void buyTower(int type, int x, int y){
		int [] toAdd = {type,x,y};
		switch(type){
		case 0:
			if (g.getMoney()>(TowerSniper.cost)){
				buildlog.add(toAdd);
				//buildlog.get(buildlog.size())={1,1,1};
				this.add(new TowerSniper(x,y));
			}			
			break;
		case 1:
			if (g.getMoney()>(TowerFast.cost)){
				buildlog.add(toAdd);
				this.add(new TowerFast(x,y));
			}			
		break;
		case 2:
			if (g.getMoney()>(TowerStrong.cost)){
				buildlog.add(toAdd);
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
		this.buildtick();
	}
	
	public Tower getTower(int x, int y){
		for(int i=0; i<this.size(); i++){
			if(this.get(i).getX() == x){
				if(this.get(i).getY() == y){
					return this.get(i);		
				}
			}
		}
		return null;
	}	

	public void buildtick(){
		int [] a;
		for (int i = buildlog.size()-1; i >= 0;i--){
			a = buildlog.get(i);
			switch(a[0]){
			case 0:
				this.add(new TowerSniper(a[1],a[2]));		
				break;
			case 1:
				this.add(new TowerFast(a[1],a[2]));		
				break;
			case 2:
				this.add(new TowerStrong(a[1],a[2]));		
				break;
			}
			buildlog.remove(i);
		}
			
	}


}
