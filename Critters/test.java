
public class test {
	
	public static void main(String[]args)
	{
		Game myGame=new Game(10,50);
		LifeAlert lifeAlert=new LifeAlert(myGame);
		MoneyAlert moneyAlert=new MoneyAlert(myGame);
		
		myGame.myLife.add(lifeAlert);
		myGame.myMoney.add(moneyAlert);
		
		myGame.getGame();
		System.out.println("-----Creating a test wave-----");
		wave firstrun=new wave(0);
		
		System.out.println(wave.getWavelist());
		System.out.println("Size of the wave : "+wave.getWavelist().size());
		System.out.println("Inspecting first critter");
		wave.getWavelist().get(0).inspect();
		System.out.println("========Tower attack first critter======");
		
		wave.getWavelist().get(0).updateHealth(1);
		wave.getWavelist().get(0).inspect();
	//	System.out.println("alive?"+wave.getWavelist().get(0).alive());
		
		wave.getWavelist().get(0).updateHealth(1);
		wave.getWavelist().get(0).inspect();
		//System.out.println("alive?"+wave.getWavelist().get(0).alive());
		System.out.println(wave.getWavelist());
		
		System.out.println("====Critter successfully reach end point");
		wave.getWavelist().get(1).move(10,10);
		myGame.getGame();//money and life have decreased
	}
	
}

