import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BattleWindow
{
	JFrame window = new JFrame();
	JPanel panel = new JPanel();
	JPanel ghostStats = new JPanel();
	JTextField ghostsInfo = new JTextField();
	
	public BattleWindow()
	{
		window.setSize(400, 400);
		panel.setLayout(new BorderLayout());
		//ghostInfo
		
		 
		window.add(panel);
		window.setVisible(true);
	}	
}
