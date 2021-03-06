/**
 * 
 */
package Software_Master_A.client_and_server;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Centre.
 */
public class Centre extends Plan
{
	
	/** The name. */
	// name of plan, set by client
	public String name;
	
	/** The default nodes. */
	// list of default nodes
	public ArrayList<String> defaultNodes = new ArrayList<String>(); 
	
	/** The root. */
	//pointer to top of IowaState plan tree
	public Node root;
	
	
	// constructor
	// clears list of default nodes
	// sets default strings in defaultNodes
	// adds node for each string in list
	
	
	/**
	 * Instantiates a new centre.
	 */
	public Centre()
	{
		defaultNodes.clear();
		setDefaultStrings();
		addDefaultNodes();
	}
	//set strings for default stages Centre plan

	/**
	 * Sets the default strings.
	 */
	private void setDefaultStrings()
	{
		defaultNodes.add("Mission");
		defaultNodes.add("Goal");
		defaultNodes.add("Learning Objective");
		defaultNodes.add("Assessment Process");
		defaultNodes.add("Results");
	}
	
	// make nodes for all of the strings in defaultNodes
	/**
	 * Adds the default nodes.
	 */
	// Create pointer for tree called root
	private void addDefaultNodes()
	{
		root = new Node(null, defaultNodes.get(0), null, null);
		Node newParent = new Node(root, defaultNodes.get(1), null, null);
		root.addChild(newParent);
		addNode(newParent);		
	}
	
	
	
	// addNode method from abstract Plan class
	// cannot add to Mission since there can only be one
	// makes node and sets to parent, uses for loop to iterate through the list of names
//  to add the nodes that follow
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.Plan#addNode(Software_Master_A.client_and_server.Node)
	 */
	public boolean addNode(Node parent)
	{	
		if (parent == null)
		{
			throw new IllegalArgumentException("Cannot add to this parent");
		}
		else
		{
			for (int i = (defaultNodes.indexOf(parent.getName()))+1; i < defaultNodes.size(); i++)
			{
			
				Node newNode = new Node(parent, defaultNodes.get(i), null, null);
			
				parent.addChild(newNode);
				parent = newNode;
			
			}
			return true;
		}
	}
	
	// remove a node if it is allowed to be removed
	// cannot be removed if it is the only child of its parent
	//     or if it is the root node
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.Plan#removeNode(Software_Master_A.client_and_server.Node)
	 */
	public boolean removeNode(Node nodeRemove)
	{
		if ((nodeRemove.getName() == root.getName()) 
				|| nodeRemove.getParent().children.size()==1 || nodeRemove==null)
		{
		
			throw new IllegalArgumentException("Cannot remove this node");
		
	    }
		else
		{
			nodeRemove.parent.removeChild(nodeRemove);
			nodeRemove.setParent(null);
			return true;

		}
	}
	
	//Getter and setters
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.Plan#getRoot()
	 */
	public Node getRoot()
	{
		return root;
	}
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.Plan#getList()
	 */
	public ArrayList<String> getList()
	{
		return defaultNodes;
	}
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.Plan#getName()
	 */
	public String getName()
	{
		return name;
	}

	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.Plan#setName(java.lang.String)
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((defaultNodes == null) ? 0 : defaultNodes.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((root == null) ? 0 : root.hashCode());
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centre other = (Centre) obj;
		if (defaultNodes == null)
		{
			if (other.defaultNodes != null)
				return false;
		} else if (!defaultNodes.equals(other.defaultNodes))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (root == null)
		{
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		return true;
	}

	/**
	 * @return the defaultNodes
	 */
	public ArrayList<String> getDefaultNodes() {
		return defaultNodes;
	}

	/**
	 * @param defaultNodes the defaultNodes to set
	 */
	public void setDefaultNodes(ArrayList<String> defaultNodes) {
		this.defaultNodes = defaultNodes;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

	
	
}