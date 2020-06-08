import java.util.Random;

public class Number 
{
	private Random random;
	private int number;
	
	public Number()
	{
		random = new Random();
	}
	
	//Generates a random number 0 through 99
	public int getNumber()
	{
		number = random.nextInt(100);
		return number;
	}
	
}//end class
