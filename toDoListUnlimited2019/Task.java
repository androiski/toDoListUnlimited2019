package toDoListUnlimited2019;

public class Task 
{
	// declaration of variables
	private String name;
	private String desc;
	private int priority;
	private int due;
	private int started;
	private int finished;
	private int status;
	
	//will only be using a default constructor for Tasks.
	public Task()
	{
		name = "";
		desc = "";
		priority = 0;
		due = 0;
		started = 0;
		finished = 0;
		status = 0;
	}
	
	//get methods
	public String getName()
	{
		return name;
	}
	public String getDesc()
	{
		return desc;
	}
	public int getPri()
	{
		return priority;
	}
	public int getDue()
	{
		return due;
	}
	public int getStarted()
	{
		return started;
	}
	public int getFinished()
	{
		return finished;
	}
	public int getStatus()
	{
		return status;
	}
	
	//set methods
	public void setName(String s)
	{
		name = s;
	}
	public void setDesc(String s)
	{
		desc = s;
	}
	public void setPri(int x)
	{
		priority = x;
	}
	public void setDue(int x)
	{
		due = x;
	}
	public void setStarted(int x)
	{
		started = x;
	}
	public void setFinished(int x)
	{
		finished = x;
	}
	public void setStatus(int x)
	{
		status = x;
	}
}