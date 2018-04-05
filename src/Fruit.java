import java.util.ArrayList;

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
	
	@Override
	public String toString()
	{
		return "Fruit ["+ super.toString() + ", healthIncrement= " + healthIncrement + "]";
	}

	public static ArrayList<Fruit> createFruits()
	{
		//Creates a list for fruit objects.
		ArrayList<Fruit> fruitList = new ArrayList<>();
		//For loops creates 50 fruit objects and adds them to the list.
		for(int i = 0; i < 50; i++)
		{
			Fruit fruit = new Fruit(i, "Fruit", "A Yummy fruit.", 5);
			fruitList.add(fruit);
		}
		//returns the list.
		return fruitList;
	}
	
	public void consumeFruit(Fruit fruit)
	{
		Player.setHealth(Player.getHealth() + fruit.healthIncrement);
	}
	
//	Test
//	public static void main(String [] args)
//	{
//		ArrayList<Fruit> list = new ArrayList<>();
//		list = createFruits();
//		
//		System.out.println(list.toString());
//
//	}
}
