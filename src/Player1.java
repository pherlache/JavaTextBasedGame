import java.util.ArrayList;
import java.util.Scanner;

public class Player1 extends Hero 
{
	public ArrayList<Weapon> myWeapons = new ArrayList<>();
	private Scanner input = new Scanner(System.in);
	private String userInput;
	private WeaponsList weaponsList = new WeaponsList();
	private Enemy enemy;
	private Weapon weapon = new Weapon();
	private GUI gui = new GUI();
	
	//Constructor
	public Player1(int health)
	{
		this.health = health;
		weaponsList.addWeapons(myWeapons, weaponsList.baseWeapons); //adds base weapons to players weapons
	}
	
	public Player1()
	{
		
	}
	
	//Setters
	public void setEnemy(Enemy enemy)
	{
		this.enemy = enemy;
	}
	
	//Getters
	public Enemy getEnemy()
	{
		return enemy;
	}
	
	public ArrayList<Weapon> getWeaponList()
	{
		return myWeapons;
	}
	
	private void selectWeapon()
	{
		System.out.println("Which weapon would you like to use?");
		for (int i = 0; i < myWeapons.size(); i++)
		{
			int num = i + 1;
			System.out.println(num + ". " + myWeapons.get(i).toWeaponString());
		}
		int myNum = input.nextInt();
		
		//How can I handle this for a growing number of weapons????
		switch(myNum)
		{
			case(1):
				weapon = myWeapons.get((myNum - 1));
				System.out.println("Weapon selected: " + weapon.getName());
				break;
			case(2):
				weapon = myWeapons.get((myNum - 1));
				System.out.println("Weapon selected: " + weapon.getName());
				break;
			case(3):
				weapon = myWeapons.get((myNum - 1));
				break;
			case(4):
				weapon = myWeapons.get(myNum -1);
				break;
			default:
				System.out.println("Error from selectWeapon switch statement");
		}
		
	}//end selectWeapon()
	
	public void addWeapon(Weapon wpn)
	{
		weaponsList.addWeapons(myWeapons, wpn);
	}
	
	//Select an enemy to attack
	//This method is designed to work with multiple enemies in the game
	//Needs reworking
	public Enemy selectEnemy() 
	{
		ChainBlade chainBlade = new ChainBlade();
		Enemy enemy = null;
		System.out.println("Which enemy would you like to attack?");
		getUserInput();
		switch(userInput)
		{
			case("ChainBlade"):
			{
				enemy = chainBlade;
				return enemy;
			}
			default:
			{
				System.out.println("Error from selectEnemy()");
				break;
			}
		}//end switch
		return enemy;
	}//end selectEnemy();
	
	//Keep for when multiple enemies in the game
	public Enemy selectEnemy(Enemy enemy)
	{
		this.enemy = enemy; //sets player1's enemy to enemy
		return enemy; //returns the enemy
	}
	
	@Override
	public void attack() 
	{	
		selectWeapon();
		weapon.useWeapon(weapon, enemy);
	}

	@Override
	public void getUserInput() 
	{
		userInput = input.nextLine();
	}

}//end class
