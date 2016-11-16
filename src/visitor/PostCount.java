package visitor;
import twitterSet.*;

public class PostCount implements TwitterVisit 
{
	public Integer post = 0;
	
	public Integer getPosts()
	{
		return this.post;
	}
	public void userVisit(User user)
	{
		this.post += user.getPosts().size();
	}
	public void groupVisit(Group group)
	{
		//nothing
	}

}
