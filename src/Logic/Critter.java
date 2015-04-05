package Logic;
import java.util.*;

import Logic.*;
import Logic.Map;


public class Critter {


	private LinkedList<Path> aPath=new LinkedList<Path>();//accesses through the Map

	private int health;
	private int waitingTime;//speed
	private int resistance;
	private int worth;
	
	private int position;
	private int ID;
	private int timer=0;
	
	private int posX;
	private int posY;
	private int completion=0; 
	
	
//	private Thread t;
	Map m = Map.getInstance();

	
	
	public Critter(int ID){
		setPosition(-1);
		setID(ID);
		aPath=m.getPath();
	}
	
	//GETTERS
	public int getHealth(){
		return health;
	}
	public int getWaitingTime(){
		return waitingTime;
	}
	public int getResistance(){
		return resistance;
	}
	public int getPosition(){
		return position;
	}
	public int getID(){
		return ID;
	}
	public int getWorth(){
		return worth;
	}
	public int getCompletion(){
		return completion;
	}
	public LinkedList<Path> getPath(){
		return aPath;
	}
	public int getTimer(){
		return timer;
	}
	public int getPosX(){
		return position%Map.getWidth();			
	}
	public int getPosY(){
		return position/Map.getWidth();
	}
	
	
	//SETTERS
	public void setHealth(int n){
		health=n;
	}
	public void setWaitingTime(int n){
		waitingTime=n;
	}
	public void setResistance(int n){
		resistance=n;
	}
	public void setPosition(int n){
		position=n;
	}
	public void setID(int n){
		ID=n;
	}
	public void setWorth(){
		worth = 2*this.getHealth()+this.getWaitingTime()+3*this.getResistance();
	}
	public void setTimer(int n ){
		timer = n;
	}
	
		
	//test
	public String toString(){
		return "health: "+health+", waiting time: "+waitingTime+", resistance: "+resistance+".";
	}
	
	//check if it is still alive
	public boolean isAlive(){
		if(health<=0)
			return false;
		else
			return true;
	}
	
	//critter is hit and loses health 
	public void critterLosesHealth(int n){
		if(isAlive()){
			this.health-=n;}
		if (this.health < 0){this.health = 0;}
	}
	public void updateHealth(int damage){
		this.health=this.health-damage;
		if (this.health < 0){this.health = 0;}
		System.out.println("--target at "+this.health+" hp");
	}
	
	//critter is hit and is slowed down
	public void critterSlowedDown(int n){
		if(this.getWaitingTime()+n<0)//can't have speed zero
			return;
		else 
			this.waitingTime+=n;
	}
	//critter is hit and loses resistance
	public void critterLosesResistance(int n){
		if(this.getResistance()>1)
			this.resistance-=n;
	}
	
	public void tick(){
		System.out.println(this.getID()+": "+this.getPosition()+" at "+this.health+" hp");
		if (timer > 0)
			timer -=1;
		else if (timer==0){
			moveToNext();
			timer = waitingTime;
		}
		else 
			return;
			
	}
	

	
	public boolean moveToNext(){
		Path p;
		
		if (completion<aPath.size()){
			p = aPath.get(completion);
			setPosition(p.getPos());
			completion++;
			return true;
		}
		else 
			return false;
	}
	
	
	
	
	
	

	


		
	
	

	
}
