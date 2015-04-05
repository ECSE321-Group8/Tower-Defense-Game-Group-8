package Crittters2;
import java.util.*;

import Logic.*;
import Logic.Map;


public class Game extends Subject{
	int level =4;
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
	
	public void setGame(){
		Map m = Map.getInstance();
		wave= new CritterWave(level);
		mytowerlist= new TowerList();
		pathList = new LinkedList<Path>();
		money = 6;
		Life = 100;
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

//	public void buyTower(int n , int x, int y){
//		mytowerlist.buyTower(n,x,y);
//	}
//	
//	
//	



	
	
	public void tick(){
		notifyObservers();
		System.out.println("Money: " + getMoney() + "\nLife: " + getLife());
	}
//
//		while(!wave.getListCritters().isEmpty()){
////			try {
//				//Thread.sleep(1000);
//				new GameTimer();
//				notifyObservers();
//	//		} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//		//		e.printStackTrace();
//			//}
//		}
//	}
}
