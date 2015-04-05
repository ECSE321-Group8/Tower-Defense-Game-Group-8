package Crittters2;
import java.util.*;

import Logic.*;
import Logic.Map;


public class Game extends Subject{
	
	private int level =4;
	LinkedList<Path> pathList;
	CritterWave wave;
	private static Game gameInstance= null;
	private int money;
	private int Life;
//	Timer timer = new Timer();
	TowerList mytowerlist;

	
	public TowerList getMytowerlist() {
		return mytowerlist;
	}


	public Game(){
	
	}
	
	public static Game getInstance(){
		if(gameInstance==null)
			gameInstance=new Game();
		return gameInstance;
	}
	/**
	 * Initialized the Main components and variables for the Game
	 */
	public void setGame(){
		Map m = Map.getInstance();
		wave= new CritterWave(level);
		mytowerlist= new TowerList();
		pathList = new LinkedList<Path>();
		money = 6;
		Life = 10;
		for (Path p : m.getPath()){
			pathList.add(p);
		}
		
	}
	public void setLevel(int n){
		level = n;
	}
	public int getLevel(){
		return level;
	}
		
	public LinkedList<Path> getPathList(){
		return pathList;
	}
	public CritterWave getCritterWave(){
		return wave;
	}
	public int getMoney(){
		return money;
	}
	public int getLife(){
		return Life;
	}
	
	public void setMoney(int n){
		money=n;
	}
	public void setLife(int n){
		Life=n;
	}
	public void decrementLife(int n){
		Life-=n;
	}	
	public void addMoney(int n){
		money+=n;
	}




	
	/**
	 * The game will notify Tower and Critters every time the clock ticks 
	 */
	public void tick(){
		notifyObservers();
		System.out.println("Money: " + getMoney() + "\nLife: " + getLife());
	}

}
