
public class Game implements Iupdate{
		private int money;
		private int life;
		
		public Game()
		{
			this.money=1000;
			this.life=10;
		}
		public void updatelife()
		{
			life=life-critter.gettype();//Why can i call gettype();
		}
		public void updatemoney()
		{
			this.money=this.money+critter.gettype();//
		}
}
