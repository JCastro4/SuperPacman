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
import java.util.PriorityQueue;
import java.util.Stack;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import jdk.nashorn.internal.ir.WhileNode;

public class Puzzles {

	private int puzzleID;

	private String description;

	private String hint;

	private String solution;

//	ArrayList<String> puzzleList = new ArrayList<>();
//	ArrayList<String> hintList = new ArrayList<>();
//	ArrayList<String> solutionList = new ArrayList<>();
//	ArrayList<String> puzzles = new ArrayList<>();
//	Stack<String> puzzleList = new Stack<>();
//	Stack<String> hintList = new Stack<>();
//	Stack<String> solutionList = new Stack<>();
//	Stack<String> puzzles = new Stack<>();
	PriorityQueue<String> puzzleList = new PriorityQueue<>();
	Stack<String> hintList = new Stack<>();
	Stack<String> solutionList = new Stack<>();
	Stack<String> puzzles = new Stack<>();

	//	public Puzzles(int puzzleID, String description, String hint, String solution)
	//	{
	//		super();
	//		this.puzzleID = puzzleID;
	//		this.description = description;
	//		this.hint = hint;
	//		this.solution = solution;
	//	}

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
			//	puzzleList.add(br.readLine());
			//	hintList.add(br.readLine());
			//	solutionList.add(br.readLine());
			puzzleList.add(line);
//			break;
//			hintList.add(line);
//			break;
//			solutionList.add(line);
//			break;
		}
		int i = 0;
		do
		{
			puzzles.add(puzzleList.poll());
			hintList.add(puzzleList.poll());
			solutionList.add(puzzleList.poll());
		}
		while(!puzzleList.isEmpty());
		//	while(br.readLine() != null);

		in.close();
//		System.out.println(puzzleList.get(0));

		//	System.out.println(myarray[1].replace("\"", ""));

		//I was we could call the puzzle, for example: Upon item pick up or interaction it shows a specific description 
		//Based on its location? Or I was think of pulling the puzzle a random order. 
		// Print out array info in desired order. Delete " characters       
		/*
		 * Shows description 
		 * ++4
	1	System.out.println(myarray[1].replace("\"", ""));
	2	System.out.println(myarray[5].replace("\"", ""));
	3	System.out.println(myarray[9].replace("\"", ""));
	4	System.out.println(myarray[13].replace("\"", ""));
	5	System.out.println(myarray[17].replace("\"", ""));
	6	System.out.println(myarray[21].replace("\"", ""));
	7	System.out.println(myarray[25].replace("\"", ""));
	8	System.out.println(myarray[29].replace("\"", ""));
	9	System.out.println(myarray[33].replace("\"", ""));
	10	System.out.println(myarray[37].replace("\"", ""));
	11	System.out.println(myarray[41].replace("\"", ""));
	12	System.out.println(myarray[45].replace("\"", ""));
	13	System.out.println(myarray[49].replace("\"", ""));
	14	System.out.println(myarray[53].replace("\"", ""));
	15	System.out.println(myarray[57].replace("\"", ""));
	16	System.out.println(myarray[61].replace("\"", ""));
	17	System.out.println(myarray[65].replace("\"", ""));
	18	System.out.println(myarray[69].replace("\"", ""));
	19	System.out.println(myarray[73].replace("\"", ""));
	20	System.out.println(myarray[77].replace("\"", ""));
	21	System.out.println(myarray[81].replace("\"", ""));
	22	System.out.println(myarray[85].replace("\"", ""));
	23	System.out.println(myarray[89].replace("\"", ""));
	24	System.out.println(myarray[93].replace("\"", ""));
		 */
		//System.out.println(myarray[95].replace("\"", ""));
		//System.out.println(myarray[1].replace("\"", "") + myarray[2].replace("\"", ""));
		//System.out.println(myarray[2].replace("\"", "") + myarray[3].replace("\"", ""));
		//System.out.println(myarray[4].replace("\"", "") + myarray[5].replace("\"", ""));

		/*
		 * Shows Hints
		 * i= 2
		 * ++4 
	System.out.println(myarray[2].replace("\"", ""));
	System.out.println(myarray[6].replace("\"", ""));
	System.out.println(myarray[10].replace("\"", ""));
	System.out.println(myarray[14].replace("\"", ""));
	System.out.println(myarray[18].replace("\"", ""));
	System.out.println(myarray[22].replace("\"", ""));
	System.out.println(myarray[26].replace("\"", ""));
	System.out.println(myarray[30].replace("\"", ""));
	System.out.println(myarray[34].replace("\"", ""));
	System.out.println(myarray[38].replace("\"", ""));
	System.out.println(myarray[42].replace("\"", ""));
	System.out.println(myarray[46].replace("\"", ""));
	System.out.println(myarray[50].replace("\"", ""));
	System.out.println(myarray[54].replace("\"", ""));
	System.out.println(myarray[58].replace("\"", ""));
	System.out.println(myarray[62].replace("\"", ""));
	System.out.println(myarray[66].replace("\"", ""));
	System.out.println(myarray[70].replace("\"", ""));
	System.out.println(myarray[74].replace("\"", ""));
	System.out.println(myarray[78].replace("\"", ""));
	System.out.println(myarray[82].replace("\"", ""));
	System.out.println(myarray[86].replace("\"", ""));
	System.out.println(myarray[90].replace("\"", ""));
	System.out.println(myarray[94].replace("\"", ""));
		 */
		/* Shows Solutions 
		 * i=3
		 * ++4
	System.out.println(myarray[3].replace("\"", ""));
	System.out.println(myarray[7].replace("\"", ""));
	System.out.println(myarray[11].replace("\"", ""));
	System.out.println(myarray[15].replace("\"", ""));
	System.out.println(myarray[19].replace("\"", ""));
	System.out.println(myarray[23].replace("\"", ""));
	System.out.println(myarray[27].replace("\"", ""));
	System.out.println(myarray[31].replace("\"", ""));
	System.out.println(myarray[35].replace("\"", ""));
	System.out.println(myarray[39].replace("\"", ""));
	System.out.println(myarray[43].replace("\"", ""));
	System.out.println(myarray[47].replace("\"", ""));
	System.out.println(myarray[51].replace("\"", ""));
	System.out.println(myarray[55].replace("\"", ""));
	System.out.println(myarray[59].replace("\"", ""));
	System.out.println(myarray[63].replace("\"", ""));
	System.out.println(myarray[67].replace("\"", ""));
	System.out.println(myarray[71].replace("\"", ""));
	System.out.println(myarray[75].replace("\"", ""));
	System.out.println(myarray[79].replace("\"", ""));
	System.out.println(myarray[83].replace("\"", ""));
	System.out.println(myarray[87].replace("\"", ""));
	System.out.println(myarray[91].replace("\"", ""));
	System.out.println(myarray[95].replace("\"", ""));
		 */
	}
}

