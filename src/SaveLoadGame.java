import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


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
//	Player player;
	public void saveGame(int health, int attack, int x, int y)
	{
		PrintWriter writer = null;
		try
		{
			writer = new PrintWriter("savedGame.txt");
			writer.println(health);
			writer.println(attack);
			writer.println(x);
			writer.println(y);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			writer.close(); //close scanner after writing to file.
		}
	}

	public void loadGame()
	{
		FileReader fileReader = null;
		BufferedReader reader = null;
		try
		{
			fileReader = new FileReader("savedGame.txt");
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reader = new BufferedReader(fileReader);
		//		Scanner reader = new Scanner("savedGame.txt");
		try
		{
			Player.setHealth(Integer.parseInt(reader.readLine()));
		}
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			Player.attack = (Integer.parseInt(reader.readLine()));
		}
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			Player.x = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			Player.y = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			reader.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
