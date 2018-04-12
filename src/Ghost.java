import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

@SuppressWarnings("serial")
public class Ghost extends Person
{
	private int accuracy;
//	private String color;
//	private String description;
//	Player player = new Player();
	private String color;
	private String description;
	
	public Ghost()
	{
		//empty constructor
	}
	public Ghost(String name, String color, String description, int health, int attack, int defense, int accuracy)
	{
		this.setName(name);
		this.color = color;
		this.description = description;
		this.setHealth(health);
		this.setAttack(attack);
		this.setDefense(defense);
		this.setAccuracy(accuracy);
	}

	/**
	 * @return the accuracy
	 */
	public int getAccuracy()
	{
		return accuracy;
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
	@Override
	public void receiveDamage()
	{
		// TODO Auto-generated method stub
		
	}
	public void createGhosts() // Create Ghosts needed
	{
		Ghost Clyde = new Ghost("Clyde", "orange", description, 75, 60, 40, 40/60);
		Ghost Inky = new Ghost("Inky", "cyan", description, 75, 60, 40, 40/60);
		Ghost Blinky = new Ghost("Blinky", "red", color, 75, 60, 40, 40/60);
		Ghost Pinky = new Ghost("Pinky", "pink", color, 100, 80, 60, 100);
		Ghost ghost = new Ghost("ghost", "blue", color, 50, 50, 30, 30/70);
		Ghost ghost1 = new Ghost("ghost1", "blue", color, 50, 50, 30, 30/70);
		Ghost ghost2 = new Ghost("ghost2", "blue", color, 50, 50, 30, 30/70);
		Ghost ghost3 = new Ghost("ghost3", "blue", color, 50, 50, 30, 30/70);
		Ghost ghost4 = new Ghost("ghost4", "blue", color, 50, 50, 30, 30/70);
		
	}
	
	public void loadGhost(String monster) throws IOException
	{
	
     monster = "Monster.txt";

    // This will reference one line at a time
    String line = null;

    try {
        // FileReader reads text files 
        FileReader fileReader = new FileReader(monster);

       
        BufferedReader bufferedReader =  new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {  
            System.out.println(line);
        }   

        // Always close files.
        bufferedReader.close();         
    }
    catch(FileNotFoundException ex) {
        System.out.println("Unable to open file '" + monster + "'");                
    }
    catch(IOException ex) {
        System.out.println( "Error reading file '"  + monster + "'");                  
       
    }
		}
	}

