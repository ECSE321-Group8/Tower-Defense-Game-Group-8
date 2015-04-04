package Crittters2;
import java.util.*;

import Logic.*;
import Logic.Map;


public class Critter implements Runnable{

	private LinkedList<Path> aPath=new LinkedList<Path>();//accesses through the Map

	private int health;
	private int speed;
	private int resistance;
	private int worth;
	
	private int position;
	private int ID;
	
	private Thread t;
	Map m = Map.getInstance();
	
	
	public Critter(int ID){
		setPosition(-1);
		setID(ID);
		setThread();
		setPath();
//		
//		aPath.add(0);
//		aPath.add(1);
//		aPath.add(2);
//		aPath.add(3);
//		aPath.add(4);
//		aPath.add(5);
//		aPath.add(6);
//		aPath.add(7);
//		aPath.add(8);
//		aPath.add(9);
		
	}
	
	//GETTERS
	public int getHealth(){
		return health;
	}
	public int getSpeed(){
		return speed;
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
	public Thread getThread(){
		return t;
	}
	public LinkedList<Path> getPath(){
		return aPath;
	}
	
	
	//SETTERS
	public void setHealth(int n){
		health=n;
	}
	public void setSpeed(int n){
		speed=n;
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
		worth = 2*this.getHealth()+this.getSpeed()+3*this.getResistance();
	}
	public void setThread(){
		t=this.startMoving();
	}
	public void setPath(){
		for (Path p: m.getPath())
			aPath.add(p);
	}
	
	//test
	public String toString(){
		return "health: "+health+", speed: "+speed+", resistance: "+resistance+".";
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
		if(isAlive())
			this.health-=n;
	}
	//critter is hit and is slowed down
	public void critterSlowedDown(int n){
		if(this.getSpeed()>1)//can't have speed zero
			this.speed-=n;
	}
	//critter is hit and loses resistance
	public void critterLosesResistance(int n){
		if(this.getResistance()>1)
			this.resistance-=n;
	}
	
	public void moveAlongPath(LinkedList<Path> path){

		Path i;
		while(!path.isEmpty()){
			i=path.pop();
			this.setPosition(i.getPos());
			try {
			//System.out.println("sleeping");
				Thread.sleep(((long)1)/((long)this.getSpeed()));
			//System.out.println("wake up");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getID()+": "+this.getPosition());
		}
		
		this.setPosition(-1);	//out of bounds
		
	}


	
	@Override
	public void run() {
		//LinkedList<Integer> path = new LinkedList<Integer>();
		for (Path i: m.getPath()){
			aPath.add(i);

		}
		//System.out.println("running");
		moveAlongPath(aPath);
		//System.out.println("done");
		
	}
	
	public Thread startMoving(){
		Thread thread = new Thread (this);
		return thread;
		//thread.start();
	}
		
	
	

	
}
