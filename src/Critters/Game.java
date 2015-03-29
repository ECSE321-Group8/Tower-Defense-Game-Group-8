package Critters;

public class Game extends Subject{
	
	public Game(int life,double money)
	{
		myLife=new Life(life);
		myMoney=new Money(money);
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
	protected static Life myLife;
	protected  static Money myMoney;
}
