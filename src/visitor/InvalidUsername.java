package visitor;
import java.util.*;
import twitterSet.*;

public class InvalidUsername implements TwitterVisit
{
	public List<String> invalid = new ArrayList<String>();
	public Set<String> users = new HashSet<String>();
	public Set<String> groups = new HashSet<String>();
	
	//Username is invalid
	public List<String> getInvalid()
	{
		return invalid;
	}
	private static boolean exists(String name,Set<String> objs)
	{
		if(name.indexOf(' ') >= 0)
		{
			return true;
		}
		for(String ob : objs)
		{
			if(ob.compareTo(name)==0)
			{
				return true;
			}
		}
		return false;
	}
	public boolean checkInvalidName(String name)
	{
		return exists(name,this.users);
	}
	public boolean checkInvalidGroup(String name)
	{
		return exists(name, this.groups);
	}
	public void groupVisit(Group group)
	{
		if(!groups.add(group.getName()))
		{
			invalid.add(group.getName());
		}
	}
	public void userVisit(User user)
	{
		if(!users.add(user.getName()))
		{
			invalid.add(user.getName());
		}
	}

}
