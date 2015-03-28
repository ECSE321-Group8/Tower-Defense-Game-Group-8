
public class Game extends Subject{
	
	public Game()
	{
		this.myMoney=1000.0;
		this.myLife=10;
	}
	public void decrementLife(int amount) {
			myLife=myLife-amount;		
			notifyAllObservers();
	}
	public void changeMyMoney(double amount)
	{
			myMoney=myMoney +amount;
			notifyAllObservers();
			
	}
	public int getMyLife() {
		return myLife;
	}
		
	public double getMyMoney() {
		return myMoney;
	}
	private double myMoney;
	private int myLife;

}
