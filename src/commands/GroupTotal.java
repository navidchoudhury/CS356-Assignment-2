package commands;
import java.awt.event.*;
import miniTwitter.*;
import visitor.*;
import twitterSet.*;

//Find out the total number of groups
public class GroupTotal implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		GroupCount count = new GroupCount();
		TwitterM.search(count, Group.getRoot());
		AdminControl.getInstance().getStatsLabel().setText("Group Total:" +count.getGroup());	
	}

}
