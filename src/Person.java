import javax.swing.JPanel;
/**
 * 
 */

/**
 * @author Cesar Mauricio Romero-Pedraza
 *Apr 2, 2018
 * Purpose
 */
@SuppressWarnings("serial")
public abstract class Person extends JPanel
{
	private static int health = 50;
	private int attack;
	private int defense;
	private String name;
	/**
	 * @return the health
	 */
	public static int getHealth()
	{
		return health;
	}
	/**
	 * @param health the health to set
	 */
	public static void setHealth(int health)
	{
		Person.health = health;
	}
	
	//Edited by Boji Benji 4/2/18
	/**
	 * @return the attack
	 */
	public int getAttack()
	{
		return attack; 
	}
	
	/**
	 * @param attack to set
	 */
	public void setAttack(int attack)
	{
		this.attack = attack; 
	}
	
	/**
	 * @return the defense
	 */
	public int getDefense()
	{
		return defense; 
	}
	
	/**
	 * @param defense to set
	 */
	public void setDefense(int defense)
	{
		this.defense = defense; 
	}
	
	public abstract void attack();
	public abstract void dealDamage(int attack);
//	public abstract void receiveDamage();
	
	/*Might require a update class if user collects more orb's the attack, health, defense will all change. 
	 * Might need deal damage/ receive damage 
	 * Might need attack command
	 * Might need run(flee) command 
	 * Might need examine command 
	*/
}
