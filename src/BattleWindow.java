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
	JButton attackButton = new JButton("Attack");
	JButton fleeButton = new JButton("Flee");
	JButton examineButton = new JButton("Examine");
	JButton useItemButton = new JButton("Use item");
	
	JPanel subPanel = new JPanel();

	
	
	

	public BattleWindow()
	{
		window.setSize(500, 690);
		panel.setLayout(new BorderLayout());
		//ghostInfo 
		window.add(panel);
		subPanel.add(attackButton);
	    subPanel.add(fleeButton);
	    subPanel.add(examineButton);
	    subPanel.add(useItemButton); 
	    
	    panel.add(subPanel, BorderLayout.PAGE_END);
	    window.setVisible(true);
	    
		
	}	
}
