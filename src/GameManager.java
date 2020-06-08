import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager //implements Runnable
{	
	//Player1 object with health of 100, our player1 object for the game
	private Player1 player1 = new Player1(100);
	
	//ChainBlade object, our enemy for the game
	private ChainBlade chainBlade = new ChainBlade();
	
	public static Hero hero;
	public static Enemy enemy;
	
	private GUI gui = new GUI();
	//private GUIManager guiManager = new GUIManager();
	private Battle battle = new Battle();
	private Menu menu = new Menu();
	private String userInput;
	private int choice = 0;
	private boolean isValid = false;
	private boolean chainBladeBattle = false;
	private Scanner input = new Scanner(System.in);
	
	public String getEnemyName()
	{
		return enemy.name;
	}
	
	public String getHeroName()
	{
		return hero.name;
	}
	
	public boolean getChainBladeBattle()
	{
		return chainBladeBattle;
	}
	
	public void setChainBladeBattle(boolean b) 
	{
		this.chainBladeBattle = b;
	}
	
	/*
	@Override
	public void run() 
	{
		
		hero = player1; //set our hero to player 1
		hero.heroWeapons = player1.myWeapons; //give the hero the weapons that player1 has
		
		//This only sets this way for some reason...
		//It does not appear to set/stay set in the retrieveUser method of the 
		//GUIManager class even though it looks like it should
		hero.name = GUIManager.gui.getPlayerName();
		
		if (chainBladeBattle = true)
		{
			System.out.println("Starting chainBlade Battle");
			startChainBladeBattle();
		}
	}//end run
	*/
	
	public void runGame() throws InputMismatchException
	{
		//This will have to be moved for future implementation
		hero = player1;
		//hero.heroWeapons = player1.myWeapons; 
		//enemy = chainBlade;
		
		//Use to run game in console
		System.out.println("Welcome to Game Mash!");
		System.out.println("Please enter your name");
		userInput = input.nextLine();
		hero.name = userInput;
		System.out.println("Welcome " + hero.name + "!");
		System.out.println(hero.name + ", who would you like to battle?");
		menu.displayEnemies();
		while (!isValid)
		{	
			try
			{
				choice = input.nextInt();
				if (choice < 1 || choice > 1)
				{
					System.out.println("Invalid input, please try again");
					continue;
				}
				isValid = true;
			}
			catch (InputMismatchException e)
			{
				System.out.println("Invalid input, please try again");
				input.next();
			}
		}
		
		switch(choice)
		{
			case 1:
			{
				//Battle enemy
				//Battle battle = new Battle();
				enemy = chainBlade;
				battle.setHero(player1); //sets the hero in the Battle class to the games Player1
				battle.setEnemy(chainBlade); //sets the enemy in the Battle class to the games chainBlade
				battle.chainbladeBattle();
				break;
			}
			default:
			{
				System.out.println("Error from GameManager switch statment");
			}
		}//end switch
	}//end runGame()

	/*
	private void startChainBladeBattle()
	{
		Battle battle = new Battle();
		enemy = chainBlade;
		battle.setHero(player1);
		battle.setEnemy(chainBlade);
		GUIManager.gui.displayBattleInfo();
		battle.chainbladeBattle();
	}
	 */
	
	
}//end class
