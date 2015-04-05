package Logic;
import java.util.*;

import Logic.Map;
import Logic.Path;


public class CritterWave implements IObserver{

	private LinkedList<Critter> listCritters = new LinkedList<Critter>();
	Map m = Map.getInstance();
	Game g = Game.getInstance();
	private LinkedList<Path> aPath=new LinkedList<Path>();//accesses through the Map
//	private LinkedList<Critter> listCritters2;
	private int cycles;
	private Critter c;

	private LinkedList<Critter> addProgressive= new LinkedList<Critter>();
	
	//Variables used internally to generate critters and push them. 
	private int nbCritters;
	private int critterType;
	private CritterType type;
	private Critter	b;
	

	
	public CritterWave(int level){
		nbCritters=level*5;
		CritterType type;
		Critter c;
		for (int i=0;i<nbCritters; i++){
			critterType = i%3;
			type=getType(critterType);
			c=CritterFactory.makeCritter(type, i);
			listCritters.add(c);
		}
		setPath();
		cycles= listCritters.size();
		
	}

	public void setPath(){
		for (Path p: m.getPath())
			aPath.add(p);
	}
	
	public LinkedList<Path> getPath(){
		return aPath;
	}

	
	
	public LinkedList<Critter> getListCritters(){
		return listCritters;
	}
	
	public void removeCritter(Critter c){
		listCritters.remove(c);
	}
	
	public LinkedList<Critter> getCrittersInField(){
		return addProgressive;
	}
	
	
	
	public static CritterType getType(int type){
		switch(type){
		case 0:
			return CritterType.SPEEDY;
		case 1:
			return CritterType.HEALTHY;
		case 2:
			return CritterType.RESISTANT;
		default:
			return null;//error
		}
	}
	
	

//	LinkedList<Critter> addProgressive= new LinkedList<Critter>();

	
	@Override
	public void update(){
		if(cycles>0){
			 c =listCritters.get(cycles-1);
			addProgressive.add(c);
			cycles--;
		}
		//System.out.println("is it stuck");
		//System.out.println("list size"+listCritters.size());
		if(addProgressive.size()>=1){
			for(int i = addProgressive.size()-1; i >= 0; i--){
				//System.out.println("Maybe?"+i+"   where is it? "+listCritters.get(i).getCompletion()+"  path"+aPath.size());
				if(addProgressive.get(i).getCompletion() == aPath.size()){
					g.decrementLife(1);
					System.out.println("remove(end)"+i);					
					removeCritter(addProgressive.get(i));
					addProgressive.remove(i);
				}else if(!(addProgressive.get(i).isAlive())){
					g.addMoney(5);
					System.out.println("remove(died)"+i);	
					removeCritter(addProgressive.get(i));
					addProgressive.remove(i);
				}else{
					addProgressive.get(i).tick();
				}
			}
		}
	}
	
}
