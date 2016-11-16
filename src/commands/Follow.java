package commands;

import java.awt.event.*;
import javax.swing.*;

import miniTwitter.*;
import twitterSet.*;

//Follow command
public class Follow implements ActionListener {
	private Admin ad;
	
	public Follow(Admin ad)
	{
		this.ad = ad;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String name = ad.getFollowUser().getText();
		User us = User.findUser(name, Group.getRoot());
		if(us == null)
		{
			//User not found
			JOptionPane.showMessageDialog(ad, "User not Found");
		}
		try
		{
			ad.getUser().follow(us,ad.getObserver());
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(ad, ex.getMessage()+": "+ name);
		}
		ad.getFollowUser().setText("");
	}

}
