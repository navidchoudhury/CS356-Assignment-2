package twitterSet;

import java.util.*;
import visitor.*;
import observer.*;

public class User extends TwitterM 
{
	private Set<User> following = new HashSet<User>();
	private List<Post> posts = new ArrayList<Post>();
	
	public User(String name, Group parentGroup) throws Exception
	{
		if(name.indexOf(' ') >= 0)
		{
			//Spaces not allowed
			throw new Exception("Can't contain spaces");
		}
		InvalidUsername visit = new InvalidUsername();
		TwitterM.search(visit,Group.getRoot());
		if(visit.checkInvalidName(name))
		{
			//No same users
			throw new Exception("Already exists");
		}
		this.name = name;
		this.top = parentGroup;
		this.top.decs.add(this);
		Group.getRoot().notifyObservers();
	}
	public void accept(TwitterVisit visitor)
	{
		visitor.userVisit(this);
	}
	//Follow user
	public void follow(User user, TwitterObs obs) throws Exception
	{
		if(this == user)
		{
			throw new Exception("Can't follow yourself");
		}
		if(!this.following.add(user)) 
		{
			throw new Exception("Already following");
		}
		if(obs != null)
		{
			user.attach(obs);
		}
		this.notifyObservers();
	}
	//Post message
	public void post(String message)
	{
		posts.add(new Post(message));
		this.notifyObservers();
	}
	//get posts
	public List<Post> getPosts()
	{
		return this.posts;
	}
	//Get feed list
	private List<Post> getFeedList()
	{
		List<Post> feed = new ArrayList<Post>();
		feed.addAll(this.getPosts());
		for(User user : this.following)
		{
			feed.addAll(user.getPosts());
		}
		Collections.sort(feed);
		Collections.reverse(feed);
		return feed;
	}
	//Get following
	public String[] getFollowing()
	{
		String[] following = new String[this.following.size()];
		Integer i = 0;
		for(User user : this.following)
		{
			following[i++] = user.toString();
		}
		return following;
	}
	//Get feed
	public String[] getFeed()
	{
		List<String> feed = new ArrayList<String>();
		List<Post> posts = this.getFeedList();
		for(Post post: posts)
		{
			feed.add(this.toString() + ": "+ post.toString());
		}
		return feed.toArray(new String[feed.size()]);
	}
	//Attach User
	public void attachUser(TwitterObs obs)
	{
		this.attach(obs);
		for(User user : this.following)
		{
			user.attach(obs);
		}
	}
	//Find user
	public static User findUser(String name, Group parent)
	{
		for(TwitterM ent : parent.decs)
		{
			if(ent.isLeaf())
			{
				if(ent.getName().compareTo(name)==0)
				{
					return (User) ent;
				}
			}
			else
			{
				User rec = findUser(name, (Group) ent);
				if(rec != null)
				{
					return rec;
				}
			}

		}
		return null;
	}
}
