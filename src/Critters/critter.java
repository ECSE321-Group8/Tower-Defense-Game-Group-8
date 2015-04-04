package Critters;
import Logic.*;
import Presentation.*;
public class critter {
	public int speed;
	public  static int typeCritter;
	public int health;
	public boolean alive; 
	public int position;
	
	public static int id;
	
	// assume that entry gate is at(0,0)
	//at the beginning the critters are on path
	//abstract public int getTyper();
	
	public static int getID() {
		return id;
	}
	public critter(int id)
	{
		critter.id=id;
		//System.out.println("NewCritter:"+getTypeCritter());
//		typeCritter=getType();
	
	}
	private int getTypeCritter() {
		// TODO Auto-generated method stub
		return typeCritter;
	}
	public int getPosition() {
		return position;
	}
	//when critters are inspected
	public void inspect()
	{
		System.out.println("Speed is : "+this.speed+
				            " \nHealth is : "+this.health
				            +"\nCritter's Type : "+getTypeCritter());
	}

	
	
	//when critters receive hit from tower 
	//,we have to set new health according to the damage
	public void updateHealth(int damage)
	{
	
		this.health=this.health-damage;
		if(this.health<=0)
		{
			Game.myMoney.changeMoney(typeCritter*3);
			Game.myWave.decrementCritter(id);
			//decrementCritter();
			
			//reward player money
			//call method to increment amount of money of player
		}		
	}
	//if a tower causes a critter to stop moving for a specific time period
	public void setspeed(double timefreeze){
		
		long start = System.currentTimeMillis();
		int temp=speed;
		while ( System.currentTimeMillis() - start < 0.1)
		{
			speed=0;
		}
		speed=temp;
	}
	//when critters arrive at the end point
	//we have to minus one life and remove the critter
	//according to the description we have to decrease amount of money of player
	//proportional to strength of critter
	
	public boolean alive()
	{
		if(health==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public void move(int position)
	{
		if ( speed!=0 && health!=0 )
		{
			for(int x=0;x<Game.myMap.getTemp().size();x++)
			{
				{
					this.position=Game.myMap.getTemp().get(x).getPos();
					try {
						//System.out.println("sleeping");
						Thread.sleep((long)1000);	
						//System.out.println("wake up");
					}
					catch (InterruptedException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(this.getID()+": "+this.getPosition());
				}
			}
			//change positionx and positiony according to the set up of the path
			// increment one tile then multipy by speed		
		}
		if(position==Game.myMap.getTemp().getLast().getExit())//suppose end point
		{
			Game.myLife.decreaseLife(1);
			//Game.myMoney.changeMoney(-typeCritter*3);//I DONT THINK WE LOOSE MONEY !! 
			Game.myWave.decrementCritter(id);
		}
	}

}
