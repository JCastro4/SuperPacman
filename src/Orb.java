/**
 * 
 * @author Jose Castro Last Edited: 4/5/18
 *
 */

public class Orb extends Items
{
	private int levelIncrement;

	public Orb(int itemID, String itemName, String description, int levelIncrement)
	{
		super(itemID, itemName, description);
		this.levelIncrement = levelIncrement;
	}

	public int getLevelIncrement()
	{
		return levelIncrement;
	}

	public void setLevelIncrement(int levelIncrement)
	{
		this.levelIncrement = levelIncrement;
	}

	public void useOrb()
	{

	}
}
