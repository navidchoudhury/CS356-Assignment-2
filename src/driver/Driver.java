package driver;
import java.util.*;
import java.awt.*;
import miniTwitter.*;
import twitterSet.*;

//Driver Class
public class Driver {
	
	private static Driver drive;
	private Driver()
	{
		
	}
	//Main
	public static void main(String[] args) 
	{
		ArrayList<Group> groups = new ArrayList<Group>();
		groups.add(Group.getRoot());
		Driver.getInstance().start();

	}
	//Uses Singleton
	public static Driver getInstance()
	{
		if(drive == null)
		{
			drive = new Driver();
		}
		return drive;
	}
	//Starts the program
	public void start()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AdminControl.getInstance().setVisible(true);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
	}

}
