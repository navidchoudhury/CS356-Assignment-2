package miniTwitter;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import commands.*;
import twitterSet.*;
import observer.*;


public class Admin extends JFrame 
{
	private static final long serialVersionUID = -482063279029840255L;
	private User user;
	private JPanel userPanel;
	private JTextField userField;
	private JTextField newMessage;
	private JList<String> followingList;
	private JList<String> newsFeedList;
	private JButton followButton;
	private JButton messageButton;
	private JLabel newsFeedLabel;
	private JLabel followingLabel;
	private JScrollPane scrollFeed;
	private TwitterObs observer;
	
	public User getUser() 
	{
		return this.user;
	}

	public TwitterObs getObserver() 
	{
		return this.observer;
	}

	public JTextField getFollowUser()
	{
		return this.userField;
	}

	public JTextField getMessage()
	{
		return this.newMessage;
	}
	
	public Admin(User user)
	{
		this.user = user;
		setBounds(180,180,300,400);
		setTitle(this.user.toString());
		userPanel = new JPanel();
		userPanel.setBorder(new EmptyBorder(5,5,5,5));
		userPanel.setLayout(null);
		setContentPane(userPanel);
		
		//Text field to enter user
		userField = new JTextField();
		userField.setBounds(6,6,216,28);
		userPanel.add(userField);
		userField.setColumns(10);
		
		//Follow Button
		followButton = new JButton("Follow");
		followButton.setBounds(222,6,72,29);
		followButton.addActionListener(new Follow(this));
		userPanel.add(followButton);
		
		//Following List
	    followingList = new JList<String>(this.user.getFollowing());
	    JScrollPane scrollFollowing = new JScrollPane();
	    scrollFollowing.setBounds(6, 57, 288, 100);
	    scrollFollowing.setViewportView(followingList);
	    userPanel.add(scrollFollowing);
	    
	    //Text field to enter new tweet
	    newMessage = new JTextField();
	    newMessage.setBounds(6, 162, 216, 28);
	    userPanel.add(newMessage);
	    newMessage.setColumns(10);
	    
	    //Post button
	    messageButton = new JButton("Post");
	    messageButton.setBounds(222, 162, 72, 29);
	    messageButton.addActionListener(new PostMessage(this));
	    userPanel.add(messageButton);
	    
	    //news feed list using JList
	    newsFeedList = new JList<String>(this.user.getFeed());
	    scrollFeed = new JScrollPane();
	    scrollFeed.setBounds(6, 212, 288, 110);
	    scrollFeed.setViewportView(newsFeedList);
	    userPanel.add(scrollFeed);
	    
	    //news feed label
	    newsFeedLabel = new JLabel("News Feed");
	    newsFeedLabel.setBounds(6, 192, 288, 16);
	    userPanel.add(newsFeedLabel);
	    
	    //following label
	    followingLabel = new JLabel("Current Following");
	    followingLabel.setBounds(6, 34, 288, 16);
	    userPanel.add(followingLabel);
	    
	    //UserObs class
	    observer = new UserObs(followingList,newsFeedList, user);
	    this.user.attachUser(observer);
	}	
}
