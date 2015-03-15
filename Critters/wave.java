

import java.util.List;
import java.util.LinkedList;

public class wave {
	
	private List <critter> wave;
	private int level;
	public wave(int level)
	{
		List <critter> wave = new LinkedList <critter>();
		//for the first wave only critter1 will be created
		//for the second wave critter2 also will be created
		//for the third wave all type of critters will be created
		//as number of wave will increase the number of critters will also increase
		
		if(level==1)
		{	
			for(int i=0;i<=5;i++)
			{
				wave.add(new critter1());
			}

		}
		else if(level==2)
		{
			for(int j=0;j<=3;j++)
			{
				wave.add(new critter2());
				for(int q=0;q<3;q++)
				{
					wave.add(new critter1());
				}
			}
		}
		else if(level==3)
		{
			for(int j=0;j<=3;j++)
			{
				wave.add(new critter3());
				
				for(int q=0;q<3;q++)
				{
					wave.add(new critter2());
					
					for(int w=0;w<3;w++)
					{
						wave.add(new critter1());
					}
				}
			}
		}
		else
		{
			for(int j=0;j<=level;j++)
			{
				wave.add(new critter3());
				
				for(int q=0;q<=level;q++)
				{
					wave.add(new critter2());
					
					for(int w=0;w<=level;w++)
					{
						wave.add(new critter1());
					}
				}
			
		}	
		}
	
	}
}
