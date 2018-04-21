import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		Ghost.setHealth(health);
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
		//Ghost ghost = new Ghost("ghost", "blue", color, 50, 50, 30, 30/70);
		Ghost ghost1 = new Ghost("ghost1", "blue", color, 50, 50, 30, 30/70);
		Ghost ghost2 = new Ghost("ghost2", "blue", color, 50, 50, 30, 30/70);
		Ghost ghost3 = new Ghost("ghost3", "blue", color, 50, 50, 30, 30/70);
		Ghost ghost4 = new Ghost("ghost4", "blue", color, 50, 50, 30, 30/70);
		
	}
	
	
	
	public void loadGhost(String monster) throws IOException
	{
		
	
	
  /*   monster = "Monster.txt";

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
*/
	//	public static void main(String[] args) throws Exception {
			 
			// Set file name & path     
			String filepath = "Monster.txt";
			         
			// Read in file
			FileInputStream in = new FileInputStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			 
			// Declare Array which will hold lines               
			String[] myarray;
			myarray = new String[175];
			 
			// Read each line into the array            
			for (int i = 0; i < myarray.length; i++){
			myarray[i] = br.readLine();
			}
			 
			in.close();
			
			//This line will show lines 1-8 
			//Currently only prints one line at a time 
			//This currently will print each of the ghosts information. 
			//I was thinking we could call this information based on the location of the ghost in the maze. 
			
			
			//Pinky 
			System.out.println(myarray[1].replace("\"", "")+ '\n' + myarray[2].replace("\"", "")+'\n' + myarray[3].replace("\"", "")+'\n'+ myarray[4].replace("\"","")
				+'\n'	+ myarray[5].replace("\"", "")+'\n' + myarray[6].replace("\"", "")+ '\n' +myarray[7].replace("\"", "")+'\n' + myarray[8].replace("\"", "")+'\n');
			
			//Blinky
			System.out.println(myarray[10].replace("\"", "")+ '\n' + myarray[11].replace("\"", "")+'\n' + myarray[12].replace("\"", "")+'\n'+ myarray[13].replace("\"","")
					+'\n'	+ myarray[14].replace("\"", "")+'\n' + myarray[15].replace("\"", "")+'\n' + myarray[16].replace("\"", "")+'\n' + myarray[17].replace("\"", "")+'\n');
		
			//Inky
			System.out.println(myarray[19].replace("\"", "")+ '\n' + myarray[20].replace("\"", "")+'\n' + myarray[21].replace("\"", "")+'\n'+ myarray[22].replace("\"","")
					+'\n'	+ myarray[23].replace("\"", "")+'\n' + myarray[24].replace("\"", "")+'\n' + myarray[25].replace("\"", "")+'\n' + myarray[26].replace("\"", "")+'\n');
			
			//Clyde
			System.out.println(myarray[28].replace("\"", "")+ '\n' + myarray[29].replace("\"", "")+'\n' + myarray[30].replace("\"", "")+'\n'+ myarray[31].replace("\"","")
					+'\n'	+ myarray[32].replace("\"", "")+'\n' + myarray[33].replace("\"", "")+'\n' + myarray[34].replace("\"", "")+'\n' + myarray[35].replace("\"", "")+'\n');
			
			//Blue Ghost 1
			System.out.println(myarray[36].replace("\"", "")+ '\n' + myarray[37].replace("\"", "")+'\n' + myarray[38].replace("\"", "")+'\n'+ myarray[39].replace("\"","")
					+'\n'	+ myarray[40].replace("\"", "")+'\n' + myarray[41].replace("\"", "")+'\n' + myarray[42].replace("\"", "")+'\n' + myarray[43].replace("\"", "")+'\n');

			//Blue Ghost 2
			System.out.println(myarray[45].replace("\"", "")+ '\n' + myarray[46].replace("\"", "")+'\n' + myarray[47].replace("\"", "")+'\n'+ myarray[48].replace("\"","")
					+'\n'	+ myarray[49].replace("\"", "")+'\n' + myarray[50].replace("\"", "")+'\n' + myarray[51].replace("\"", "")+'\n' + myarray[52].replace("\"", "")+'\n');
			
			//Blue Ghost 3 
			System.out.println(myarray[53].replace("\"", "")+ '\n' + myarray[54].replace("\"", "")+'\n' + myarray[55].replace("\"", "")+'\n'+ myarray[56].replace("\"","")
					+'\n'	+ myarray[57].replace("\"", "")+'\n' + myarray[58].replace("\"", "")+'\n' + myarray[59].replace("\"", "")+'\n' + myarray[60].replace("\"", "")+'\n');
			
			//Blue Ghost 4
			System.out.println(myarray[62].replace("\"", "")+ '\n' + myarray[63].replace("\"", "")+'\n' + myarray[64].replace("\"", "")+'\n'+ myarray[65].replace("\"","")
					+'\n'	+ myarray[66].replace("\"", "")+'\n' + myarray[67].replace("\"", "")+'\n' + myarray[68].replace("\"", "")+'\n' + myarray[69].replace("\"", "")+'\n');
			
		}
	}
	
