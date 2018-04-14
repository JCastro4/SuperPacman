
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Maze extends JFrame
{
	public static int rows = 80;
	public static int columns = 80;
	public static int panelSize = 10;
	public static int map[][] = new int[columns][rows];
	public static int endLevelLoc;
	public JLabel outputLabel;
	static int orbCount = 0;
	Player player;
	StatsDisplay statsDisplay = new StatsDisplay();

	public Maze(String str)
	{
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

		this.setSize((columns*panelSize) + 500, (rows * panelSize) - 110);

		this.setTitle("Super Pacman");
		this.setLayout(null);
		this.add(statsDisplay, BorderLayout.EAST);
//		this.setLayout();

		this.addKeyListener(new KeyListener()
		{

			@Override
			public void keyPressed(KeyEvent e) 
			{
				int key = e.getKeyCode();

				revalidate();
				repaint();

				//Navigation commands

				if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP || key == KeyEvent.VK_KP_UP)
				{
					player.moveUp();
				}
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_KP_LEFT)
				{
					player.moveLeft();
				}
				if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_KP_DOWN)
				{
					player.moveDown();
				}
				if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_KP_RIGHT)
				{
					player.moveRight();
				}

//				if(player.x == columns-1 && player.y == endLevelLoc)
				if(orbCount == 1)
				{
					JOptionPane.showMessageDialog(null, "Congratulations, you've collected all 100 orbs", "Game Won!", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new MainMenu();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) 
			{
				// TODO Auto-generated method stub

			}

		});

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
		player = new Player();
		player.setVisible(true);
		this.add(player);
//		this.add(comp)
		

		//Color map
		for(int y = 0; y < 60; y++)
		{
			for(int x = 0; x < rows; x++)
			{
				Tile tile = new Tile(x, y); // Displays green tile for player
				tile.setSize(panelSize, panelSize);
				tile.setLocation((x*panelSize) + 23, (y*panelSize) + 25);
				if(map[x][y] == 0)
				{
					tile.setBackground(Color.BLACK);
				}
				else if (map[x][y] == 2)
				{
					tile.setBackground(Color.blue); //blue for orb
					
				}
				else if (map[x][y] == 3)
				{
					tile.setBackground(Color.pink); //pink for fruit
				}
				else
				{
					tile.setBackground(Color.WHITE);
					tile.setWall(false);
					if(x == 0)
					{
						player.setLocation((x * panelSize) + 23, (y * panelSize) + 25);
						player.y = y;
					}
					if(x == columns - 1)
					{
						endLevelLoc = y;
					}
				}

				tile.setVisible(true);
				this.add(tile);
			}
		}
		this.setVisible(true);
		
		
	
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