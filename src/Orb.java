import java.util.ArrayList;

/**
 * Class: Orb
 * 
 * @author Jose Castro	Last Edited: 4/5/18
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
	
	@Override
	public String toString()
	{
		return "Orb [" + super.toString() +  ", levelIncrement = " + levelIncrement + "]";
	}

<<<<<<< HEAD
=======
	/*
	 * The user can use a orb to increase their attack, defense or overall health. 
	 * The orb can only increase one attribute at a time. 
	 * The orb is a consumable and is added to the inventory upon pick up. 
	 */
>>>>>>> 0b9762b86a3073281e4dd6805ef50d784569fbb5
	public static ArrayList<Orb> createOrbs()
	{
		//Creates a list for Orb objects.
		ArrayList<Orb> orbList = new ArrayList<>();
<<<<<<< HEAD
		//For loops creates 50 Orb objects and adds them to the list.
		for(int i = 0; i < 100; i++)
		{
			Orb orb = new Orb(i, "Orb", "An orb that can increase attack level.", 2);
=======
		//For loops creates 100 Orb objects and adds them to the list.
		for(int i = 0; i < 100; i++)
		{
			Orb orb = new Orb(i, "Orb", "An orb can increase the attack, defense or overall health.", 2);
>>>>>>> 0b9762b86a3073281e4dd6805ef50d784569fbb5
			orbList.add(orb);
		}
		//returns the list.
		return orbList;
	}
	
	public void useOrb()
	{
<<<<<<< HEAD
		//Set player's attack level here.
=======
		//Set player's attack, defense or health level here
>>>>>>> 0b9762b86a3073281e4dd6805ef50d784569fbb5
	}
}
