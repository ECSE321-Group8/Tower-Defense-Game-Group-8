package Crittters2;
import java.util.*;


public class Critter implements Runnable{

	private int health;
	private int speed;
	private int resistance;
	private int worth;
	private int Speeddmg=0;
	private int position;
	private int ID;
	
	public Critter(int ID){
		setPosition(-1);
		setID(ID);
		aPath.add(0);
		aPath.add(1);
		aPath.add(2);
		aPath.add(3);
		aPath.add(4);
		aPath.add(5);
		aPath.add(6);
		aPath.add(7);
		aPath.add(8);
		aPath.add(9);
		
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
	public int getSpeeddmg(){
		return Speeddmg;
	}	
	
	//SETTERS
	public void setHealth(int n){
		health=n;
	}
	public void reduceHealth(int n){
		health-=n;
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
	public void addSpeeddmg(int n){
		Speeddmg=Speeddmg + n;
		if (Speeddmg>100000){Speeddmg=100000;}//just caps it so it can't freeze forever
	}
	public void resetSpeeddmg(){
		Speeddmg=0;
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
		if(this.getSpeed()>n)//can't have speed zero
			this.speed-=n;
	}
	//critter is hit and loses resistance
	public void critterLosesResistance(int n){
		if(this.getResistance()>n)
			this.resistance-=n;
	}
	
	public void moveAlongPath(LinkedList<Integer> path){

		int i;
		long temp;
		while(!path.isEmpty()){
			i=path.pop();
			long startTime = System.nanoTime();
			this.setPosition(i);
			try {
				//System.out.println("sleeping");
				temp=(((long)10000)/((long)this.getSpeed()))+Speeddmg;
				this.resetSpeeddmg();
				Thread.sleep(temp);
				
				
				
				//System.out.println("wake up");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getID()+": "+this.getPosition()+" time: "+(System.nanoTime()-startTime)+" health: "+this.getHealth());
		}
		
		this.setPosition(-1);	//out of bounds
		
	}

	LinkedList<Integer> aPath=new LinkedList<Integer>();//accesses through the Map


	
	
	@Override
	public void run() {
		LinkedList<Integer> path = new LinkedList<Integer>();
		for (int i: aPath){
			path.add(i);

		}
		System.out.println("running");
		moveAlongPath(path);
		System.out.println("done");
		
	}
	
	public Thread startMoving(){
		Thread thread = new Thread (this);
		return thread;
		//thread.start();
	}
		
	
	

	
}
