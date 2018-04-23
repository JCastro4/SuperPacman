import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class BattleWindow implements ActionListener
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
	
	JPanel ghostPanel = new JPanel();
	JLabel ghostHealth;

	public BattleWindow(Ghost ghost)
	{
		window.setSize(500, 690);
		panel.setLayout(new BorderLayout());
		attackButton.addActionListener(this);
		window.add(panel);
		//ghostInfo
		ghostHealth = new JLabel("Health: " + );
		
		
		subPanel.add(attackButton);
	    subPanel.add(fleeButton);
	    subPanel.add(examineButton);
	    subPanel.add(useItemButton); 
	    panel.add(subPanel, BorderLayout.SOUTH);
	    
	    
	    
	    window.setVisible(true);
	    
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == attackButton)
		{
			System.out.println("attack");
		}
		
	}	
}
