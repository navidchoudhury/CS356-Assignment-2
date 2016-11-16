package observer;

import javax.swing.*;

import twitterSet.*;

public class UserObs implements TwitterObs
{
	public JList<String> followingList;
	public JList<String> newsFeed;
	public User user;
	
	public UserObs(JList<String>followingList, JList<String> newsFeed, User user)
	{
		this.followingList = followingList;
		this.newsFeed = newsFeed;
		this.user = user;
	}
	//Updates the feed when new post or follower
	public void update(TwitterM tm)
	{
		this.followingList.setListData(user.getFollowing());
		this.newsFeed.setListData(user.getFeed());
	}

}
