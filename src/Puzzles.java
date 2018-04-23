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
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import jdk.nashorn.internal.ir.WhileNode;

public class Puzzles {

	private int puzzleID;

	private String description;

	private String hint;

	private String solution;

	ArrayList<String> puzzleList = new ArrayList<>();
	ArrayList<String> hintList = new ArrayList<>();
	ArrayList<String> solutionList = new ArrayList<>();
	ArrayList<String> puzzles = new ArrayList<>();


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

	public String getHint(int index)
	{
		return hintList.get(index);
	}

	public void setHint(String hint)
	{
		this.hint = hint;
	}

	public String getSolution(int index)
	{
		return solutionList.get(index);
	}

	public void setSolution(String solution)
	{
		this.solution = solution;
	}
	public String getPuzzle(int index)
	{
		return puzzles.get(index);
	}

	public void loadPuzzle() throws IOException
	{

		// Set file name & path     
		String puzzle = "Puzzle.txt";

		// Read in file
		FileInputStream in = new FileInputStream(puzzle);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));


		// Declare Array which will hold lines               
		//	ArrayList<String> list = new ArrayList<>();
		//	myarray = new String[175];
		String line;		 
		// Read each line into the array            
		while((line = br.readLine()) != null)
		{
			puzzleList.add(line);
		}
		int i = 0;
		do
		{
			puzzles.add(puzzleList.remove(i));
			hintList.add(puzzleList.remove(i));
			solutionList.add(puzzleList.remove(i));
		}
		while(!puzzleList.isEmpty());
		System.out.println("puzzles " + puzzles);
		System.out.println("hintList " + hintList);
		System.out.println("solutionList " + solutionList);
		//	while(br.readLine() != null);

		in.close();
	}
}

