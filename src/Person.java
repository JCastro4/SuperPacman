import javax.swing.JPanel;
/**
 * 
 */

/**
 * @author Cesar Mauricio Romero-Pedraza
 *Apr 2, 2018
 * Purpose
 */
public class Person extends JPanel
{
	private int health;
	private int attack;
	private int defence;
	/**
	 * @return the health
	 */
	public int getHealth()
	{
		return health;
	}
	/**
	 * @param health the health to set
	 */
	public void setHealth(int health)
	{
		this.health = health;
	}
}
