import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class BattleWindow
{
	JFrame window = new JFrame();
	JPanel panel = new JPanel();
	JPanel ghostStats = new JPanel();
	JTextField ghostsInfo = new JTextField();
	
	JPanel subPanel = new JPanel();

	
	
	

	public BattleWindow()
	{
		window.setSize(500, 690);
		panel.setLayout(new BorderLayout());
		//ghostInfo
		
		 
		window.add(panel);
		window.setVisible(true);
		
	
		
		subPanel.add( new JButton( "Attack" ));
	    subPanel.add( new JButton( "Flee" ));
	    subPanel.add( new JButton( "Examine" ));
	    subPanel.add(new JButton("Use Item")); 
	    
	    panel.add(subPanel, BorderLayout.PAGE_END);
	    
		
	}	
}
