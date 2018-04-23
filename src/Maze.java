
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.glassfish.external.statistics.Stats;

@SuppressWarnings("serial")
public class Maze extends JFrame implements ActionListener, KeyListener
{
	public static int rows = 80;
	public static int columns = 80;
	public static int panelSize = 10;
	public static int map[][] = new int[columns][rows];
	public static int endLevelLoc;
	public JPanel outputLabel;
	static int orbCount = 0;
	Player player;
	Tile tile;
	static boolean loadGame = false;
	int prevX, prevY;

	public JPanel maze ;
	public JPanel stats ;
	protected static JLabel attackLabel;
	protected static JLabel healthLabel;
	protected static JLabel orbNumLabel;
	public JButton saveButton = new JButton("Save Game");
	SaveLoadGame saveLoadGame = new SaveLoadGame();
	private int arrowStrokes = 0;

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e1)
	{
		// TODO Auto-generated method stub
		if(e1.getSource() == saveButton)
		{
			saveLoadGame.saveGame(Player.getHealth(), player.getAttack(), Player.x, Player.y);
			System.out.println("Saved Game");
			System.exit(0);
		}

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		int key = e.getKeyCode();

		//
		revalidate();
		repaint();

		//Navigation commands
		if(arrowStrokes == 20 || arrowStrokes == 40 || arrowStrokes == 60 
				|| arrowStrokes == 80 || arrowStrokes == 100 || arrowStrokes == 120 || arrowStrokes == 130
				|| arrowStrokes == 140 || arrowStrokes == 160 || arrowStrokes == 180 || arrowStrokes == 200
				|| arrowStrokes == 220 || arrowStrokes == 240 || arrowStrokes == 260 || arrowStrokes == 280
				|| arrowStrokes == 300 || arrowStrokes == 320 || arrowStrokes == 340 || arrowStrokes == 360)
		{
			PuzzleWindow puzzleWindow = new PuzzleWindow();
			//			PuzzleWindow.index++;
		}

		if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP || key == KeyEvent.VK_KP_UP)
		{
			player.moveUp();
			arrowStrokes++;
		}
		if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_KP_LEFT)
		{
			player.moveLeft();
			arrowStrokes++;
		}
		if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_KP_DOWN)
		{
			player.moveDown();
			arrowStrokes++;
		}
		if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_KP_RIGHT)
		{
			player.moveRight();
			arrowStrokes++;
		}
		if(orbCount == 100)
		{
			JOptionPane.showMessageDialog(null, "Congratulations, you've collected all " + orbCount, "Game Won!", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			new MainMenu();
		}

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	public Maze(String str)
	{
		maze = new JPanel();
		stats = new JPanel();
		player = new Player();
		attackLabel = new JLabel();
		healthLabel = new JLabel();
		orbNumLabel = new JLabel();
		outputLabel = new JPanel();
		player.setAttack(0);
		//		setFocusable(true);
		try
		{
			loadMap(str);
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setResizable(true);

		//this.setSize((columns*panelSize) + 500, (rows * panelSize) - 110);
		//		this.setSize((columns*panelSize) + 500, (rows * panelSize) - 110);
		this.setSize(1280, 720);

		//		maze.setSize((columns*panelSize) + 500, (rows * panelSize) - 110);


		this.setTitle("Super Pacman");
		//		this.setLayout(null);
		maze.setLayout(null);
		maze.setFocusable(true);
		this.setLayout(new BorderLayout());
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) 
			{
				//System.out.println((columns*panelSize)+50+"-"+((rows*panelSize)+70));
				System.exit(0);
			}
		});

		this.setLocationRelativeTo(null);



		//Create player

		//		this.add(player);
		//this.add(player);
		maze.add(player);
		//		this.add(comp)

		prevX = 16;
		prevY = 10;
		int tmpOrbCount = 0;
		//Color map
		for(int y = 0; y < 60; y++)
		{
			for(int x = 0; x < rows; x++)
			{
				tile = new Tile(x, y); // Displays green tile for player
				tile.setSize(panelSize, panelSize);
				tile.setLocation((x * panelSize) + 23, (y * panelSize) + 25);
				if(map[x][y] == 0)
				{
					tile.setBackground(Color.BLACK);
				}
				else if (map[x][y] == 2)
				{
					tile.setBackground(Color.blue); //blue for orb
					tmpOrbCount ++;//counts orbs on map for debugging

				}
				else if (map[x][y] == 3)
				{
					tile.setBackground(Color.pink); //pink for fruit
				}
				else if (map[x][y] == 4)
				{
					tile.setBackground(Color.RED);
				}
				else if (map[x][y] == 5)
				{
					tile.setBackground(Color.RED);
				}
				else if (map[x][y] == 6)
				{
					tile.setBackground(Color.RED);
				}
				else if (map[x][y] == 7)
				{
					tile.setBackground(Color.RED);
				}
				else if (map[x][y] == 8)
				{
					tile.setBackground(Color.RED);
				}
				else if (map[x][y] == 9)
				{
					tile.setBackground(Color.RED);
				}

				/*else if (map[x][y] == 7)
				{
					tile.setBackground(Color.yellow);;
				}*/
				else
				{
					tile.setBackground(Color.WHITE);
					tile.setWall(false);
					if(x == 0 && !loadGame)
					{
						//Initialize player location at start of game.
						player.setLocation((x * panelSize) + 23, (y * panelSize) + 25);
						Player.y = y;
					}
					else if (loadGame)
					{
						saveLoadGame.loadGame();
						player.setLocation((Player.x * panelSize) + 23, (Player.y * panelSize) + 25);
						//						player.setLocation(x,y);
						//						player.setLocation((prevX * panelSize) + 23, (prevY * panelSize) + 25);
						//						Player.x = x;
						//						Player.y = y;
					}
					//					if(x == columns - 1)
					//					{
					//						endLevelLoc = y;
					//					}
				}
				maze.add(tile);
				System.out.println("Orbs on map = " + tmpOrbCount);
				//				this.add(tile);
				//this.add((stats), BorderLayout.EAST);




				//this.setLayout(new BorderLayout());
				//this.add((tile), BorderLayout.WEST);


				//stats.setLayout(new BorderLayout());
				//stats.setAlignmentY(RIGHT_ALIGNMENT);
				//tile.setVisible(true);
			}
		}

		//attack = new JButton("Attack");

		//		maze = new JPanel();
		//
		//		stats = new JPanel();
		//		maze.addKeyListener(this);
		maze.setSize((columns * panelSize + 50), (rows * panelSize));
		//maze.add(tile);

		maze.addKeyListener(this);
		//this.add((maze), BorderLayout.WEST);
		stats.setSize(600, 200);

		stats.setBorder(new EmptyBorder(10, 10, 10, 300));
		//stats.setBackground(Color.BLUE);
		stats.setBackground(Color.darkGray);
		//stats.setBackground(Color.darkGray);
		stats.setLayout(new BorderLayout());
		saveButton.addActionListener(this);
		saveButton.setSize(20, 20);
		attackLabel.setText("Attack: " + player.getAttack());
		healthLabel.setText("Health: " + Player.getHealth());
		orbNumLabel.setText("Orbs: " + Maze.orbCount);
		outputLabel.setLayout(new BorderLayout());
		outputLabel.add(attackLabel, BorderLayout.NORTH);
		outputLabel.add(healthLabel,BorderLayout.SOUTH);
		outputLabel.add(orbNumLabel, BorderLayout.EAST);
		//		outputLabel.setOpaque(true);

		stats.add(outputLabel,BorderLayout.NORTH);
		stats.add(saveButton,BorderLayout.SOUTH);



		//stats.add(attack);
		//stats.setLocation(800, 10);
		maze.setBackground(Color.gray);
		//this.add((stats), BorderLayout.CENTER);

		//this.add((maze), BorderLayout.LINE_START);
		//this.add(maze);

		//		maze.add(tile);
		this.add(maze,BorderLayout.CENTER);
		this.add(stats,BorderLayout.LINE_END);
		//		maze.add(stats);
		//		this.add(maze);
		//		this.add(stats);
		//stats.add(attack);

		//this.add((stats), BorderLayout.LINE_END);
		//this.add(tile);
		player.setVisible(true);
		healthLabel.setVisible(true);
		attackLabel.setVisible(true);
		outputLabel.setVisible(true);
		tile.setVisible(true);
		maze.setVisible(true);
		stats.setVisible(true);
		this.setVisible(true);

		//this.setVisible(true);
	}

	public static void main(String args[])
	{
		new MainMenu();
	}

	public void loadMap(String str) throws IOException
	{
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(str));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) 
			{
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String mapStr = sb.toString();

			int counter = 0;
			for(int y = 0; y < columns; y++)
			{
				for(int x = 0; x < rows; x++)
				{
					String mapChar = mapStr.substring(counter, counter + 1);
					if(!mapChar.equals("\r\n") && !mapChar.equals("\n") && !mapChar.equals("\r"))
					{//If it's a number
						//System.out.print(mapChar);
						map[x][y] = Integer.parseInt(mapChar);
					}
					else
					{//If it is a line break
						x--;
						System.out.print(mapChar);
					}
					counter++;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Unable to load existing map(if exists), creating new map.");
		}
		finally 
		{
			br.close();
		}
	}
}