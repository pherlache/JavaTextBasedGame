import java.util.ArrayList;

public class ChainBlade extends Enemy
{
	private Number number = new Number();
	private Damage damage = new Damage();
	private Weapon weapon = new Weapon();
	private WeaponsList weaponsList = new WeaponsList();
	private ArrayList<Weapon> chainBladeWeapons = new ArrayList<>();
	private Hero hero;
	private boolean isMelee = false;
	private boolean isChain = false;
	
	//Constructor
	public ChainBlade() 
	{
		name = "ChainBlade";
		health = 100;
		chainBladeWeapons.add(weaponsList.chainBladeMelee);
		chainBladeWeapons.add(weaponsList.chainblade);
	}
	
	public void setHero(Hero hero) 
	{
		this.hero = hero;
	}
	
	@Override
	public void attack() 
	{	
		determineMove();
		weapon.useWeapon(weapon, hero);
	}//end attack()
	
	//Determine move
	private void determineMove()
	{
		int num = number.getNumber();
		if(num < 50)
		{
			//GUIManager.gui.appendText("ChainBlade used melee");
			//GUIManager.gui.appendText("\n");
			System.out.println("ChainBlade used melee.");
			weapon = chainBladeWeapons.get(0);
		}
		else
		{
			//GUIManager.gui.appendText("ChainBlade used chain blade");
			//GUIManager.gui.appendText("\n");
			System.out.println("ChainBlade used chain blade.");
			weapon = chainBladeWeapons.get(1);
		}
	}//end determineMove()

	//Attack moves
	/*
	private void melee()
	{
		int num = number.getNumber();
		if (num < 90)
		{
			isMelee = true;
			System.out.println("ChainBlade hit you with his melee");
			hit();
		}
		else
		{
			miss();
		}
	}//end melee()
	
	private void chain()
	{
		int num = number.getNumber();
		if (num < 50)
		{
			isChain = true;
			System.out.println("ChainBlade hit you with his chain blade");
			hit();
		}
		else
		{
			miss();
		}
	}//end chain
	*/
	
	private void hit()
	{
		double damageMultiplier = 0;
		int num = number.getNumber();
		
		//if melee was critical
		if (isMelee && num < 30)
		{
			damageMultiplier = 2.0;
			damage.setDamage(15);
			//GUIManager.gui.appendText("ChainBlade landed a critical hit!");
			//GUIManager.gui.appendText("\n");
			//GUIManager.gui.appendText("ChainBlade dealt " + damage.dealDamage(damageMultiplier, hero) + " damage to you!");
			//GUIManager.gui.appendText("\n");
			System.out.println("ChainBlade landed a critical hit!");
			System.out.println("ChainBlade dealt " + damage.dealDamage(damageMultiplier, hero) + " damage to you!");
		}
		//if chain was critical
		else if(isChain && num < 15)
		{
			damageMultiplier = 2.0;
			damage.setDamage(20);
			//GUIManager.gui.appendText("ChainBlade landed a critical hit!");
			//GUIManager.gui.appendText("\n");
			//GUIManager.gui.appendText("ChainBlade dealt " + damage.dealDamage(damageMultiplier, hero) + " damage to you!");
			//GUIManager.gui.appendText("\n");
			System.out.println("ChainBlade landed a critical hit!");
			System.out.println("ChainBlade dealt " + damage.dealDamage(damageMultiplier, hero) + " damage to you!");
		}
		//if melee was not critical
		else if (isMelee)
		{
			damageMultiplier = 1.0;
			damage.setDamage(15);
			//GUIManager.gui.appendText("ChainBlade dealt " + damage.dealDamage(damageMultiplier, hero) + " damage to you!");
			System.out.println("ChainBlade dealt " + damage.dealDamage(damageMultiplier, hero) + " damage to you!");
		}
		//if chain was not critical
		else if (isChain)
		{
			damageMultiplier = 1.0;
			damage.setDamage(20);
			//GUIManager.gui.appendText("ChainBlade dealt " + damage.dealDamage(damageMultiplier, hero) + " damage to you!");
			System.out.println("ChainBlade dealt " + damage.dealDamage(damageMultiplier, hero) + " damage to you!");
		}
	}//end hit()
	
	private void miss()
	{
		//GUIManager.gui.appendText("ChainBlade missed!");
		System.out.println("ChainBlade missed!");
	}//end miss()

}//end class
