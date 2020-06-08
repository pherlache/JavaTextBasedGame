import java.util.Scanner;

public class Battle 
{
	private Enemy enemy;
	private Hero hero;
	//private static boolean herosTurn = true;
	private String userInput = "";
	private Scanner input = new Scanner(System.in);
	
	//Setters
	public void setHero(Hero hero)
	{
		this.hero = hero;
	}
	
	public void setEnemy(Enemy enemy)
	{
		this.enemy = enemy;
	}
	
	/*
	public static void setHerosTurn(boolean b)
	{
		herosTurn = b;
	}
	*/
	
	//Getters
	public Enemy getEnemy()
	{
		return enemy;
	}
	
	public Hero getHero()
	{
		return hero;
	}
	
	public String getEnemyHealth()
	{
		return Integer.toString(enemy.health);
	}
	
	public String getHeroHealth()
	{
		return Integer.toString(hero.health);
	}
	
	public void chainbladeBattle()
	{
		System.out.println();
		System.out.println("You are battling ChainBlade");
		enemy.setHero(GameManager.hero); //sets enemy's opponent(hero) to the hero that was passed to us
		hero.setEnemy(GameManager.enemy); //sets the hero's opponent(enemy) to the enemy that was passed to us
		
		while(enemy.health > 0 || hero.health > 0)
		{
			
			//sleep();
			if(checkHealth())
				break;
			/*
			if(herosTurn)
			{
				GUIManager.gui.showBattleMoveCard();
				
				boolean done = false;
				boolean moveSelected = false;
				boolean weaponSelected = false;
				while (!done)
				{
					sleep();
					//Make something wait or something
					//Wait for hero to make move
					while (!moveSelected)
					{
						sleep();
						
						if (GUIManager.gui.moveSelected)
						{
							GUIManager.gui.showWeaponsCard();
							moveSelected = true;
						}
					}
		
					while (!weaponSelected)
					{
						sleep();
						
						if (GUIManager.gui.weaponSelected)
						{
							Weapon weapon = new Weapon();
							weapon.useWeapon(GameManager.hero.weapon, GameManager.enemy);
							herosTurn = false;
							weaponSelected = true;
						}
					}
				}
			}
			
			if (herosTurn == false)
			{
				System.out.println("Attacking");
				enemy.attack();
				herosTurn = true;
				//break;
			}
*/
			System.out.println("Your health is: " + hero.health);
			System.out.println("ChainBlades health is: " + enemy.health);
			System.out.println("Select your move");
			System.out.println("1. Attack");
			userInput = input.nextLine();
			switch(userInput)
			{
			case("1"):
				hero.attack();
				break;
			default:
				System.out.println("Error from chainBladeBattle");
				break;
			}
			
			if(checkHealth())
				break;
			
			enemy.attack();
			
		}//end while
		
	}//end chainbladeBattle()
	
	/*
	private void sleep()
	{
		try 
		{
			Thread.sleep(50);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	*/
	
	private boolean checkHealth()
	{
		if(hero.health <= 0)
		{
			hero.health = 0;
			System.out.println("You lost!");
			return true;
		}
		
		if(enemy.health <= 0)
		{
			enemy.health = 0;
			System.out.println("You won!");
			return true;
		}
		
		return false;
	}//end checkHealth
	
}//end class
