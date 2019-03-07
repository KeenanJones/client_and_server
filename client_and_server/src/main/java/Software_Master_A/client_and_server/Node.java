
/**
 * 
 */
package Software_Master_A.client_and_server;
import java.util.ArrayList;
/**
 * @author Courtney and Jack
 *
 */

public class Node
{
	Node parent;
	String name;
	String data;
	ArrayList<Node> children = new ArrayList<Node>();
	
	
	//constructor 
	/*public Node(String name, String data, Node parent)
	{
		this.name = name;
		this.data = data;
		this.parent = parent;
		//this.children = children;
	}*/
	
	//constructor is data is not known	
	/**
	 * Takes a Node parent, String name, String data, and list of children
	 * Sets values in node
	 * @param parent parent of node
	 * @param name name of node
	 * @param data data for node
	 * @param child list of children
	 */
	public Node(Node parent, String name, String data, ArrayList<Node> child)
	{
		this.name = name;
		this.parent = parent;
		this.data = data;
		
	}
	
	//empty constructor for XML
	public Node()
	{
		this(null, "blank",  "empty", null);
	}


	//Getter and setters
	/**
	 * returns a String name of node
	 * @return String name of node
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets name of node 
	 * @param name name to set as name of node
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Returns node's data
	 * @return String data of node
	 */
	public String getData()
	{
		return data;
	}

	/**
	 * Takes a String data and sets node's data
	 * @param data data to set as data of node
	 */
	public void setData(String data)
	{
		this.data = data;
	}

	/**
	 * returns the parent node
	 * @return Node parent of node
	 */
	public Node getParent()
	{
		return parent;
	}
  
	/**
	 * Takes a Node parent and sets the nodes parent
	 * @param parent parent to set as parent of node
	 */
	public void setParent(Node parent)
	{
		this.parent = parent;
	}
	
	/**
	 * Returns a list of children nodes
	 * @return ArrayList list of children
	 */
	public ArrayList<Node> getChildren()
	{
		return children;
	}
	
	//
	
	//add a Node child to another node
	/**
	 * Takes a node child and adds child to child list
	 * @param child child to be added to this node
	 */
	public void addChild(Node child)
	{
		this.children.add(child);
	}
	
	
	//remove child node from a node's children list
	/**
	 * @param child child to be removed from this node
	 */
	public void removeChild(Node child)
	{
		this.children.remove(child);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (children == null)
		{
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (data == null)
		{
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent == null)
		{
			if (other.parent != null)
				return false;
		} else if (!parent.name.equals(other.parent.name) || !parent.data.equals(other.data))
			return false;
		return true;
	}
	
	

}