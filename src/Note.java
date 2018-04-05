/**
 * Class: Note
 * 
 * @author Jose Castro Last Edited: 4/5/18
 *
 */

public class Note extends Items
{
	private int noteUsage;
	
	public Note(int itemID, String itemName, String description, int noteUsage)
	{
		super(itemID, itemName, description);
		this.noteUsage = noteUsage;
	}
	
	public int getNoteUsage()
	{
		return noteUsage;
	}

	public void setNoteUsage(int noteUsage)
	{
		this.noteUsage = noteUsage;
	}

	public void readNote()
	{

	}
}
