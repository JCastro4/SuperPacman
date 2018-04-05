/**
 * Class: Puzzles
 * 
 * @author Jose Castro
 * @author Boji Benji
 *
 *	Purpose:
 *	Puzzle in this game should allows the user to move threw the maze easier
 *	(shortcuts) if the user answer the question correctly.
 *	Note gives hints to the user.
 */

public class Puzzles {

	private int puzzleID;

	private String description;

	private String hint;

	private String solution;

	public Puzzles(int puzzleID, String description, String hint, String solution)
	{
		super();
		this.puzzleID = puzzleID;
		this.description = description;
		this.hint = hint;
		this.solution = solution;
	}

	public int getPuzzleID()
	{
		return puzzleID;
	}

	public void setPuzzleID(int puzzleID)
	{
		this.puzzleID = puzzleID;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getHint()
	{
		return hint;
	}

	public void setHint(String hint)
	{
		this.hint = hint;
	}

	public String getSolution()
	{
		return solution;
	}

	public void setSolution(String solution)
	{
		this.solution = solution;
	}
	
}
