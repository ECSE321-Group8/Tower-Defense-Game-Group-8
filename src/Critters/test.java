package Critters;
import Logic.TowerList;
import Logic.TowerTest;
import Logic.TowerSniper;
import Logic.TowerStrong;
import Logic.TowerFast;
import Logic.TowerRegular;
import Logic.Tower;




public class test {
	
	public static void main(String[]args)
	{
		Game myGame=new Game(10,500,0);
		LifeAlert lifeAlert=new LifeAlert(myGame);
		MoneyAlert moneyAlert=new MoneyAlert(myGame);
		WaveAlert waveAlert=new WaveAlert(myGame);
		
		myGame.myLife.add(lifeAlert);
		myGame.myMoney.add(moneyAlert);
		myGame.myWave.add(waveAlert);
		
		myGame.getGame();
		//System.out.println("-----Creating a test wave-----");
		//System.out.println("-----Creating a Tower List----");
		TowerList	allthetowers = new TowerList();//++++the creation of the tower list
		System.out.println("-----Creating a Tower---------");
		allthetowers.add(new TowerSniper(1,0));//++++how to add a tower, with x and y coordinates,tower type isin the name (TowerFast, TowerRegular)
		allthetowers.add(new TowerTest(5,0));
		
		//System.out.println(wave.getWavelist());
		//System.out.println("Size of the wave : "+wave.getWavelist().size());
		//System.out.println("Inspecting first critter");
		wave.getWavelist().get(2).inspect();
		System.out.println("about to upgrade");
		allthetowers.get(0).upgrade();//this upgrades tower 0
		allthetowers.get(1).upgrade();//this upgrades tower 1
		allthetowers.get(0).setTargetingStrategy(2);//this changes targeting strategies
		
		//++++all the towers cycle through what they do in one gamecycle
		for(int j=0; j < 20; j++){//fake gamecycle not to put in game clock
			System.out.println("tick--#oftowers"+allthetowers.size());
			if(j == 18){allthetowers.sellTower(0);}//+++this sells a tower and adds the money back (not full though)
			for(int i=0; i<allthetowers.size(); i++){//++to put in gameclock		
				System.out.println("--cycle for tower #"+i);
				allthetowers.get(i).tick();//++to put in gameclock
				System.out.println("end of cycle for tower #"+i);
			}//++t put in gameclock
		}//end of the fake game clock
		
		
		

		
		//System.out.println("========Tower attack first critter======");
		
		//wave.getWavelist().get(0).updateHealth(1);
		wave.getWavelist().get(1).inspect();
		//System.out.println("alive?"+wave.getWavelist().get(0).alive());
		
		//wave.getWavelist().get(0).updateHealth(1);
		//wave.getWavelist().get(0).inspect();
		//System.out.println("alive?"+wave.getWavelist().get(0).alive());
		//System.out.println(wave.getWavelist());
		
		//System.out.println("====Critter successfully reach end point");
		//wave.getWavelist().get(1).move(10,10);
		myGame.getGame();//money and life have decreased
	}
	
}

