package commands;

import java.awt.event.*;
import miniTwitter.*;
import twitterSet.*;

//View Users
public class ViewUser implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			//calls Admin class to view user
			Admin ad = new Admin((User) AdminControl.getInstance().getSelectedEntity());
			ad.setVisible(true);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
