
/**
 * 
 */
package Software_Master_A.client_and_server;
import java.io.Serializable;
import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * The Class Node.
 */

public class Node implements Serializable
{
	
	/** The parent. */
	Node parent;
	
	/** The name. */
	String name;
	
	/** The data. */
	String data;
	
	/** The children. */
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
	 * Instantiates a new node.
	 *
	 * @param parent the parent
	 * @param name the name
	 * @param data the data
	 * @param child the child
	 */
	public Node(Node parent, String name, String data, ArrayList<Node> child)
	{
		this.name = name;
		this.parent = parent;
		this.data = data;
		
	}
	
	/**
	 * Instantiates a new node.
	 */
	//empty constructor for XML
	public Node()
	{
		this(null, "blank",  "empty", null);
	}


	//Getter and setters
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getData()
	{
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(String data)
	{
		this.data = data;
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public Node getParent()
	{
		return parent;
	}
  
	/**
	 * Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public void setParent(Node parent)
	{
		this.parent = parent;
	}
	
	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	public ArrayList<Node> getChildren()
	{
		return children;
	}
	
	//
	
	//add a Node child to another node
	/**
	 * Adds the child.
	 *
	 * @param child the child
	 */
	public void addChild(Node child)
	{
		this.children.add(child);
	}
	
	
	//remove child node from a node's children list
	/**
	 * Removes the child.
	 *
	 * @param child the child
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

	/**
	 * @param children the children to set
	 */
	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}
	
	

}
