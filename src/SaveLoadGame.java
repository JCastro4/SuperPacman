import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 
 */

/**
 * @author Cesar Mauricio Romero-Pedraza
 *Apr 21, 2018
 * Purpose
 */
public class SaveLoadGame
{
	public void saveGame(int health, int accuracy, int x, int y)
	{
		PrintWriter writer = null;
		try
		{
			writer = new PrintWriter("savedGame.txt");
			writer.println(health);
			writer.println(accuracy);
			writer.println(x);
			writer.println(y);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			writer.close();
		}
	}
	public void loadGame()
	{
		
	}
}
