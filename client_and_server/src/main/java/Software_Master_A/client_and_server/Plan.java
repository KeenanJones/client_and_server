/**
 * 
 */
package Software_Master_A.client_and_server;

import java.io.Serializable;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Plan.
 */
public abstract class Plan implements Serializable
{
	//abstract methods addNode, removeNode, getRoot, getList 
	//   to be implemented in concrete classes
	
	/**
	 * Adds the node.
	 *
	 * @param parent the parent
	 * @return true, if successful
	 */
	abstract public boolean addNode(Node parent);
	
	/**
	 * Removes the node.
	 *
	 * @param Node the node
	 * @return true, if successful
	 */
	abstract public boolean removeNode(Node Node);
	
	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	abstract public Node getRoot();
	
	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	abstract public ArrayList<String> getList();

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	abstract public String getName();

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	abstract public void setName(String name);
	
	//set data for the given node
	/**
	 * Sets the node data.
	 *
	 * @param node the node
	 * @param data the data
	 */
	public void setNodeData(Node node, String data)
	{
		node.setData(data);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	
	
	
}