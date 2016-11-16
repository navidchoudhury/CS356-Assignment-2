package commands;

import java.awt.event.*;
import miniTwitter.*;
import visitor.*;
import twitterSet.*;

//Total amount of posts. 
public class PostTotal implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		//Calls PostCount class
		PostCount count = new PostCount();
		TwitterM.search(count, Group.getRoot());
		AdminControl.getInstance().getStatsLabel().setText("Total Posts: "+ count.getPosts());		
	}

}
