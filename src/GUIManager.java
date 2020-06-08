import javax.swing.JOptionPane;

public class GUIManager implements Runnable
{
	public static GUI gui = new GUI();
	private String userInput;
	
	@Override
	public void run() 
	{
		gui.initComponents(); //Intialize the GUI
		retreiveUserName(); //Get the users name
		gui.makeVisible(); //Finally display the GUI
		introduction();
		battleOptions();
		//GameManager.enemy.attack();
	}
	
	private void retreiveUserName()
	{
		userInput = JOptionPane.showInputDialog("Enter your name");
		gui.setPlayerName(userInput); //Set the playerName in the GUI
	}
	
	private void introduction()
	{
		gui.appendText("Welcome to Game Mash, " + gui.getPlayerName() + "!");
		gui.appendText("\n");
	}

	public static void battleOptions()
	{
		gui.appendText(gui.getPlayerName() + ", select the enemy you would like to battle");
		gui.appendText("\n");
		gui.showEnemyCard();
	}
	
	
}//end class
