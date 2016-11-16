package miniTwitter;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.border.*;


import commands.*;
import twitterSet.*;
import observer.*;

public class AdminControl extends JFrame implements TreeSelectionListener
{
	private static final long serialVersionUID = 1L;
	private static AdminControl contr = new AdminControl();
	
	public static AdminControl getInstance()
	{
		return contr;
	}
	
	public JPanel content;
	public JButton createGroup;
	public JButton createUser;
	public JButton viewUser;
	public JButton totalGroups;
	public JButton totalUsers;
	public JScrollPane scroll;
	public JButton totalPosts;
	public JLabel selected;
	public JLabel statsLabel;
	public JTree treeG;
	public JTextField userText;
	public JTextField groupText;
	public JButton positiveMessage;
	public TwitterM twit;
	
	public JTree getTreeG()
	{
		return treeG;
	}
	public JTextField getUserText()
	{
		return userText;
	}
	public JTextField getGroupText()
	{
		return groupText;
	}
	public TwitterM getSelectedEntity()
	{
		return twit;
	}
	public JLabel getStatsLabel()
	{
		return statsLabel;
	}
	
	public AdminControl()
	{
		//Create frame
		setTitle("Admin Control Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150,150,570,350);
		setLocationRelativeTo(null);
		content = new JPanel();
		content.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(content);
		content.setLayout(null);
		
		userText =new JTextField();
		groupText = new JTextField();
		userText.setEnabled(false);
		groupText.setEnabled(false);
		userText.setBounds(188,7,160,28);		
		groupText.setBounds(188,50,160,28);
		content.add(userText);
		content.add(groupText);
		userText.setColumns(10);
		groupText.setColumns(10);
		
		//Create JButtons
		createUser = new JButton("Add User");
		createGroup = new JButton("Add Group");
		viewUser = new JButton("Open User View");
		totalGroups = new JButton("Show Group Total");
		totalUsers = new JButton("Show User Total");
		totalPosts = new JButton("Show Messages Total");
		positiveMessage = new JButton("Show Positive Percentage");
		
		//Add user
		createUser.setEnabled(false);
		createUser.setBounds(350, 6, 190, 30);
		createUser.addActionListener(new CreateUser());
		content.add(createUser);
		
		//Add group
		createGroup.setEnabled(false);
		createGroup.setBounds(350, 45, 190, 32);
		createGroup.addActionListener(new CreateGroup());
		content.add(createGroup);
		
		
		//View User
		viewUser.setEnabled(false);
		viewUser.setBounds(190, 120, 330, 29);
		viewUser.addActionListener(new ViewUser());
		content.add(viewUser);
		
		//Total Groups
		totalGroups.setBounds(360, 202, 190, 29);
		totalGroups.addActionListener(new GroupTotal());
		content.add(totalGroups);
		
		//Total Users
		totalUsers.setBounds(188, 202, 180, 29);
		totalUsers.addActionListener(new UserTotal());
		content.add(totalUsers);
		
		//Total Messages
		totalPosts.setBounds(188, 243, 180, 29);
		totalPosts.addActionListener(new PostTotal());
		content.add(totalPosts);
				
		//Positive messages
		positiveMessage.setBounds(360, 243, 190, 29);
		positiveMessage.addActionListener(new PositiveMessages());
		content.add(positiveMessage);
		
		//Create JLabels
		selected = new JLabel("");
		statsLabel = new JLabel("");
		
		selected.setBounds(188,93,134,16);
		statsLabel.setBounds(188,129,256,61);
		content.add(selected);
		content.add(statsLabel);
		
		//Create JSCrollPane
		scroll = new JScrollPane();
		
		//Create JTree
		treeG = new JTree(new DefaultTreeModel(Group.getRoot()));
		treeG.addTreeSelectionListener(this);
		scroll.setBounds(6,6,170,307);
		scroll.setViewportView(treeG);
		content.add(scroll);
		
		TwitterObs observer = new Root(treeG);
		Group.getRoot().attach(observer);
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		twit = (TwitterM) treeG.getLastSelectedPathComponent();
		if(twit != null)
		{
			selected.setText(twit.toString());
			if(twit.isLeaf())
			{
				viewUser.setEnabled(true);
				createUser.setEnabled(false);
				createGroup.setEnabled(false);
				userText.setEnabled(false);
				groupText.setEnabled(false);
			}
			else
			{
				viewUser.setEnabled(false);
				createUser.setEnabled(true);
				createGroup.setEnabled(true);
				userText.setEnabled(true);
				groupText.setEnabled(true);
			}
		}
		else
		{
			selected.setText("");
			viewUser.setEnabled(false);
			createUser.setEnabled(false);
			createGroup.setEnabled(false);
			userText.setEnabled(false);
			groupText.setEnabled(false);
		}
		
	}
	

}
