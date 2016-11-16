package visitor;

import twitterSet.*;

//Count of users
public class UserCount implements TwitterVisit 
{
	public Integer user = 0;
	public Integer getUser()
	{
		return this.user;
	}
	public void userVisit(User user)
	{
		this.user += 1;
	}
	public void groupVisit(Group group)
	{
		// nothing
	}

}
