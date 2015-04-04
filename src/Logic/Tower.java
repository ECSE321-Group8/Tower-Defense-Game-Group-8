package Logic;

import Critters.wave;
import Critters.critter;


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
	public int clip;
	
	
	//public abstract void uprgrade();
	
	
/*	public int getPos(){
		return pos;
	}
	public void setPos(int pos){
		this.pos=pos;
	}*/
	
	public void tick() {		//every gamecycle
		if (timer > 0) {		//the countdown timer goes down (getting ready to shoot)
			timer -= 1;		//if it was already 0 and didn't shoot (no valid targets), it stays ready to shoot
		}
		if (timer == 0){
			for(int i = 0; i < clip; i++) {
				if(firesequence()) {  //it shoots, if successful, timer resets, if not, it waits for the next gamecycle
					timer = cooldown;
				}
			}
		}
	}

	public int targeting(){	
		int targetcandidate = -1;
		int distance = 0;
		System.out.println("--targeting-possible targets"+wave.getWavelist().size());
		for(int i = 0; i < wave.getWavelist().size(); i++) {
			if (wave.getWavelist().get(i).alive()) {
				critter mycritter = wave.getWavelist().get(i);
				distance = (int)(Math.pow(mycritter.positionX - screenx, 2) + Math.pow(mycritter.positionY - screeny, 2));
				if (distance <= (int)Math.pow(range, 2)){
					if (targetcandidate == -1){
						targetcandidate = i;
						System.out.println("found valid target"+i);
					}
					else{
						switch(targetingstrategy){
							case 0://closest 
								if(distance < (Math.pow(wave.getWavelist().get(targetcandidate).positionX-screenx,2) + Math.pow(wave.getWavelist().get(targetcandidate).positionX-screenx,2))){
									targetcandidate=i;
									System.out.println("switched to"+i);
								}
							break;
							case 1://farthest 
								if(distance>((wave.getWavelist().get(targetcandidate).positionX-screenx)*(wave.getWavelist().get(targetcandidate).positionX-screenx))+((wave.getWavelist().get(targetcandidate).positionY-screeny)*(wave.getWavelist().get(targetcandidate).positionY-screeny))){
									targetcandidate=i;						
								}
							break;
							case 2://least health 
								if(wave.getWavelist().get(i).health<wave.getWavelist().get(targetcandidate).health){
									targetcandidate=i;						
								}
							break;
							case 3://most health 
								if(wave.getWavelist().get(i).health>wave.getWavelist().get(targetcandidate).health){
									targetcandidate=i;						
								}
							break;
		/*					case 4://first
								if(getcritteriprogress>getcrittertargetprogress){
									targetcandidate=i;						
								}
							case 5://last 
								if(getcritterihealth<getcrittertargethealth){
									targetcandidate=i;						
								}
							break;*/
						}				
					}			
			}
		}}
		System.out.println("targeting: "+targetcandidate);
		return targetcandidate;//returns coordinates of the target
		}
	
	
	public boolean firesequence() {  //things it does when it fires
		int target = targeting();  //assings the target
		if (target == -1) {  //if no valid targets, firesequence fails
			return false;
		} else{
			wave.getWavelist().get(target).updateHealth(shotpower);				
			return true;
		}
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