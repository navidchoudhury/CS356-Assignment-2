package twitterSet;

import java.util.*;
import javax.swing.tree.*;
import visitor.*;
import observer.*;

public abstract class TwitterM implements MutableTreeNode, Comparable<TwitterM>
{
	protected String name;
	protected Group top;
	protected List<TwitterM> decs = null;
	private List<TwitterObs> observ = new ArrayList<TwitterObs>();
	
	//Observer pattern
	public void attach(TwitterObs obs)
	{
		this.observ.add(obs);
	}
	public void detach(TwitterObs obs)
	{
		this.observ.remove(obs);
	}
	public void notifyObservers()
	{
		for(TwitterObs ob : observ)
		{
			ob.update(this);
		}
	}
	
	public abstract void accept(TwitterVisit visit);
	public String toString()
	{
		return this.name;
	}
	public String getName()
	{
		return this.name;
	}
	public int compareTo(TwitterM m)
	{
		if((m instanceof User && this instanceof User ) || m instanceof Group && this instanceof Group)
		{
			return this.name.compareTo(m.name);
		}
		else
		{
			if( this instanceof Group)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
	}
	//Search
	public static void search(TwitterVisit visit, Group par)
	{
		par.accept(visit);
		for(TwitterM en : par.decs)
		{
			if(en.getAllowsChildren())
			{
				search(visit,(Group) en);
			}
			else
			{
				en.accept(visit);
			}
		}
	}
	public void setUserObject(Object obj)
	{

	}
	public void setParent(MutableTreeNode newTop)
	{
		this.top = (Group) newTop;
	}
	public TwitterM getParent()
	{
		return top;
	}
	public void removeFromParent()
	{
		this.top.decs.remove(this);
	}
	public int getIndex(TreeNode node)
	{
		return -1;
	}
	public TwitterM getChildAt(int index)
	{
		return this.isLeaf() ? null : this.decs.get(index);
	}
	public boolean isLeaf()
	{
		return this.decs == null;
	}
	public boolean getAllowsChildren()
	{
		return !this.isLeaf();
	}
	public int getChildCount()
	{
		return this.getAllowsChildren() ? this.decs.size() : 0;
	}
	public void insert(MutableTreeNode dec, int index)
	{
		if(this.getAllowsChildren())
		{
			this.decs.add(index,(Group) dec);
		}
	}
	public void remove(int index)
	{
		if(this.getAllowsChildren())
		{
			this.decs.remove(index);
		}
	}
	public void remove(MutableTreeNode node)
	{
		if(this.getAllowsChildren())
		{
			this.decs.remove((Group) node);
		}
	}
	public Enumeration<TwitterM> children()
	{
		return this.isLeaf() ? null : java.util.Collections.enumeration(this.decs);
	}
}
