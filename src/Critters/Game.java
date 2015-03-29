package Critters;

public class Game extends Subject{
	
	public Game(int life,double money,int wave)
	{
		myLife=new Life(life);
		myMoney=new Money(money);
		myWave=new wave(wave);
	}
	public void getGame()
	{
		System.out.println("PLAYER'S LIFE IS : "+getLife()+"     AMOUNT OF MONEY : "+getMoney());
	}
	public int getLife() {
		// TODO Auto-generated method stub
		return myLife.getLife();
	}
	public double getMoney()
	{
		return myMoney.getMoney();
	}
	public int getNumberOfCritters() {
		// TODO Auto-generated method stub
		return myWave.getNumberOfCritters();
	}
	protected static Life myLife;
	protected static Money myMoney;
	protected static wave myWave;
	
}
