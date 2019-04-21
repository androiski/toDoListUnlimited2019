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
    public String displayInfo()
    {
    	String result;
        result = "\nName: " + name;
        result = result + "\nDescription: " + desc;
        result = result + "\nPriority: " + priority;
        //need to convert due date to readable format
        String year;
        String month;
        String day;
        String dueDate = Integer.toString(due);
        year = dueDate.substring(0, 4);
        month = dueDate.substring(4, 6);
        day = dueDate.substring(6, 8);
        String displayDate = day + "/" + month + "/" + year;
        result = result + "\nDue: " + displayDate;
        //if task is not started, return string
        if (status == 0)
        {
        }
        //if task is started, add start date
        else if (status == 1)
        {
            String startDate = Integer.toString(started);
            String yr;
            String mo;
            String da;
            yr = startDate.substring(0, 4);
            mo = startDate.substring(4, 6);
            da = startDate.substring(6, 8);
            String displayStart = da + "/" + mo + "/" + yr;
            result = result + "\nStarted: " + displayStart;
        }
        // if task is finished, add finish date
        else if (status == 2)
        {
            String finishedDate = Integer.toString(finished);
            String yr;
            String mo;
            String da;
            yr = finishedDate.substring(0, 4);
            mo = finishedDate.substring(4, 6);
            da = finishedDate.substring(6, 8);
            String displayFinished = da + "/" + mo + "/" + yr;
            result = result + "\nFinished: " + displayFinished;
        }
        return result;
    }
    public String toString()
    {
    	String info;
    	info = "NAME: " + name;
    	info = info + " | PRIORITY: " + priority;
    	info = info + " | DESCRIPTION: " + desc;
    	
    	return info;
    }
}