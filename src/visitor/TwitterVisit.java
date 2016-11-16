package visitor;

import twitterSet.*;

//userVisit and groupVisit methods
public interface TwitterVisit 
{
	public void userVisit(User user);
	public void groupVisit(Group group);
}
