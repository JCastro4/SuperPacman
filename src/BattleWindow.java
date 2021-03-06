import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BattleWindow implements ActionListener
{
	JFrame window = new JFrame();
	JPanel panel = new JPanel();
	JPanel ghostStats = new JPanel();
	JTextField outputText = new JTextField();
	JButton attackButton = new JButton("Attack");
	JButton fleeButton = new JButton("Flee");
	JButton examineButton = new JButton("Examine");
	JButton useItemButton = new JButton("Use item");
	JPanel subPanel = new JPanel();

	JPanel ghostPanel = new JPanel();
	JPanel playerPanel = new JPanel();
	JLabel ghostHealth, ghostAttack, ghostDefence, ghostAccuracy, playerHealth, playerAttack, playerDefence, title;
	static int indexGhost = 0;
	public BattleWindow(Ghost ghost, Player player)
	{
		try
		{
			Ghost.loadGhost();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.setSize(700, 700);
		panel.setLayout(new BorderLayout());
		attackButton.addActionListener(this);
		examineButton.addActionListener(this);
		fleeButton.addActionListener(this);
		window.add(panel);

		// ghostInfo

		ghostHealth = new JLabel("<html><font color='white'>Health: " + ghost.getHealth() + "</font></html>");
		ghostAttack = new JLabel("<html><font color='white'>Attack Level: " + ghost.getAttack() + "</font></html>");
		ghostDefence = new JLabel("<html><font color='white'>Defence Level: " + ghost.getDefense() + "</font></html>");
		ghostAccuracy = new JLabel("<html><font color='white'>Accuracy: " + ghost.getAccuracy(indexGhost) + "</font></html>");

		GridLayout gridLayout = new GridLayout(4, 1);
		ghostPanel.setLayout(gridLayout);
		ghostPanel.add(ghostHealth);
		ghostPanel.add(ghostAttack);
		ghostPanel.add(ghostDefence);
		ghostPanel.add(ghostAccuracy);
		ghostPanel.setBackground(Color.DARK_GRAY);
		panel.add(ghostPanel, BorderLayout.EAST);

		// playerinfo
		playerHealth = new JLabel("<html><font color='white'>Health: " + player.getHealth() + "</font></html>");
		playerAttack = new JLabel("<html><font color='white'>Attack: " + player.getAttack() + "</font></html>");
		playerDefence = new JLabel("<html><font color='white'>Defence: " + player.getDefense() + "</font></html>");

		playerPanel.setLayout(gridLayout);
		playerPanel.add(playerHealth);
		playerPanel.add(playerAttack);
		playerPanel.add(playerDefence);
		playerPanel.setBackground(Color.DARK_GRAY);
		panel.add(playerPanel, BorderLayout.WEST);

		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new GridLayout(1, 3));
		title = new JLabel("<html><font color='white'>Battle against " + ghost.getName() + "</font></html>");
		titlePanel.add(new JLabel(""));
		titlePanel.add(title);
		titlePanel.add(new JLabel(""));
		titlePanel.setBackground(Color.DARK_GRAY);
		panel.add(titlePanel, BorderLayout.NORTH);

		subPanel.add(attackButton);
		subPanel.add(fleeButton);
		subPanel.add(examineButton);
		subPanel.add(useItemButton);
		panel.add(subPanel, BorderLayout.SOUTH);

		ImageIcon image = new ImageIcon("Fighting Scene.jpg");
		JLabel imageLabel = new JLabel(image);
		Panel imagePanel = new Panel();
		imagePanel.add(imageLabel);
		panel.add(imagePanel, BorderLayout.CENTER);

		subPanel.setBackground(Color.DARK_GRAY);
		panel.setBackground(Color.DARK_GRAY);
		window.add(outputText, BorderLayout.SOUTH);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == attackButton)
		{
			if(Ghost.getHealth() <= 0)
			{
				JOptionPane.showMessageDialog(null, "You defeated the ghost", "Continue game!", JOptionPane.INFORMATION_MESSAGE);
				window.dispose();//closes window
			}
			Ghost.setHealth((int)(Ghost.getHealth() - (Player.attack * .25)));
			ghostHealth.setText("<html><font color='white'>Health: " + Integer.toString(Ghost.getHealth()) + "</font></html>");
		}

		if (e.getSource() == examineButton)
		{
			outputText.setText(Ghost.getGhostName(indexGhost) + 
			Ghost.getGhostColor(indexGhost) +
			Ghost.getGhostDescription(indexGhost)); 
//			+ Ghost.getGhostHP(indexGhost)
//			+ Ghost.getGhostAttack(indexGhost) + Ghost.getGhostAccuracy(indexGhost)
//			+ Ghost.getDefense(indexGhost));
//			
//			HPList.add(ghostList.remove(i));
//			attackList.add(ghostList.remove(i));
//			accuracyList.add(ghostList.remove(i));
//			defenseList.add(ghostList.remove(i));
			
		}
		if(e.getSource() == fleeButton)
		{
			window.dispose();
		}
	}
}
