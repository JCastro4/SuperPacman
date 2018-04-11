
import java.awt.Color;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class Player extends Person
{
	protected int x, y;
	private ArrayList<Items> inventoryList = new ArrayList<Items>(); //ArrayList of items
//	Ghost ghost = new Ghost();

	public Player() 
	{
		this.setBackground(Color.getHSBColor(0.3f, 0.3f, 1));
		this.setSize(Maze.panelSize, Maze.panelSize);
	}

	public void moveLeft() 
	{
		if(x > 0 && Maze.map[x - 1][y] != 0)
		{
			this.setLocation(this.getX() - 15, this.getY());
			x--;
		}
	}

	public void moveRight() 
	{
		if(x < Maze.columns - 1 && Maze.map[x + 1][y] != 0)
		{
			this.setLocation(this.getX()+15, this.getY());
			x++;
		}
	}

	public void moveUp() 
	{
		if(y > 0 && Maze.map[x][y - 1] != 0)
		{
			this.setLocation(this.getX(), this.getY() - 15);
			y--;
		}
	}

	public void moveDown() 
	{
		if(y < Maze.rows - 1 && Maze.map[x][y + 1] != 0)
		{
			this.setLocation(this.getX(), this.getY() + 15);
			y++;
		}
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
		Ghost.setHealth(Ghost.getHealth() - attack);
	}

	/* (non-Javadoc)
	 * @see Person#receiveDamage()
	 */
	@Override
	public void receiveDamage()
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the inventoryList
	 */
	public ArrayList<Items> getInventoryList()
	{
		return inventoryList;
	}

	/**
	 * @param inventoryList the inventoryList to set
	 */
	public void setInventoryList(ArrayList<Items> inventoryList)
	{
		this.inventoryList = inventoryList;
	}
//	public void autoPickupItems(int tileValue)
//	{
//		if(tileValue == 2)
//		{
//			Orb.
//		}
//	}
}
