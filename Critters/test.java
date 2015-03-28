
public class test {
	
	public static void main(String[]args)
	{
		Game myGame=new Game();
		Events myEvents=new Events(myGame);
		myGame.add(myEvents);
		wave firstrun=new wave(1);
		

		System.out.println(wave.getWavelist().size());
		wave.getWavelist().get(0).inspect();
		System.out.println("Tower attack first critter");
		System.out.println("MyMoney = "+myGame.getMyMoney()+"  Mylife = "+myGame.getMyLife());
		wave.getWavelist().get(0).updateHealth(1);
		wave.getWavelist().get(0).inspect();
		System.out.println("onpath?"+wave.getWavelist().get(0).onPath());
		System.out.println("MyMoney = "+myGame.getMyMoney()+"  Mylife = "+myGame.getMyLife());
		wave.getWavelist().get(0).updateHealth(1);
		wave.getWavelist().get(0).inspect();
		
		
		System.out.println("onpath?"+wave.getWavelist().get(0).onPath());
		System.out.println("MyMoney = "+myGame.getMyMoney()+"  Mylife = "+myGame.getMyLife());
	}
	
}

