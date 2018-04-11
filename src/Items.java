/*
 * We have 3 items 
 * Orb's (main item: gives user stat's: Health, Defense, Attack) Each orb will increase attack, defense or health by 2, user choice. 
 * Total 100 orb's in the game. 
 * Note (Puzzles): Will be in random locations will give user's clues or answer to the puzzle. 
 * Fruit (health item): Increase the user's health by 5 points 
 */
public class Items
{
	private int itemID;

	private String itemName;

	private String description;

	public Items(int itemID, String itemName, String description)
	{
//		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.description = description;
	}

	public int getItemID()
	{
		return 0;
	}

	public String getItemName()
	{
		return null;
	}

	public void setItemName()
	{

	}

	public String getDescription()
	{
		return null;
	}

	public void setDescription()
	{

	}

	@Override
	public String toString()
	{
		return "itemID = " + itemID + ", itemName = " + itemName + ", description = " + description;
	}
	
}
