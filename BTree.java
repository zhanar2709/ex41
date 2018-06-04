/**
 * 
 */
package exercise41.btree;

/**
 * @author Limon
 * Serves as a container for a Binary Tree
 */
public class BTree {
	private BNode rootNode;
	
	/**
	 * 
	 */
	public BTree() {
		createRoot("Root");
	}

	public BNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(BNode rootNode) {
		this.rootNode = rootNode;
	}

	/**
	 * Create a root for this tree
	 * @param data
	 */
	private void createRoot(String data) {
		rootNode = new BNode(data);
	}
	
	/**
	 * Add a node with <code>data</code> to the tree,
	 * which has the effect of sorting the added node
	 * @param data
	 */
	public void addNode(String data) {
		//create the node
		BNode n = new BNode(data);
		//now add it to the tree
		rootNode.addNode(n);
	}
	
	public void addNode(BNode node) {
		rootNode.addNode(node);
	}
	
	/**
	 * Return an indented representation of the tree
	 * @return
	 */
	public String treeToString() {
		return rootNode.toString(" ");
	}
	
	/**
	 * Return a {@link BNode} or <code>null</code>
	 * @param data
	 * @return
	 */
	
	public BNode findNode(String data) {
		return findNode(data, rootNode);
	}
	
	public BNode findNode(String data, BNode parent) {
		System.out.println("BNode findNode: "+data+" | "+parent);

		BNode result = null;
		if (parent == null)
			return null;
		String parentData = parent.getData();
		//test parent
		if (data.equals(parentData))
			result = parent;
		else {
			//it's not the same; which branch do we descend?
			if (data.compareTo(parentData) > 0)
				result = findNode(data,parent.getRightNode());
			else
				result = findNode(data,parent.getLeftNode());
		}
		return result;
	}
	
}