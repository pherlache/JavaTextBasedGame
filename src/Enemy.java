
public abstract class Enemy extends Character
{
	protected int health;
	protected Hero hero;
	
	public abstract void attack();
	
	//Constructors
	public Enemy()
	{
		super("");
		health = 0;
	}
	
	public Enemy(String name)
	{
		super(name);
	}
	
	public Enemy(String name, int health)
	{
		super(name);
		this.health = health;
	}
	
	public void setHero(Hero hero)
	{
		this.hero = hero;
	}
}//end class
