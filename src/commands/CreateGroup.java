package commands;

import java.awt.event.*;

import javax.swing.*;

import miniTwitter.*;
import twitterSet.*;

//Create Group command
public class CreateGroup implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		String name = AdminControl.getInstance().getGroupText().getText();
		try
		{
			new Group(name,(Group) AdminControl.getInstance().getSelectedEntity());
		} catch(Exception ex){
			JOptionPane.showMessageDialog(AdminControl.getInstance(), ex.getMessage() +": "+name);
		}
		AdminControl.getInstance().getGroupText().setText("");
	}
}
