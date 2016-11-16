package visitor;

import twitterSet.*;

public class GroupCount implements TwitterVisit 
{
	public Integer count = 0;
	
	public Integer getGroup()
	{
		return this.count;
	}
	
	public void userVisit(User user)
	{
		
	}
	public void groupVisit(Group group)
	{
		this.count +=1;
	}

}
