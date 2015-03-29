
public class Money extends Subject {
	
	protected Money(double money)
	{
		this.money=money;
	}
	public double getMoney()
	{
		return this.money;
	}
	public void changeMoney(double change)
	{
		if(change!=0)
		{
			this.money=this.money+change;
			notifyAllObservers();
		}
	}
	private double money;
	//private final double initialMoney=1000;

}
