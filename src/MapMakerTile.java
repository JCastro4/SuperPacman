
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MapMakerTile extends JPanel
{
	int x, y;

	public MapMakerTile(int x, int y)
	{
		this.x = x;
		this.y = y;

		addMouseListener(new MouseAdapter()
		{
			// add condition for 2 for fruit and 3 for orb
			//Load image of orb or fruit instead of color. If we do not figure out how
			//to do this we can just use a color for now.
			public void mousePressed(MouseEvent e) 
			{
				if(e.getButton() == MouseEvent.BUTTON1)
				{
					setBackground(Color.WHITE);
					MazeMapMaker.map[x][y] = 1;
				}
				if(e.getButton() == MouseEvent.BUTTON3)
				{
					setBackground(Color.GRAY);
					MazeMapMaker.map[x][y] = 0;
				}
			}


		});
	}
}
