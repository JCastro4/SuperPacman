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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

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
	/*
	 * Create a method for puzzle which reads text file. 
	 * The method should be able to pull a random 
	 * Still a work in progress, ill finish up the code tonight. 
	 * 
	 * Needs to be able to check if the solution is correct based on the users input. 
	 * Needs to show the question: 
	 * Needs to show hint if note is picked up: 
	 * Read line by line and assign the description to a variable, assign the solution a variable, and assign the hint to a variable
	 */
	  // The name of the file to open.
	public void loadPuzzle(String puzzle) throws IOException
	{
	
     puzzle = "Puzzle.txt";

    // This will reference one line at a time
    String line = null;

    try {
        // FileReader reads text files 
        FileReader fileReader = new FileReader(puzzle);

       
        BufferedReader bufferedReader =  new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {  
            System.out.println(line);
        }   

        // Always close files.
        bufferedReader.close();         
    }
    catch(FileNotFoundException ex) {
        System.out.println("Unable to open file '" + puzzle + "'");                
    }
    catch(IOException ex) {
        System.out.println( "Error reading file '"  + puzzle + "'");                  
       
    }
		}
	}

