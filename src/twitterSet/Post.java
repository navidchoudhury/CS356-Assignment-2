package twitterSet;

public class Post implements Comparable<Post> 
{
	private static Integer count = 0;
	private Integer identification = count++;
	private String message;
	
	public Post(String message)
	{
		this.message = message;
	}
	//Checks for positive words such as "good", "great" and amazing"
	public boolean hasPositive()
	{
		return this.message.contains("good") || this.message.contains("great") || this.message.contains("excellent");
	}
	public int compareTo(Post comparePost)
	{
		return this.identification - comparePost.identification;
	}
	public String toString()
	{
		return this.message;
	}

}
