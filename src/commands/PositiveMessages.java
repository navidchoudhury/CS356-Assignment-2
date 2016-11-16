package commands;
import java.awt.event.*;
import miniTwitter.*;
import visitor.*;
import twitterSet.*;

//Calls the PositiveCount class to return the % of positive posts
public class PositiveMessages implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		PositiveCount pc = new PositiveCount();
		TwitterM.search(pc, Group.getRoot());
		AdminControl.getInstance().getStatsLabel().setText("Positive Percent: " + pc.getPercentage()+ "%");	
	}

}
