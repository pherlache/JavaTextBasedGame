
public class Damage 
{
	int damage = 0;
	
	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	
	public double dealDamage(double multiplier, Enemy enemy)
	{
		double dealt = 0;
		dealt = damage * multiplier; //calculate damage delt
		enemy.health -= dealt; //Subtract health from enemy
		return dealt;
	}
	
	public double dealDamage(double multiplier, Hero hero)
	{
		double dealt = 0;
		dealt = damage * multiplier; //calculate damage delt
		hero.health -= dealt; //Subtract health from player
		return dealt;
	}
}//end Damage
