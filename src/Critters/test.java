package Critters;
import Logic.TowerTest;
import Logic.Tower;
import java.util.*;


public class test {
	
	public static void main(String[]args)
	{
		Game myGame=new Game(10,50,0);
		LifeAlert lifeAlert=new LifeAlert(myGame);
		MoneyAlert moneyAlert=new MoneyAlert(myGame);
		WaveAlert waveAlert=new WaveAlert(myGame);
		
		myGame.myLife.add(lifeAlert);
		myGame.myMoney.add(moneyAlert);
		myGame.myWave.add(waveAlert);
		
		myGame.getGame();
		//System.out.println("-----Creating a test wave-----");
		//System.out.println("-----Creating a Tower List----");
		List<Tower>	allthetowers = new ArrayList<Tower>();//++++the creation of the
		System.out.println("-----Creating a Tower---------");
		allthetowers.add(new TowerTest(1,0));
		allthetowers.add(new TowerTest(5,0));
		
		//System.out.println(wave.getWavelist());
		//System.out.println("Size of the wave : "+wave.getWavelist().size());
		//System.out.println("Inspecting first critter");
		wave.getWavelist().get(2).inspect();
		for(int j=0; j < 20; j++){
			System.out.println("tick--#oftowers"+allthetowers.size());
			for(int i=0; i<allthetowers.size(); i++){
				System.out.println("--cycle for tower #"+i);
				allthetowers.get(i).tick();
				System.out.println("end of cycle for tower #"+i);
			}
		}
		
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

