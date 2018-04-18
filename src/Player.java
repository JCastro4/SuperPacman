
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
		this.setBackground(Color.green);
		this.setSize(Maze.panelSize, Maze.panelSize);
	}

	public void moveLeft() 
	{
		if(x > 0 && Maze.map[x - 1][y] != 0)
		{
			this.setLocation(this.getX() - 10, this.getY());
			x--;
		}
		if(Maze.map[x][y] == 2)
		{

			Maze.map[x][y] = 1;
			autoPickupItems(Maze.map[x][y]);
//			Maze.orbCount ++;
		}
		if(Maze.map[x][y] == 4)
		{
			BattleWindow battleWindow = new BattleWindow();
		}
	}

	public void moveRight() 
	{
		if(x < Maze.columns - 1 && Maze.map[x + 1][y] != 0)
		{
			this.setLocation(this.getX()+10, this.getY());
			x++;
			
		}
		if(Maze.map[x][y] == 2)
		{
			autoPickupItems(Maze.map[x][y]);
//			Maze.orbCount ++;
			Maze.map[x][y] = 1;
			Tile tile = new Tile(x, y); // Displays green tile for player
			tile.setBackground(Color.black);
		}
		if(Maze.map[x][y] == 4)
		{
			BattleWindow battleWindow = new BattleWindow();
		}
	}

	public void moveUp() 
	{
		if(y > 0 && Maze.map[x][y - 1] != 0)
		{
			this.setLocation(this.getX(), this.getY() - 10);
			y--;
		}
		if(Maze.map[x][y] == 2)
		{
			Maze.map[x][y] = 1;
//			Maze.orbCount ++;
			autoPickupItems(Maze.map[x][y]);
		}
		if(Maze.map[x][y] == 4)
		{
			BattleWindow battleWindow = new BattleWindow();
		}
	}

	public void moveDown() 
	{
		if(y < Maze.rows - 1 && Maze.map[x][y + 1] != 0)
		{
			this.setLocation(this.getX(), this.getY() + 10);
			y++;
			
			if(Maze.map[x][y] == 2)
			{
				autoPickupItems(Maze.map[x][y]);
//				Maze.orbCount ++;
				Maze.map[x][y] = 1;

			}
		}
		if(Maze.map[x][y] == 4)
		{
			BattleWindow battleWindow = new BattleWindow();
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
	
	public void autoPickupItems(int item)
	{
		if(item == 2)
		{
			Maze.orbCount ++;
			System.out.println("Orb count: " + Maze.orbCount);
		}
		if(item == 3)
		{
			this.inventoryList.add(new Fruit(1, "Fruit", "A Yummy fruit.", 10));
			System.out.println(inventoryList.toString());
		}
	}
}
