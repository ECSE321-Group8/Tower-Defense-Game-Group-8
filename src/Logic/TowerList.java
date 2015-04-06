package Logic;

import java.util.ArrayList;


public class TowerList extends ArrayList<Tower> implements IObserver{
	Game g = Game.getInstance();
	ArrayList<int []> buildlog = new ArrayList<int []>();
	
	/**
	 * This is to buy towers
	 * @param type
	 * @param x
	 * @param y
	 */
	public boolean buyTower(int type, int y, int x){
		boolean wasBought = false;
		int [] toAdd = {type,x,y};
		switch(type){
		case 0:
			if (g.getMoney()>=(TowerSniper.cost)){
				buildlog.add(toAdd);
				g.addMoney(-TowerSniper.cost);
				System.out.println("--added sniper to buildlog");
				//buildlog.get(buildlog.size())={1,1,1};
				//this.add(new TowerSniper(x,y));
				wasBought=true;
			}			
			break;
		case 1:
			if (g.getMoney()>=(TowerFast.cost)){
				buildlog.add(toAdd);
				g.addMoney(-TowerFast.cost);
				System.out.println("--added fast to buildlog");
				//this.add(new TowerFast(x,y));
				wasBought=true;
			}			
		break;
		case 2:
			if (g.getMoney()>=(TowerStrong.cost)){
				buildlog.add(toAdd);
				g.addMoney(-TowerStrong.cost);
				System.out.println("--added strong to buildlog");				
				//this.add(new TowerStrong(x,y));
				wasBought=true;
			}			
			break;
		}
		int [] a;
		for (int i = buildlog.size()-1; i >= 0;i--){
			a = buildlog.get(i);
			System.out.println(a[0]);
			System.out.println(a[1]);
			System.out.println(a[2]);			
		}
		System.out.println("--exit buytower");

		
		
		return wasBought;	
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TowerList() {
		// TODO Auto-generated constructor stub
	}
	
	public void sellTower(int i){
		int refund = 0;
		System.out.println("###trying to sell"+i);
		if (this.get(i).isTowerFast()){refund=(int)(0.75*(TowerFast.cost));}
		if (this.get(i).isTowerStrong()){refund=(int)(0.75*(TowerStrong.cost));}
		if (this.get(i).isTowerSniper()){refund=(int)(0.75*(TowerSniper.cost));}
		System.out.println("###selling tower "+i+" for "+refund);
		g.addMoney(refund);
		this.remove(i);
	}	
	public void update(){
		System.out.println("--enter update");
		for(int i=0; i<this.size(); i++){//++to put in gameclock		
			this.get(i).tick();//++to put in gameclock
		}//++t put in gameclock
		this.buildtick();
	}
	
	public Tower getTower(int y, int x){
		System.out.println("trying to select");
		for(int i=0; i<this.size(); i++){
			if(this.get(i).getX() == x){
				if(this.get(i).getY() == y){
					System.out.println("MUCH SELECTING OF TOWER "+i);
					return this.get(i);		
				}
			}
		}
		return null;
	}	

	
	public int getTowerID(int y, int x){
		for(int i=0; i<this.size(); i++){
			if(this.get(i).getX() == x){
				if(this.get(i).getY() == y){
					System.out.println("MUCH SELECTING OF TOWER "+i);
					return i;		
				}
			}
		}
		return -1;
	}	

	
	
	
	public boolean buildtick(){

		int [] a;
		//if(buildlog.size() != 0){
		System.out.println("--enter buildtick "+buildlog.size());//}
		if (buildlog.size() == 0) {return false;}
		for (int i = buildlog.size()-1; i >= 0;i--){
			a = buildlog.get(i);
			switch(a[0]){
			case 0:
				System.out.println("--built a sniper");
				this.add(new TowerSniper(a[1],a[2]));		
				break;
			case 1:
				System.out.println("--built a fast");
				this.add(new TowerFast(a[1],a[2]));		
				break;
			case 2:
				System.out.println("--built a strong");
				this.add(new TowerStrong(a[1],a[2]));		
				break;
			}
			buildlog.remove(i);
		}
		return true;	
	}


}
