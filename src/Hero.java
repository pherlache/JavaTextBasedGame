import java.util.ArrayList;

public abstract class Hero extends Character
{
	protected Enemy enemy;
	protected int health;
	protected ArrayList<Weapon> heroWeapons = new ArrayList<>();
	protected Weapon weapon = new Weapon();
	
	public abstract void attack();
	
	public abstract void getUserInput();
	
	public void setEnemy(Enemy enemy)
	{
		this.enemy = enemy;
	}
	
	
}//end class
