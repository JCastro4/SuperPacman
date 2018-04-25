import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.sun.beans.editors.IntegerEditor;

/**
 * Class: Puzzles
 * 
 * @author Cesar
 * @author Boji Benji
 *
 *	Purpose:
 *	Shows monster information through text files. 
 */

/*
 * Main boss: Pinky
 * Other Monsters: Blue Ghost0-4
 * Clyde, Inky, Blinky 
 * Each monster has their own stat's 
 * ExamineGhost (user commands) shows description for the ghost. 
 * Flee Ghost(user commands) 
 * Deal/ Receive Damage commands
 * Each Ghost has a name, color, description, health, attack, defense, and accuracy.
 */

/* Example text file input to reference.
 * Name: Pinky	
Color: Pink		
Description: A boss ghost that can attack user's life points as well as his/her attack, defense.	
HP: 100 
Accuracy: 50/50 chance of hit 
Attack: 80 
Defense:60
 */

@SuppressWarnings("serial")
public class Ghost extends Person
{
	private int accuracy;
	//	private String color;
	//	private String description;
	//	Player player = new Player();
	private String color;
	private String description;
	static ArrayList<String> ghostList = new ArrayList<>();
	static ArrayList<String> nameList = new ArrayList<>();
	static ArrayList<String> colorList = new ArrayList<>();
	static ArrayList<String> descriptionList = new ArrayList<>();
	static ArrayList<String> HPList = new ArrayList<>();
	static ArrayList<String> attackList = new ArrayList<>();
	static ArrayList<String> accuracyList = new ArrayList<>();
	static ArrayList<String> defenseList = new ArrayList<>();

	public Ghost()
	{
		//empty constructor
	}
	public Ghost(String name, String color, String description, int health, int attack, int defense, int accuracy)
	{
		this.setName(name);
		this.color = color;
		this.description = description;
		Ghost.setHealth(health);
		this.setAttack(attack);
		this.setDefense(defense);
		this.setAccuracy(accuracy);
	}
	public static String getGhostName(int indexGhost)
	{
		return nameList.get(indexGhost);
	}
	public static String getGhostDescription(int indexGhost)
	{
		return descriptionList.get(indexGhost);
	}
	public static int getDefense(int indexGhost)
	{
		return Integer.parseInt(defenseList.get(indexGhost));
	}
	public static  String getGhostColor(int indexGhost)
	{
		return colorList.get(indexGhost);
	}

	/**
	 * @return the accuracy
	 */
	public double getAccuracy(int indexGhost)
	{
		return Double.parseDouble((accuracyList.get(indexGhost)));
	}
	public static int getGhostHP(int indexGhost)
	{
		return Integer.parseInt(HPList.get(indexGhost));
	}
	public static int getGhostAttack(int indexGhost)
	{
		return Integer.parseInt(attackList.get(indexGhost));
	}
	public static int getGhostAccuracy(int indexGhost)
	{
		return Integer.parseInt(accuracyList.get(indexGhost));
	}
	

	/**
	 * @param accuracy the accuracy to set
	 */
	public void setAccuracy(int accuracy)
	{
		this.accuracy = accuracy;
	}

	/* (non-Javadoc)
	 * @see Person#attack()
	 */
	@Override
	public void attack()
	{
		dealDamage(getAttack());

	}

	/* (non-Javadoc)
	 * @see Person#dealDamage()
	 */
	@Override
	public void dealDamage(int attack)
	{
		Player.setHealth(Player.getHealth() - attack );

	}

	/* (non-Javadoc)
	 * @see Person#receiveDamage()
	 */
	//	@Override
	//	public void receiveDamage()
	//	{
	//		// TODO Auto-generated method stub
	//		
	//	}
	public void createGhosts() // Create Ghosts needed
	{
		Ghost Clyde = new Ghost("Clyde", "orange", description, 75, 60, 40, 40/60);
		Ghost Inky = new Ghost("Inky", "cyan", description, 75, 60, 40, 40/60);
		Ghost Blinky = new Ghost("Blinky", "red", color, 75, 60, 40, 40/60);
		Ghost Pinky = new Ghost("Pinky", "pink", color, 100, 80, 60, 100);
		//Ghost ghost = new Ghost("ghost", "blue", color, 50, 50, 30, 30/70);
		Ghost ghost1 = new Ghost("ghost1", "blue", color, 50, 50, 30, 30/70);
		Ghost ghost2 = new Ghost("ghost2", "blue", color, 50, 50, 30, 30/70);
		Ghost ghost3 = new Ghost("ghost3", "blue", color, 50, 50, 30, 30/70);
		Ghost ghost4 = new Ghost("ghost4", "blue", color, 50, 50, 30, 30/70);

	}



	public static void loadGhost() throws IOException
	{

		// Set file name & path     
		String monster = "Monster.txt";

		// Read in file
		FileInputStream in = new FileInputStream(monster);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));


		// Declare Array which will hold lines               
		//	ArrayList<String> list = new ArrayList<>();
		//	myarray = new String[175];
		String line;		 
		// Read each line into the array            
		while((line = br.readLine()) != null)
		{
			ghostList.add(line);
		}
		int i = 0;
		do
		{
			nameList.add(ghostList.remove(i));
			colorList.add(ghostList.remove(i));
			descriptionList.add(ghostList.remove(i));
			HPList.add(ghostList.remove(i));
			attackList.add(ghostList.remove(i));
			accuracyList.add(ghostList.remove(i));
			defenseList.add(ghostList.remove(i));

		}
		while(!ghostList.isEmpty());
		//		System.out.println("puzzles " + puzzles);
		//		System.out.println("hintList " + hintList);
		//		System.out.println("solutionList " + solutionList);
		//	while(br.readLine() != null);

		in.close();
	}
}

