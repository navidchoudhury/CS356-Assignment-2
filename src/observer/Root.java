package observer;

import javax.swing.tree.*;
import javax.swing.JTree;
import twitterSet.*;

public class Root implements TwitterObs 
{
	public JTree tr;
	
	public Root(JTree tr)
	{
		this.tr = tr;
	}
	//Adding user or group to tree
	public  void update(TwitterM tM)
	{
		((DefaultTreeModel)tr.getModel()).reload(tM);
		
	}

}
