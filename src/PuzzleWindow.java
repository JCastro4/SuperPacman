import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author Cesar Mauricio Romero-Pedraza
 *Apr 23, 2018
 * Purpose
 */
public class PuzzleWindow implements ActionListener
{
	JFrame window = new JFrame("Puzzle found on map");
	JPanel panel = new JPanel();
	JPanel puzzlePanel = new JPanel();
	JTextField outputText = new JTextField();
	JTextField inputText = new JTextField();
	JButton solveButton = new JButton("Solve");
	JButton hintButton = new JButton("Hint");
	//	JButton examineButton = new JButton("Examine");
	//	JButton useItemButton = new JButton("Use item");
	JPanel subPanel = new JPanel();
	String puzzle;
	String hint;
	String answer;
	static int index = 0;
	Puzzles puzzles = new Puzzles();
	public PuzzleWindow()
	{
		//		Puzzles puzzles = new Puzzles();
		try
		{
			puzzles.loadPuzzle();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.setSize(700, 500);
		window.setLayout(new BorderLayout());
		panel.add(solveButton);
		panel.add(hintButton);
		solveButton.addActionListener(this);
		hintButton.addActionListener(this);
		window.add(panel, BorderLayout.NORTH);
		outputText.setText(puzzles.getPuzzle(index));
		window.add(outputText,BorderLayout.CENTER);
		window.add(inputText,BorderLayout.SOUTH);
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
		if(e.getSource() == solveButton)
		{
			String userAnswer;
			answer = puzzles.getSolution(index);
			userAnswer = inputText.getText();
			if(userAnswer.equals(answer))
			{
				outputText.setText("Correct");
			}
			else
			{
				outputText.setText("Incorrect");
			}

		}
		if(e.getSource() == hintButton)
		{
			outputText.setText(puzzles.getHint(index));
		}

	}
}
