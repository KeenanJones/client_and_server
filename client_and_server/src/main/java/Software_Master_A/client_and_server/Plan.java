/**
 * 
 */
package Software_Master_A.client_and_server;

import java.util.ArrayList;

/**
 * @author Courtney and Jack
 *
 */
public abstract class Plan
{
	//abstract methods addNode, removeNode, getRoot, getList 
	//   to be implemented in concrete classes
	
	abstract public boolean addNode(Node parent);
	
	abstract public boolean removeNode(Node Node);
	
	abstract public Node getRoot();
	
	abstract public ArrayList<String> getList();

	abstract public String getName();

	abstract public void setName(String name);
	
	//set data for the given node
	/**
	 * Takes a Node node and String data
	 * Sets data for the node
	 * @param node node to set data for
	 * @param data data to set in node
	 * 
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