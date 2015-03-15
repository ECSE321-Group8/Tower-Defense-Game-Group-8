
abstract class critter
{
	private int speed;
	private double health;
	private boolean onpath; 
	private double positionx=0;
	private double positiony=0;
	
	// assume that entry gate is at(0,0)
	//at the beginning the critters are on path
	
	
	public critter()
	{
	
	}
	//when critters are inspected
	public void inspect()
	{
		System.out.println("Speed is:"+this.speed+
				            "Health is:"+this.health);
	}

	//when critters receive hit from tower 
	//,we have to set new health according to the damage
	public void updatehealth(double damage)
	{
		
		this.health=this.health-damage;
		
		if(this.health<=0)
		{
			
			//reward player money
			//call method to increment amount of money of player
			//incrementbank(10*critter.gettype());
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
	public void minuslife()
	{
		this.onpath=false;
		//call a method to decrement life of player
		//decrementbank(10*(critter.gettype());
		
	}
	public void move()
	{
		if ( speed!=0 && health!=0 )
		{
			
			//change positionx and positiony according to the set up of the path
			// increment one tile then multipy by speed
			
		}
	}
}