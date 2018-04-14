import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;



/**
 * 
 */

/**
 * @author Cesar Mauricio Romero-Pedraza
 *Apr 14, 2018
 * Purpose
 */
@SuppressWarnings("serial")
public class StatsDisplay extends JPanel
{
	JLabel healthLabel;
	JTextPane textPane;
	public StatsDisplay()
	{
		healthLabel = new JLabel("Health " + Player.getHealth());
		healthLabel.setVisible(true);
		textPane = new JTextPane();
		textPane.setSize(100, 100);
		textPane.setText("Test");
		textPane.setVisible(true);
		this.add(healthLabel);
		this.add(textPane);
		this.setVisible(true);
	}
}
