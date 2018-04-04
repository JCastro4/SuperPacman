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
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see Person#dealDamage()
	 */
	@Override
	public void dealDamage()
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see Person#receiveDamage()
	 */
	@Override
	public void receiveDamage()
	{
		// TODO Auto-generated method stub
		
	}
}
