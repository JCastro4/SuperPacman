

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

public class Ghost extends Person
{
	private int accuracy;
//	private String color;
//	private String description;
	Player player = new Player();
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
		player.setHealth(player.getHealth() - attack );
		
	}

	/* (non-Javadoc)
	 * @see Person#receiveDamage()
	 */
	@Override
	public void receiveDamage()
	{
		// TODO Auto-generated method stub
		
	}
	public void createGhosts() // 
	{
		Ghost Clyde = new Ghost(color, color, color, accuracy, accuracy, accuracy, accuracy);
		Ghost Inky = new Ghost(color, color, color, accuracy, accuracy, accuracy, accuracy);
		Ghost Blinky = new Ghost(color, color, color, accuracy, accuracy, accuracy, accuracy);
		Ghost Pinky = new Ghost(color, color, color, accuracy, accuracy, accuracy, accuracy);
		Ghost ghost = new Ghost(color, color, color, accuracy, accuracy, accuracy, accuracy);
		Ghost ghost0 = new Ghost(color, color, color, accuracy, accuracy, accuracy, accuracy);
		Ghost ghost2 = new Ghost(color, color, color, accuracy, accuracy, accuracy, accuracy);
		Ghost ghost3 = new Ghost(color, color, color, accuracy, accuracy, accuracy, accuracy);
		Ghost ghost4 = new Ghost(color, color, color, accuracy, accuracy, accuracy, accuracy);
		
	}
}
