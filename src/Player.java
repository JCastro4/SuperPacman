
import java.awt.Color;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class Player extends Person
{
	protected int x, y;
	private ArrayList<Items> inventoryList = new ArrayList<Items>(); //ArrayList of items
//	Ghost ghost = new Ghost();
	Maze maze;

	public Player() 
	{
		this.setBackground(Color.green);
		this.setSize(Maze.panelSize, Maze.panelSize);
	}

	public void moveLeft() 
	{
		if((x > 0 && Maze.map[x - 1][y] == 1) || (x > 0 && Maze.map[x - 1][y] == 2)
				|| (x > 0 && Maze.map[x - 1][y] == 3) || (x > 0 && Maze.map[x - 1][y] == 4)
				|| (x > 0 && Maze.map[x - 1][y] == 5))
		{
			this.setLocation(this.getX() - 10, this.getY());
			x--;
		}
		if(Maze.map[x][y] == 2)
		{

			Maze.map[x][y] = 1;
			Maze.orbCount ++;
			autoPickupItems(Maze.map[x][y]);
		}
		if(Maze.map[x][y] == 4)
		{
			Ghost clyde = new Ghost("Clyde", "orange", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(clyde, this);
		}
		else if (Maze.map[x][y] == 5)
		{
			Ghost inky = new Ghost("Inky", "cyan", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(inky, this);
		}
		else if (Maze.map[x][y] == 6)
		{
			Ghost blinky = new Ghost("Blinky", "red", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(blinky, this);
		}
		else if (Maze.map[x][y] == 7)
		{
		}
		else if (Maze.map[x][y] == 8)
		{
		}
		else if (Maze.map[x][y] == 9)
		{
		}
		
		
	}

	public void moveRight() 
	{
		if((x < Maze.columns - 1 && Maze.map[x + 1][y] == 1)  || (x < Maze.columns - 1 && Maze.map[x + 1][y] == 2)
				|| (x < Maze.columns - 1 && Maze.map[x + 1][y] == 3) || (x < Maze.columns - 1 && Maze.map[x + 1][y] == 4)
				 || (x < Maze.columns - 1 && Maze.map[x + 1][y] == 5))
		{
			this.setLocation(this.getX() + 10, this.getY());
			x++;
			
		}
		if(Maze.map[x][y] == 2)
		{
			Maze.map[x][y] = 1;
			Maze.orbCount ++;
			autoPickupItems(Maze.map[x][y]);
		}
		if(Maze.map[x][y] == 4)
		{
			Ghost clyde = new Ghost("Clyde", "orange", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(clyde, this);
		}
		else if (Maze.map[x][y] == 5)
		{
			Ghost inky = new Ghost("Inky", "cyan", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(inky, this);
		}
		else if (Maze.map[x][y] == 6)
		{
			Ghost blinky = new Ghost("Blinky", "red", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(blinky, this);
		}
		else if (Maze.map[x][y] == 7)
		{
		}
		else if (Maze.map[x][y] == 8)
		{
		}
		else if (Maze.map[x][y] == 9)
		{
		}
	}

	public void moveUp() 
	{
		if((y > 0 && Maze.map[x][y - 1] == 1) || (y > 0 && Maze.map[x][y - 1] == 2)
				 || (y > 0 && Maze.map[x][y - 1] == 3) || (y > 0 && Maze.map[x][y - 1] == 4)
				 || (y > 0 && Maze.map[x][y - 1] == 5))
		{
			this.setLocation(this.getX(), this.getY() - 10);
			y--;
		}
		if(Maze.map[x][y] == 2)
		{
			Maze.map[x][y] = 1;
			Maze.orbCount ++;
			autoPickupItems(Maze.map[x][y]);
		}
		if(Maze.map[x][y] == 4)
		{
			Ghost clyde = new Ghost("Clyde", "orange", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(clyde, this);
		}
		else if (Maze.map[x][y] == 5)
		{
			Ghost inky = new Ghost("Inky", "cyan", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(inky, this);
		}
		else if (Maze.map[x][y] == 6)
		{
			Ghost blinky = new Ghost("Blinky", "red", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(blinky, this);
		}
		else if (Maze.map[x][y] == 7)
		{
		}
		else if (Maze.map[x][y] == 8)
		{
		}
		else if (Maze.map[x][y] == 9)
		{
		}
	}

	public void moveDown() 
	{
		if((y < Maze.rows - 1 && Maze.map[x][y + 1] == 1) || (y < Maze.rows - 1 && Maze.map[x][y + 1] == 2)
				 || (y < Maze.rows - 1 && Maze.map[x][y + 1] == 3) || (y < Maze.rows - 1 && Maze.map[x][y + 1] == 4)
				 || (y < Maze.rows - 1 && Maze.map[x][y + 1] == 5))
		{
			this.setLocation(this.getX(), this.getY() + 10);
			y++;
			
			if(Maze.map[x][y] == 2)
			{
				Maze.map[x][y] = 1;
				Maze.orbCount ++;
				autoPickupItems(Maze.map[x][y]);

			}
		}
		if(Maze.map[x][y] == 4)
		{
			Ghost clyde = new Ghost("Clyde", "orange", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(clyde, this);
		}
		else if (Maze.map[x][y] == 5)
		{
			Ghost inky = new Ghost("Inky", "cyan", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(inky, this);
		}
		else if (Maze.map[x][y] == 6)
		{
			Ghost blinky = new Ghost("Blinky", "red", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(blinky, this);
		}
		else if (Maze.map[x][y] == 7)
		{
		}
		else if (Maze.map[x][y] == 8)
		{
		}
		else if (Maze.map[x][y] == 9)
		{
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
//	@Override
//	public void receiveDamage()
//	{
//		setHealth(getHealth() - );
//		
//	}

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
			Maze.healthLabel.setText(getHealth() + 10 + "");
		}
		if(item == 3)
		{
			this.inventoryList.add(new Fruit(1, "Fruit", "A Yummy fruit.", 10));
			System.out.println(inventoryList.toString());
		}
	}
}
