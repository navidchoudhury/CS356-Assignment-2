package twitterSet;
import java.util.*;
import visitor.*;


public class Group extends TwitterM 
{
	private static Group root = new Group();
	
	public static Group getRoot()
	{
		return root;
	}
	//Always root group
	private Group()
	{
		this.top = null;
		this.name = "Root";
		this.decs = new ArrayList<TwitterM>();
		
	}
	public void accept(TwitterVisit visitor)
	{
		visitor.groupVisit(this);
	}
	public Group(String name, Group parent) 
	{
		InvalidUsername user = new InvalidUsername();
		TwitterM.search(user, Group.getRoot());
		this.top = parent;
		this.name = name;
		this.decs = new ArrayList<TwitterM>();
		this.top.decs.add(this);
		Group.getRoot().notifyObservers();
	}
}
