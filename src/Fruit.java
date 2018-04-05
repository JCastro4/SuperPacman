/**
 * Class: Fruit
 * 
 * @author Jose Castro	Last Edited: 4/5/18
 *
 */

public class Fruit extends Items
{
	private int healthIncrement;
	
	public Fruit(int itemID, String itemName, String description, int healthIncrement)
	{
		super(itemID, itemName, description);
		this.healthIncrement = healthIncrement;
	}

	public int getHealthIncrement()
	{
		return healthIncrement;
	}

	public void setHealthIncrement(int healthIncrement)
	{
		this.healthIncrement = healthIncrement;
	}
	
	public void consumeFruit()
	{

	}
}
