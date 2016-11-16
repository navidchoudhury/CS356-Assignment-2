package commands;

import java.awt.event.*;
import javax.swing.*;
import miniTwitter.*;
import twitterSet.*;

//Adds a new user
public class CreateUser implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		String name = AdminControl.getInstance().getUserText().getText();
		AdminControl.getInstance().getUserText().setText("");
		try
		{
			new User(name,(Group) AdminControl.getInstance().getSelectedEntity());
		} catch(Exception ex){
			JOptionPane.showMessageDialog(AdminControl.getInstance(), ex.getMessage() +": "+name);
		}
	}
}
