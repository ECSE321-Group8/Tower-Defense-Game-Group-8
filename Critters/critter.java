
public class critter {
	public int speed;
	public  static int typeCritter;
	public double health;
	public boolean alive; 
	public double positionX=0;
	
	public double positionY=0;
	
	// assume that entry gate is at(0,0)
	//at the beginning the critters are on path
	//abstract public int getTyper();
	
	public critter()
	{
		//System.out.println("NewCritter:"+getTypeCritter());
//		typeCritter=getType();
	
	}
	private int getTypeCritter() {
		// TODO Auto-generated method stub
		return typeCritter;
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
	public void updateHealth(double damage)
	{
	
		this.health=this.health-damage;
		if(this.health<=0)
		{
			Game.myMoney.changeMoney(typeCritter*3);
			
			
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
	public void move(double positionX,double positionY)
	{
		if ( speed!=0 && health!=0 )
		{
			//change positionx and positiony according to the set up of the path
			// increment one tile then multipy by speed		
		}
		if(positionX==10 && positionY==10)//suppose end point
		{
			Game.myLife.decreaseLife(1);
			Game.myMoney.changeMoney(-typeCritter*3);
		}
	}

}