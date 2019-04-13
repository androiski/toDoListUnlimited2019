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
	public void setInfo(int pri, String n, String d, int du, int s, int start, int fin)
	{
		String dueDate = Integer.toString(du);
		
		info[0] = Integer.toString(pri);
		info[1]= n;
		info[2]= d;
		
		String year;
		String month;
		String day;
		year = dueDate.substring(0, 4);
		month = dueDate.substring(4, 6);
		day = dueDate.substring(6, 8);
		String displayDat = day + "/" + month + "/" + year;
		
		info[3]= displayDat;
		if(s == 0)
		{
			info[4] = "Not started";
		}
		else if (s == 1)
		{
			String startDate = Integer.toString(start);
			String yr;
			String mo;
			String da;
			yr = startDate.substring(0, 4);
			mo = startDate.substring(4, 6);
			da = startDate.substring(6, 8);
			String displayDate = da + "/" + mo + "/" + yr;
			info[4] = displayDate;
		}
		else if (s == 2)
		{
			String finishedDate = Integer.toString(fin);
			String yr;
			String mo;
			String da;
			yr = finishedDate.substring(0, 3);
			mo = finishedDate.substring(4, 5);
			da = finishedDate.substring(6, 7);
			String displayDate = da + "/" + mo + "/" + yr;
			info[4] = displayDate;
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