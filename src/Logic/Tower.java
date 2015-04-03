package Logic;

import Critters.wave;

public abstract class Tower {

	//variables
	public static int cost;
	private int pos;//following grid mechanics
	private int cooldown;//time between shots
	public int timer;//countdown timer to next shot
	private int range;
	private int shotpower;
	private boolean freezedmg;//does this tower slow down critters or damage them?
	public int targetingstrategy;//0=lowhealth,1=furhtes,2=closest,3=first,4=last
	private int screenx;
	private int screeny;
	private int clip;
	
	
	public abstract void uprgrade();
	
	
	public int getPos(){
		return pos;
	}
	public void setPos(int pos){
		this.pos=pos;
	}
	
	public void tick(){		//every gamecycle
		if (timer>0){		//the countdown timer goes down (getting ready to shoot)
			timer-=1;		//if it was already 0 and didn't shoot (no valid targets), it stays ready to shoot
		}
		if (timer==0){
			
			for(int i=0;i<clip;i++){
				if(firesequence()==true){//it shoots, if successful, timer resets, if not, it waits for the next gamecycle
					timer=cooldown;
				}

			}
		
		}
	}
	
		
	public int targeting(){	
		int targetcandidate = -1;
		int distance;
		for(int i=0;i<=wave.getWavelist().size();i++){
			if(wave.getWavelist().get(i).alive()){
			distance=((wave.getWavelist().get(i).positionX-screenx)*(wave.getWavelist().get(i).positionX-screenx))+((wave.getWavelist().get(i).positionY-screeny)*(wave.getWavelist().get(i).positionY-screenx));
			if (distance<=(range*range)){
				if (targetcandidate==-1){
					targetcandidate=i;				
				}
				else{
					switch(targetingstrategy){
						case 0://closest 
							if(distance<((wave.getWavelist().get(targetcandidate).positionX-screenx)*(wave.getWavelist().get(targetcandidate).positionX-screenx))+((wave.getWavelist().get(targetcandidate).positionY-screeny)*(wave.getWavelist().get(targetcandidate).positionY-screeny))){
								targetcandidate=i;						
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
		return targetcandidate;//returns coordinates of the target
		}
	
	
	public boolean firesequence(){//things it does when it fires

		
		int target=targeting();//assings the target
		if (target==-1){//if no valid targets, firesequence fails
			return false;
		}
		else{
			
			if (freezedmg){
				critter[target].setspeed(shotpower);
			}
			else{
				critter[target].updateHealth(shotpower);
			}
				
			return true;
			
		}
		
		
	}
	
	
	/*
	 * Method that returns the Row coordinate of the tower
	 */
	public int getRow(){
		return (pos/Map.getWidth());
	}

	/*
	 * Method that returns the Col coordinate of the tower 
	 */
	public int getCol(){
		return pos%(Map.getWidth());
	}
	
}