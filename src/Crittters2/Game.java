package Crittters2;
import java.util.*;

import Logic.*;
import Logic.Map;


public class Game {
	int level =1;
	LinkedList<Path> pathList;
	CritterWave wave;
	Player p;
	
	public Game(){
		p = new Player(); 
		wave= new CritterWave(level);
		Map m = Map.getInstance();
		
		pathList = new LinkedList<Path>();
		
		for (Path p : m.getPath()){
			pathList.add(p);
		}
	}
	


}
