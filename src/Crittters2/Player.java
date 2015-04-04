package Crittters2;

public class Player {
	private int Life;
	private int Money;
	
	public Player (){
		Life = 5;
		Money= 100;
	}
	
	public int getMoney(){
		return Money;
	}
	public int getLife(){
		return Life;
	}
	
	public void addMoney(int n){
		if (Money+n<0)
			return;
		Money= Money+n;
	}
	public void addLife(int n){
		if (Life+n<0)
			return;
		Life= Life+n;
	}
	public boolean continuePlaying(){
		if (Life>0)
			return true;
		else 
			return false;
	}
	
}
