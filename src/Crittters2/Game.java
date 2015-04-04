package Crittters2;
import java.util.*;

import Logic.*;
import Logic.Map;


public class Game extends Subject{
	int level =1;
	LinkedList<Path> pathList;
	CritterWave wave;
	Player p;
	private static Game gameInstance= null;
	private int Money;
	private int Life;
	
	TowerList mytowerlist;

	
	public TowerList getMytowerlist() {
		return mytowerlist;
	}


	public Game(){
		
		Map m = Map.getInstance();
		p = new Player(); 
		wave= new CritterWave(level);
		mytowerlist= new TowerList();
		pathList = new LinkedList<Path>();
		
		for (Path p : m.getPath()){
			pathList.add(p);
		}
	}
	
	
	public static Game getInstance(){
		if(gameInstance==null)
			gameInstance=new Game();
		return gameInstance;
	}
	
	public LinkedList<Path> getPathList(){
		return pathList;
	}
	public CritterWave getCritterWave(){
		return wave;
	}
	public int getMoney(){
		return Money;
	}
	public int getLife(){
		return Life;
	}
	
	public void setMoney(int n){
		Money=n;
	}
	public void setLife(int n){
		Life=n;
	}
	public void addMoney(int n){
		Money+=n;
	}
	
	
	
	
	public void startGameClock(){
		while(!wave.getListCritters().isEmpty()){
			try {
				Thread.sleep(1000);
				notifyObservers();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
