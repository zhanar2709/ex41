/**
 * 
 */
package exercise41.ntree;

import java.util.Iterator;
import java.util.List;
/**
 * @author Limon
 * Serves as a container for an N-Ary tree
 */
public class NTree {
	private TreeNode rootNode;
	
	/**
	 * 
	 */
	public NTree() {
		createRoot("Root");
	}

	/**
	 * Create a root node for this tree
	 * @param data
	 * @return
	 */
	private TreeNode createRoot(String data) {
		rootNode = new TreeNode(data);
		return rootNode;
	}
	
	/**
	 * Return the root node
	 * @return
	 */
	public TreeNode getRootNode() {
		return rootNode;
	}
	/**
	 * Add a new node with <code>data</code> to <code>parentNode</code>
	 * @param parentNode
	 * @param data
	 * @return
	 */
	public TreeNode addNode(TreeNode parentNode, String data) {
		TreeNode n = new TreeNode(data);
		parentNode.addChildNode(n);
		return n;
	}
	
	/**
	 * Return an indented representation of the tree
	 * @return
	 */
	public String treeToString() {
		return rootNode.toString("  ");
	}
	
	/**
	 * Return an {@link TreeNode} or <code>null</code>
	 * @param data
	 * @return
	 */
	public TreeNode findNode(String data) {
		return findNode(data, rootNode);
	}
	
	public TreeNode findNode(String data, TreeNode parent) {
		System.out.println("TreeNode findNode: "+data+" | "+parent);
		TreeNode result = null;
		String parentData = parent.getData();
		if (parentData.equals(data))
			result = parent;
		else {
			List<TreeNode> children = parent.listChildren();
			Iterator<TreeNode>itr = children.iterator();
			while (result == null && itr.hasNext())
				result = findNode(data,itr.next());
		}
		return result;
	}
	
}