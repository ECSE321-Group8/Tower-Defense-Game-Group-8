package Crittters2;
import java.util.*;

import Logic.*;
import Logic.Map;


public class Game {
	int level =1;
	LinkedList<Path> pathList;
	CritterWave wave;
	
	
	public Game(){
		pathList = new LinkedList<Path>();
		wave= new CritterWave(level);
		Map m = Map.getInstance();
	
		
		for (Path p : m.getPath()){
			pathList.add(p);
		}
	}
}
