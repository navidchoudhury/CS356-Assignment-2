package commands;

import java.awt.event.*;
import miniTwitter.*;


//Command to post tweet to Twitter
public class PostMessage implements ActionListener 
{
	//Uses Admin class
	public Admin ad;
	
	public PostMessage(Admin ad)
	{
		this.ad=ad;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		ad.getUser().post(ad.getMessage().getText());
		ad.getMessage().setText("");
	}
}
