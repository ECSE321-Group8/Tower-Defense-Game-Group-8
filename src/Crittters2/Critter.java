package Crittters2;
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
	
	private Thread t;
	Map m = Map.getInstance();

	
	
	public Critter(int ID){
		setPosition(-1);
		setID(ID);
		//setThread();

		//for testing 
		m.setMap(4,4);
		m.setCellToPath(0);
		m.setCellToPath(1);
		m.setCellToPath(2);
		m.setCellToPath(3);
		m.setCellToPath(7);
		m.setCellToPath(11);
		m.setCellToPath(15);
		m.finalizePath();
		m.printPath();
		setPath();
		
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
	public Thread getThread(){
		return t;
	}
	public LinkedList<Path> getPath(){
		return aPath;
	}
	public int getTimer(){
		return timer;
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
	
//	public void setThread(){
//		t=this.startMoving();
//	}
	
	
	public void setPath(){
		for (Path p: m.getPath())
			aPath.add(p);
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
		if(isAlive())
			this.health-=n;
	}
	public void updateHealth(int damage){
		this.health=this.health-damage;
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
		System.out.println(this.getPosition());
		if (timer > 0)
			timer -=1;
		else if (timer==0)
			if (moveToNext())
				timer = waitingTime;
			else
				return;
		else 
			return;
			
	}
	
	public boolean moveToNext(){
		Path p;
		if (!aPath.isEmpty()){
			p = aPath.pop();
			setPosition(p.getPos());
			return true;
		}
		else{
			//setPosition(-1);
			return false;
		}
	}
	
	public void moveThroughPath(){
		System.out.println("executing movethrought");
		while(!aPath.isEmpty())
			tick();
	}
	
	
	
	
	
	
	
	
	
	
//	public void moveAlongPath(LinkedList<Path> path){
//
//		Path i;
//		while(!path.isEmpty()){
//			i=path.pop();
//			this.setPosition(i.getPos());
//			try {
//			//System.out.println("sleeping");
//				Thread.sleep(((long)1000)/((long)this.getWaitingTime()));
//			//System.out.println("wake up");
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(this.getID()+": "+this.getPosition());
//		}
//		
//		this.setPosition(-1);	//out of bounds
//		
//	}

	


		
	
	

	
}
