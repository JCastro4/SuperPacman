
import java.awt.Color;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class Player extends Person
{
	protected static int x;
	protected static int y;
	protected static int attack;
	/**
	 * @return the attack
	 */
	public int getAttack()
	{
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack)
	{
		Player.attack = attack;
	}

	private ArrayList<Items> inventoryList = new ArrayList<Items>(); //ArrayList of items
	//	Ghost ghost = new Ghost();
	Maze maze;

	public Player() 
	{
		this.setBackground(Color.green);
		this.setSize(Maze.panelSize, Maze.panelSize);
		Player.setHealth(100);
		this.attack = 1;

	}

	public void moveLeft() 
	{
		if((x > 0 && Maze.map[x - 1][y] == 1) || (x > 0 && Maze.map[x - 1][y] == 2)
				|| (x > 0 && Maze.map[x - 1][y] == 3) || (x > 0 && Maze.map[x - 1][y] == 4)
				|| (x > 0 && Maze.map[x - 1][y] == 5) || (x > 0 && Maze.map[x - 1][y] == 6)
				|| (x > 0 && Maze.map[x - 1][y] == 7) || (x > 0 && Maze.map[x - 1][y] == 8)
				|| (x > 0 && Maze.map[x - 1][y] == 9));
		{
			this.setLocation(this.getX() - 10, this.getY());
			x--;
		}
		if(Maze.map[x][y] == 2)
		{

			Maze.map[x][y] = 1;
			Maze.orbCount ++;
			autoPickupItems(Maze.map[x][y]);
			Player.attack++;
			Maze.attackLabel.setText("Attack: " + Player.attack);
		}
		if(Maze.map[x][y] == 4)
		{
			BattleWindow.indexGhost = 0;
			Ghost pinky = new Ghost("Pinky", "Pink", "description", 100, 80, 60, 50/50);
			BattleWindow battleWindow = new BattleWindow(pinky, this);
		}
		else if (Maze.map[x][y] == 5)
		{
			BattleWindow.indexGhost = 1;
			Ghost blinky = new Ghost("Blinky", "red", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(blinky, this);
		}
		else if (Maze.map[x][y] == 6)
		{
			BattleWindow.indexGhost = 3;
			Ghost inky = new Ghost("Inky", "cyan", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(inky, this);
		}
		else if (Maze.map[x][y] == 7)
		{
			BattleWindow.indexGhost = 4;
			Ghost clyde = new Ghost("Clyde", "orange", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(clyde, this);
		}
		else if (Maze.map[x][y] == 8)
		{
			BattleWindow.indexGhost = 5;
			Ghost blueGhost1 = new Ghost("Blue Ghost 1", "blue", "description", 50, 50, 30, 30/70);
			BattleWindow battleWindow = new BattleWindow(blueGhost1, this);
		}
		else if (Maze.map[x][y] == 9)
		{
			BattleWindow.indexGhost = 6;
			Ghost blueGhost2 = new Ghost("Blue Ghost 2", "blue", "description", 50, 50, 30, 30/70);
			BattleWindow battleWindow = new BattleWindow(blueGhost2, this);
		}


	}

	public void moveRight() 
	{
		if((x < Maze.columns - 1 && Maze.map[x + 1][y] == 1)  || (x < Maze.columns - 1 && Maze.map[x + 1][y] == 2)
				|| (x < Maze.columns - 1 && Maze.map[x + 1][y] == 3) || (x < Maze.columns - 1 && Maze.map[x + 1][y] == 4)
				|| (x < Maze.columns - 1 && Maze.map[x + 1][y] == 5)|| (x < Maze.columns - 1 && Maze.map[x + 1][y] == 6)
				|| (x < Maze.columns - 1 && Maze.map[x + 1][y] == 7)|| (x < Maze.columns - 1 && Maze.map[x + 1][y] == 8)
				|| (x < Maze.columns - 1 && Maze.map[x + 1][y] == 9))
		{
			this.setLocation(this.getX() + 10, this.getY());
			x++;

		}
		if(Maze.map[x][y] == 2)
		{
			Maze.map[x][y] = 1;
			Maze.orbCount ++;
			Player.attack++;
			autoPickupItems(Maze.map[x][y]);
			Maze.attackLabel.setText("Attack: " + Player.attack);
		}
		if(Maze.map[x][y] == 4)
		{
			Ghost pinky = new Ghost("Pinky", "Pink", "description", 100, 80, 60, 50/50);
			BattleWindow battleWindow = new BattleWindow(pinky, this);
		}
		else if (Maze.map[x][y] == 5)
		{
			Ghost blinky = new Ghost("Blinky", "red", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(blinky, this);
		}
		else if (Maze.map[x][y] == 6)
		{
			Ghost inky = new Ghost("Inky", "cyan", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(inky, this);
		}
		else if (Maze.map[x][y] == 7)
		{
			Ghost clyde = new Ghost("Clyde", "orange", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(clyde, this);
		}
		else if (Maze.map[x][y] == 8)
		{
			Ghost blueGhost1 = new Ghost("Blue Ghost 1", "blue", "description", 50, 50, 30, 30/70);
			BattleWindow battleWindow = new BattleWindow(blueGhost1, this);
		}
		else if (Maze.map[x][y] == 9)
		{
			Ghost blueGhost2 = new Ghost("Blue Ghost 2", "blue", "description", 50, 50, 30, 30/70);
			BattleWindow battleWindow = new BattleWindow(blueGhost2, this);
		}
	}

	public void moveUp() 
	{
		if((y > 0 && Maze.map[x][y - 1] == 1) || (y > 0 && Maze.map[x][y - 1] == 2)
				|| (y > 0 && Maze.map[x][y - 1] == 3) || (y > 0 && Maze.map[x][y - 1] == 4)
				|| (y > 0 && Maze.map[x][y - 1] == 5) || (y > 0 && Maze.map[x][y - 1] == 6)
				|| (y > 0 && Maze.map[x][y - 1] == 7) || (y > 0 && Maze.map[x][y - 1] == 8)
				|| (y > 0 && Maze.map[x][y - 1] == 9))
		{
			this.setLocation(this.getX(), this.getY() - 10);
			y--;
		}
		if(Maze.map[x][y] == 2)
		{
			Maze.map[x][y] = 1;
			Maze.orbCount ++;
			autoPickupItems(Maze.map[x][y]);
			Player.attack++;
			Maze.attackLabel.setText("Attack: " + Player.attack);
		}
		if(Maze.map[x][y] == 4)
		{
			Ghost pinky = new Ghost("Pinky", "Pink", "description", 100, 80, 60, 50/50);
			BattleWindow battleWindow = new BattleWindow(pinky, this);
		}
		else if (Maze.map[x][y] == 5)
		{
			Ghost blinky = new Ghost("Blinky", "red", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(blinky, this);
		}
		else if (Maze.map[x][y] == 6)
		{
			Ghost inky = new Ghost("Inky", "cyan", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(inky, this);
		}
		else if (Maze.map[x][y] == 7)
		{
			Ghost clyde = new Ghost("Clyde", "orange", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(clyde, this);
		}
		else if (Maze.map[x][y] == 8)
		{
			Ghost blueGhost1 = new Ghost("Blue Ghost 1", "blue", "description", 50, 50, 30, 30/70);
			BattleWindow battleWindow = new BattleWindow(blueGhost1, this);
		}
		else if (Maze.map[x][y] == 9)
		{
			Ghost blueGhost2 = new Ghost("Blue Ghost 2", "blue", "description", 50, 50, 30, 30/70);
			BattleWindow battleWindow = new BattleWindow(blueGhost2, this);
		}
	}

	public void moveDown() 
	{
		if((y < Maze.rows - 1 && Maze.map[x][y + 1] == 1) || (y < Maze.rows - 1 && Maze.map[x][y + 1] == 2)
				|| (y < Maze.rows - 1 && Maze.map[x][y + 1] == 3) || (y < Maze.rows - 1 && Maze.map[x][y + 1] == 4)
				|| (y < Maze.rows - 1 && Maze.map[x][y + 1] == 5) || (y < Maze.rows - 1 && Maze.map[x][y + 1] == 6)
				|| (y < Maze.rows - 1 && Maze.map[x][y + 1] == 7) || (y < Maze.rows - 1 && Maze.map[x][y + 1] == 8)
				|| (y < Maze.rows - 1 && Maze.map[x][y + 1] == 9))
		{
			this.setLocation(this.getX(), this.getY() + 10);
			y++;

			if(Maze.map[x][y] == 2)
			{
				Maze.map[x][y] = 1;
				Maze.orbCount ++;
				autoPickupItems(Maze.map[x][y]);
				Player.attack++;
				Maze.attackLabel.setText("Attack: " + Player.attack);
			}
		}
		if(Maze.map[x][y] == 4)
		{
			Ghost pinky = new Ghost("Pinky", "Pink", "description", 100, 80, 60, 50/50);
			BattleWindow battleWindow = new BattleWindow(pinky, this);
		}
		else if (Maze.map[x][y] == 5)
		{
			Ghost blinky = new Ghost("Blinky", "red", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(blinky, this);
		}
		else if (Maze.map[x][y] == 6)
		{
			Ghost inky = new Ghost("Inky", "cyan", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(inky, this);
		}
		else if (Maze.map[x][y] == 7)
		{
			Ghost clyde = new Ghost("Clyde", "orange", "description", 75, 60, 40, 40/60);
			BattleWindow battleWindow = new BattleWindow(clyde, this);
		}
		else if (Maze.map[x][y] == 8)
		{
			Ghost blueGhost1 = new Ghost("Blue Ghost 1", "blue", "description", 50, 50, 30, 30/70);
			BattleWindow battleWindow = new BattleWindow(blueGhost1, this);
		}
		else if (Maze.map[x][y] == 9)
		{
			Ghost blueGhost2 = new Ghost("Blue Ghost 2", "blue", "description", 50, 50, 30, 30/70);
			BattleWindow battleWindow = new BattleWindow(blueGhost2, this);
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
