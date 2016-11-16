package visitor;
import java.util.*;
import twitterSet.*;

//Count of positive posts
public class PositiveCount implements TwitterVisit
{
	public Integer users = 0;
	public Integer group = 0;
	public Integer positive = 0;
	public Integer post = 0;
	
	public Integer getUsers()
	{
		return this.users;
	}
	public Integer getPositive()
	{
		return this.positive;
	}
	public Integer getPosts()
	{
		return this.post;
	}
	public Integer getGroup()
	{
		return this.group;
	}
	public String getPercentage()
	{
		return Double.toString(Math.round((double)this.positive /(double)this.post *100.0));
	}
	
	public void userVisit(User user)
	{
		this.users += 1;
		List<Post> posts = user.getPosts();
		for(Post post: posts)
		{
			this.post +=1;
			if(post.hasPositive())
			{
				this.positive +=1;
			}
		}
	}
	public void groupVisit(Group group)
	{
		this.group +=1;
	}
}
