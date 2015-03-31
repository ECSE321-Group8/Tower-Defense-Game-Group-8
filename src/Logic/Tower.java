package Logic;

public abstract class Tower {

	//variables
	public static int cost;
	private int pos;//following grid mechanics
	private int cooldown;//time between shots
	public int timer;//countdown timer to next shot
	private int range;
	private int shotpower;
	private int shotaoe;//size of explosion
	private boolean freezedmg;//does this tower slow down critters or damage them?
	public int targetingstrategy;//0=lowhealth,1=furhtes,2=closest,3=first,4=last
	
	public int getPos(){
		return pos;
	}
	public void setPos(int pos){
		this.pos=pos;
	}
	
	public void tick(){		//every gamecycle
		if (timer!=0){		//the countdown timer goes down (getting ready to shoot)
			timer-=1;		//if it was already 0 and didn't shoot (no valid targets), it stays ready to shoot
		}
		if (timer==0){		//if its ready
			if(firesequence()==true){//it shoots, if successful, timer resets, if not, it waits for the next gamecycle
				timer=cooldown;
			}
		}
		
		
		
	}
	
	private int[][]findlowhealth(int targetlist[][]){ //this goes through the list of possible enemies and picks the one with he lowest health
		for(int i =0;i<=targetlist.length;i++){
			for(int j=i+1;i<=targetlist.length;j++){
				if (targetlist[i][4]<targetlist[j][4]){
					targetlist[j][0]=-1;
				}
				if (targetlist[i][4]>targetlist[j][4]){
					targetlist[i][0]=-1;
				}
			}
			
		}
		
		return targetlist;
	}
	

	private int[][]findfirst(int targetlist[][]){ //this goes through the list of possible enemies and picks the one with he lowest health
		for(int i =0;i<=targetlist.length;i++){
			for(int j=i+1;i<=targetlist.length;j++){
				if (targetlist[i][3]>targetlist[j][3]){
					targetlist[j][0]=-1;
				}
				if (targetlist[i][3]<targetlist[j][3]){
					targetlist[i][0]=-1;
				}
			}
			
		}
		
		return targetlist;
	}
	
	
	private int[][]findlast(int targetlist[][]){ //this goes through the list of possible enemies and picks the one with he lowest health
		for(int i =0;i<=targetlist.length;i++){
			for(int j=i+1;i<=targetlist.length;j++){
				if (targetlist[i][3]<targetlist[j][3]){
					targetlist[j][0]=-1;
				}
				if (targetlist[i][3]>targetlist[j][3]){
					targetlist[i][0]=-1;
				}
			}
			
		}
		
		return targetlist;
	}
	
	
	
	private int[] targeting(){		//this functions imports the list of enemies, filters out the ones not in range, then picks one depending on targeting strategy chosen
		int possibletargets[][]={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};//import critterlist
		int[] targetcoord={-1,-1};
		switch(targetingstrategy){
			case 0: possibletargets=findlowhealth(possibletargets);
					break;
		/*	case 1: possibletargets=findfurthest(possibletargets);
					break;
			case 2: possibletargets=findclosest(possibletargets);     //not done yet
					break;*/
			case 3: possibletargets=findfirst(possibletargets);
					break;
			case 4: possibletargets=findlast(possibletargets);
					break;	
		}
		for(int i=0;i<=possibletargets.length; i++){
			if(possibletargets[i][1]!=-1){//-flags non-targets
				targetcoord[0] = possibletargets[i][2];
				targetcoord[1] = possibletargets[i][3];
				}//finds the one that the picker marked
			}
		
		
		return targetcoord;//returns coordinates of the target
	}
	
	
	public boolean firesequence(){//things it does when it fires
		int target[]=targeting();//assings the target
		if (target[0]==-1){//if no valid targets, firesequence fails
			return false;
		}
		else{
			shoot(target,getCol(),getRow());
			
			return true;
			
		}	
	}
	
	
	public void shoot(int[] target, int x, int y){
		
		
	}
	/*
	 * Method that returns the Row coordinate of the tower
	 */
	public int getRow(){
		return (pos/Map.getWidth());
	}
	public int getRow(int n){
		return (n/Map.getWidth());
	}
	

	/*
	 * Method that returns the Col coordinate of the tower 
	 */
	public int getCol(){
		return pos%(Map.getWidth());
	}
	public int getCol(int n){
		return n%(Map.getWidth());
	}
	
	
}
