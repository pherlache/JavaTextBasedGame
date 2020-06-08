import java.util.ArrayList;

public class WeaponsList 
{
	ArrayList<Weapon> baseWeapons = new ArrayList<>();
	ArrayList<Weapon> allWeapons = new ArrayList<>();
	Weapon sniper;
	Weapon pistol;
	Weapon melee;
	Weapon chainblade;
	Weapon chainBladeMelee;
	
	//Constructor
	public WeaponsList()
	{
		createWeapons();
		addBaseWeapons();
	}
	
	//All weapons to be created at start of game
	private void createWeapons()
	{
		sniper = new Weapon("Sniper", 30, 54, 59);
		allWeapons.add(sniper);
		
		pistol = new Weapon("Pistol", 15, 74, 9);
		allWeapons.add(pistol);
		
		melee = new Weapon("Melee", 10, 79, 4);
		allWeapons.add(melee);
		
		chainblade = new Weapon("Chain blade", 20, 49, 29);
		allWeapons.add(chainblade);
		
		chainBladeMelee = new Weapon("Melee", 15, 89, 14);
	}
	
	private void addBaseWeapons()
	{
		baseWeapons.add(sniper);
		baseWeapons.add(pistol);
		baseWeapons.add(melee);
	}
	
	public void addWeapons(ArrayList<Weapon> yourList, ArrayList<Weapon> list)//adds a list to your list
	{
		yourList.addAll(list);
	}
	
	public void addWeapons(ArrayList<Weapon> yourList, Weapon wpn)//adds a weapon to your list
	{
		yourList.add(wpn);
	}
}//end class