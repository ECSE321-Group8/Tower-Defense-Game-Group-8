package Critters;


import java.util.List;
import java.util.LinkedList;

public class wave extends Subject{
	
	private static LinkedList <critter> wavelist=new LinkedList<critter>();
	protected int numberOfCritters;
	//Will be better implemented as a factory in assignment 3

	
	public wave(int level)
	{
		//for the first wave only critter1 will be created
		//for the second wave critter2 also will be created
		//for the third wave all type of critters will be created
		//as number of wave will increase the number of critters will also increase
	//	List<critter> wavelist=new LinkedList<critter>();
		
		if(level==0)//for testing
		{
			for(int p=0;p<3;p++)
			{
				new critter1();
				wavelist.add(new critter1());
				numberOfCritters++;
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
	}
	public  int getNumberOfCritters() {
		return numberOfCritters;
	}
	public void decrementCritter() {
		//you need to know which critter has been hit!! 
		//decrementcritter just decrement the number of critter in the wave when a critter dies.
		//it does not change when critters' health decrease
		//This method will only be called when a critter dies
		numberOfCritters--;
		notifyAllObservers();
	//	wavelist.
	}
		public static LinkedList <critter> getWavelist() {
			return wavelist;
		}
		//FOR LATTER (FACTORY)
//		else if(level==1)
//		{	
//			for(int i=0;i<=5;i++)
//			{
//				getWavelist().add(new critter1());
//				//System.out.println(wavelist.size());
//			}
//
//		}
//		else if(level==2)
//		{
//			for(int j=0;j<=3;j++)
//			{
//				getWavelist().add(new critter2());
//				for(int q=0;q<3;q++)
//				{
//					getWavelist().add(new critter1());
//				}
//			}
//		}
//		else if(level==3)
//		{
//			for(int j=0;j<=3;j++)
//			{
//				getWavelist().add(new critter3());
//				
//				for(int q=0;q<3;q++)
//				{
//					getWavelist().add(new critter2());
//					
//					for(int w=0;w<3;w++)
//					{
//						getWavelist().add(new critter1());
//					}
//				}
//			}
//		}
//		else
//		{
//			for(int j=0;j<=level;j++)
//			{
//				getWavelist().add(new critter3());
//				
//				for(int q=0;q<=level;q++)
//				{
//					getWavelist().add(new critter2());
//					
//					for(int w=0;w<=level;w++)
//					{
//						getWavelist().add(new critter1());
//					}
//				}
//			
//			}	
//		}
//	
//	}
	
	
	
}
