package commands;

import java.awt.event.*;
import miniTwitter.*;
import visitor.*;
import twitterSet.*;

//Amount of total Users
public class UserTotal implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		//Calls UserCount class
		UserCount count = new UserCount();
		TwitterM.search(count, Group.getRoot());
		AdminControl.getInstance().getStatsLabel().setText("Total users: " + count.getUser());
	}

}
