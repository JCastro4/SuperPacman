import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;



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
	JPanel playerPanel = new JPanel();
	JLabel ghostHealth, ghostAttack, ghostDefence, ghostAccuracy,
			playerHealth, playerAttack, playerDefence, title;

	public BattleWindow(Ghost ghost, Player player)
	{
		window.setSize(500, 690);
		panel.setLayout(new BorderLayout());
		attackButton.addActionListener(this);
		window.add(panel);
		
		//ghostInfo

		ghostHealth = new JLabel("Health: " + ghost.getHealth());
		ghostAttack = new JLabel("Attack Level: " + ghost.getAttack());
		ghostDefence = new JLabel("Defense Level: " + ghost.getDefense());
		ghostAccuracy = new JLabel("Accuracy: " + ghost.getAccuracy());
		
		GridLayout gridLayout = new GridLayout(4, 1);
		ghostPanel.setLayout(gridLayout);
		ghostPanel.add(ghostHealth);
		ghostPanel.add(ghostAttack);
		ghostPanel.add(ghostDefence);
		ghostPanel.add(ghostAccuracy);
		panel.add(ghostPanel, BorderLayout.EAST);
		
		//playerinfo
		playerHealth = new JLabel("Health: " + player.getHealth());
		playerAttack = new JLabel("Attack: " + player.getAttack());
		playerDefence = new JLabel("Defense: " + player.getDefense());

		
		playerPanel.setLayout(gridLayout);
		playerPanel.add(playerHealth);
		playerPanel.add(playerAttack);
		playerPanel.add(playerDefence);
		panel.add(playerPanel, BorderLayout.WEST);
		
		JPanel titlePane = new JPanel();
		titlePane.setLayout(new GridLayout(1, 3));
		title = new JLabel("Battle against " + ghost.getName());
		titlePane.add(new JLabel(""));
		titlePane.add(title);
		titlePane.add(new JLabel(""));
		panel.add(titlePane, BorderLayout.NORTH);
		
		subPanel.add(attackButton);
	    subPanel.add(fleeButton);
	    subPanel.add(examineButton);
	    subPanel.add(useItemButton); 
	    panel.add(subPanel, BorderLayout.SOUTH);
	    
	    
	    window.setLocationRelativeTo(null);
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
