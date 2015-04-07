package Logic;

public abstract class Tower {

	public Tower(){}
	
	//variables
	public static int cost;

//	public int pos;//following grid mechanics
	public int cooldown;//time between shots
	public int timer;//count down timer to next shot
	public int range;
	public int shotpower;
	public int targetingstrategy;//0=low health,1= farthest ,2=closest,3=first,4=last
	public int screenx;
	public int screeny;
	public int upgraded;


	Game g= Game.getInstance();
	
	//public abstract void uprgrade();
	
	
/*	public int getPos(){
		return pos;
	}
	public void setPos(int pos){
		this.pos=pos;
	}*/
	
	public int getCooldown() {
		return cooldown;
	}

	public int getRange() {
		return range;
	}

	public int getShotpower() {
		return shotpower;
	}
	

	public void tick() {		//every gamecycle
		if (timer > 0) {		//the countdown timer goes down (getting ready to shoot)
			timer -= 1;		//if it was already 0 and didn't shoot (no valid targets), it stays ready to shoot
		}
		if (timer == 0){
			if(firesequence()) {  //it shoots, if successful, timer resets, if not, it waits for the next gamecycle
				timer = cooldown;
			}
		}
	}

	public int targeting(){	
		int targetcandidate = -1;
		int distance = 0;
		//System.out.println("--targeting-possible targets"+g.getCritterWave().getCritterInField().size());
		for(int i = 0; i < g.getCritterWave().getCritterInField().size(); i++) {
			if ((g.getCritterWave().getCritterInField().get(i).isAlive())) {
				Critter mycritter = g.getCritterWave().getCritterInField().get(i);
				distance = (int)(Math.pow(mycritter.getPosX() - screenx, 2) + Math.pow(mycritter.getPosY() - screeny, 2));
				if (distance <= (int)Math.pow(range, 2)){
					//System.out.println("in range"+i);
					if (targetcandidate == -1){
						targetcandidate = i;
						//System.out.println("found valid target"+i);
					}
					else{
						switch(targetingstrategy){
							case 0://closest 
								if(distance < (Math.pow(g.getCritterWave().getCritterInField().get(targetcandidate).getPosX()-screenx,2) + Math.pow(g.getCritterWave().getCritterInField().get(targetcandidate).getPosY()-screenx,2))){
									targetcandidate=i;
									//System.out.println("switched to"+i);
								}
							break;
							case 1://farthest 
								if(distance>((g.getCritterWave().getCritterInField().get(targetcandidate).getPosition()-screenx)*(g.getCritterWave().getCritterInField().get(targetcandidate).getPosition()-screenx))+((g.getCritterWave().getCritterInField().get(targetcandidate).getPosition()-screeny)*(g.getCritterWave().getCritterInField().get(targetcandidate).getPosition()-screeny))){
									targetcandidate=i;						
								}
							break;
							case 2://least health 
								if(g.getCritterWave().getCritterInField().get(i).getHealth()<g.getCritterWave().getCritterInField().get(targetcandidate).getHealth()){
									targetcandidate=i;						
								}
							break;
							case 3://most health 
								if(g.getCritterWave().getCritterInField().get(i).getHealth()>g.getCritterWave().getCritterInField().get(targetcandidate).getHealth()){
									targetcandidate=i;						
								}
							break;
							case 4://first
								if(g.getCritterWave().getCritterInField().get(i).getCompletion()>g.getCritterWave().getCritterInField().get(targetcandidate).getCompletion()){
									targetcandidate=i;						
								}
							break;
							case 5://last 
								if(g.getCritterWave().getCritterInField().get(i).getCompletion()<g.getCritterWave().getCritterInField().get(targetcandidate).getCompletion()){
									targetcandidate=i;						
								}
							break;
						}				
					}			
			}
		}}
		
		if(targetcandidate != -1){System.out.println("targeting: "+targetcandidate+" distance of x "+(g.getCritterWave().getCritterInField().get(targetcandidate).getPosX())+" at "+screenx+" "+screeny);}
		return targetcandidate;//returns coordinates of the target
		}
	
	
	public boolean firesequence() {  //things it does when it fires
		int target = targeting();  //assings the target
		if (target == -1) {  //if no valid targets, firesequence fails
			return false;
		} else{
			g.getCritterWave().getCritterInField().get(target).updateHealth(shotpower);
			//System.out.println("--shot"+target);
			return true;
		}
	}
	
	public boolean upgrade(){
		System.out.println("upgrade?money?"+g.getMoney()+"already upgrade?"+upgraded);
		boolean success=false;
		if (g.getMoney()>(cost-30)){
			//System.out.println("money?"+g.getMoney()+"already upgrade?"+upgraded);
			switch(upgraded){
			case 0:
				range +=1;
				success =  true;
				break;
			case 1:
				shotpower += 1;
				success =  true;
				break;
			case 2:
				//cooldown -= 1;
				//if(cooldown<1){cooldown = 1;}
				success =  false;
				break;
			case 3:
				success =  false;
				break;
			}
		}
		if (success){
			upgraded += 1;
			System.out.println("###UPGRADE");
			if (this.isTowerFast()){g.addMoney((int)((-0.5)*(TowerFast.cost)));}
			if (this.isTowerStrong()){g.addMoney((int)((-0.5)*(TowerStrong.cost)));}
			if (this.isTowerSniper()){g.addMoney((int)((-0.5)*(TowerSniper.cost)));}
		}
		return success;
	}
	
	public int getTargetingStrategy(){
		return targetingstrategy;
	}
	
	public void setTargetingStrategy(int n){
		if ((n >= 0)&&(n <= 5)){
			targetingstrategy = n;
			System.out.println("###changed strategy");
			
		}
	}
	
	public int getX(){
		return screenx;
	}
	
	public int getY(){
		return screeny;
	}
	public int getCost(){
		return cost;
	}
	
	
	public boolean isTowerSniper(){
		if(this instanceof TowerSniper){
			return true;
		}
		else
			return false;
	}
	
	public boolean isTowerStrong(){
		if(this instanceof TowerStrong){
			return true;
		}
		else
			return false;
	}
	
	public boolean isTowerFast(){
		if(this instanceof TowerFast){
			return true;
		}
		else
			return false;
	}

	public int getUpgraded() {
		return upgraded;
	}
	
	/*
	 * Method that returns the Row coordinate of the tower
	 */
//	public int getRow(){
//		return (pos/Map.getWidth());
//	}

	/*
	 * Method that returns the Col coordinate of the tower 
	 */
//	public int getCol(){
//		return pos%(Map.getWidth());
//	}
	
}