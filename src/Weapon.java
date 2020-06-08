
public class Weapon 
{
	private int damage;
	private int hitChance;
	private int critChance;
	private String name;
	private Number number = new Number();
	private Damage dmg = new Damage();
	
	//Constructors
	public Weapon(String name, int damage, int hitChance, int critChance)
	{
		this.name = name;
		this.damage = damage;
		this.hitChance = hitChance;
		this.critChance = critChance;
	}
	
	public Weapon()
	{
		name = "";
		damage = 0;
		hitChance = 0;
		critChance = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getHitChance()
	{
		return hitChance;
	}
	
	public void useWeapon(Weapon wpn, Enemy enemy)
	{
		int num = number.getNumber();
		
		if (num < wpn.getHitChance()) //Is a hit
		{
			hit(enemy, wpn);
		}
		else //Is a miss
		{
			miss(GameManager.hero);
		}
	}//end useWeapon
	
	public void useWeapon(Weapon wpn, Hero hero)
	{
		int num = number.getNumber();
		
		if (num < wpn.getHitChance()) //Is a hit
		{
			hit(hero, wpn);
		}
		else //Is a miss
		{
			miss(GameManager.enemy);
		}
	}//end useWeapon()
	
	private void hit(Enemy enemy, Weapon wpn)
	{
		int num = number.getNumber();
		double damageMultiplier;
		
		if (num < wpn.critChance) //hit is critical
		{
			damageMultiplier = 2.0; //sets multiplier
			dmg.setDamage(wpn.damage);	//sets damage to weapons damage
			double dealt = dmg.dealDamage(damageMultiplier, enemy);
			//GUIManager.gui.appendText(GameManager.hero.name + " landed a critical hit!");
			//GUIManager.gui.appendText("\n");
			//GUIManager.gui.appendText(GameManager.hero.name + " dealt " + dealt + " damage to " + enemy.name);
			//GUIManager.gui.appendText("\n");
			//GUIManager.gui.setlabelEnemyHealth(Double.toString(enemy.health - dealt));
			
			System.out.println(GameManager.hero.name + " landed a critical hit!");
			System.out.println(GameManager.hero.name + " dealt " + dmg.dealDamage(damageMultiplier, enemy) + " damage to " + enemy.name);
		}
		else //hit is not critical
		{
			damageMultiplier = 1.0;
			dmg.setDamage(wpn.damage);
			//GUIManager.gui.appendText(GameManager.hero.name + " dealt " + dmg.dealDamage(damageMultiplier, enemy) + " damage to " + enemy.name);
			//GUIManager.gui.appendText("\n");
			System.out.println(GameManager.hero.name + " dealt " + dmg.dealDamage(damageMultiplier, enemy) + " damage to " + enemy.name);
		}
	}//end hit()
	
	private void hit(Hero hero, Weapon wpn)
	{
		int num = number.getNumber();
		double damageMultiplier;
		
		if (num < wpn.critChance) //hit is critical
		{
			damageMultiplier = 2.0; //sets multiplier
			dmg.setDamage(wpn.damage);	//sets damage to weapons damage
			System.out.println(GameManager.enemy.name + " landed a critical hit!");
			System.out.println(GameManager.enemy.name + " dealt " + dmg.dealDamage(damageMultiplier, hero) + " damage to " + hero.name);
		}
		else //hit is not critical
		{
			damageMultiplier = 1.0;
			dmg.setDamage(wpn.damage);
			System.out.println(GameManager.enemy.name  + " dealt " + dmg.dealDamage(damageMultiplier, hero) + " damage to " + hero.name);
		}
	}//end hit()
	
	private void miss(Hero hero)
	{
		//GUIManager.gui.appendText(hero.name + " missed!\n");
		System.out.println(hero.name + " missed!");
	}
	
	private void miss(Enemy enemy)
	{
		//GUIManager.gui.appendText(enemy.name + " missed!");
		System.out.println(enemy.name + " missed!");
	}
	public String toWeaponString()
	{
		String myString = "";
		myString +=  name + "\n";
		myString += "Damage Value: " + damage + "\nHit Chance: " + (hitChance + 1) + "\n";
		//Should put modified if statement here if weapon has a 0% critChance
		myString += "Critical Hit Chance: " + (critChance + 1);
		myString += "\n";
		return myString;
	}
}//end class
