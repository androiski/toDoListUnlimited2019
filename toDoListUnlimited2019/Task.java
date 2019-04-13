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
	private String[] info;
	
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
		info=new String[5];
	}
	
	//get methods
	public String[] getInfo()
	{
		return info;
	}
	
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
	public void setInfo()
	{
		info[0] = Integer.toString(priority);
		info[1]=name;
		info[2]=desc;
		info[3]=Integer.toString(due);
		if(status==0)
		{
			//check if edit menu's check=box is checked
		}
	}
	
	
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