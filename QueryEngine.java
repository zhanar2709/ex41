/**
 * 
 */
package exercise41;

import exercise41.btree.BTree;
import exercise41.ntree.NTree;
import exercise41.ntree.TreeNode;
import exercise41.btree.BNode;

/**
 * @author 
 *
 */
public class QueryEngine {
	private NTree nAryTree = new NTree();
	private BTree binaryTree = new BTree();
	/**
	 * 
	 */
	public QueryEngine() {
		// Fill the NTree
		// fetch a root node
		TreeNode root = nAryTree.getRootNode();
		// add some child nodes to build a tree
		TreeNode kid1 = nAryTree.addNode(root, "Root's First Kid");
		TreeNode kid2 = nAryTree.addNode(kid1, "First Kid's First Kid");
		kid1 = nAryTree.addNode(root,"Root's Second Kid");
		kid2 = nAryTree.addNode(kid1,"Root's Second Kid's First kid");
		kid1 = nAryTree.addNode(kid2,"Root's Second Kid's First Kid's First Kid");
		// show the tree
		System.out.println("NARY:\n"+nAryTree.treeToString());
		// fill the BTree
		// add some children which will be sorted as they are added
		binaryTree.addNode("First Node Added");
		binaryTree.addNode("Second Node Added");
		binaryTree.addNode("Third Node Added");
		binaryTree.addNode("Fourth Node Added");
		binaryTree.addNode("First Node Added+");
		// show the tree
		System.out.println("BINARY:\n"+binaryTree.treeToString());
	}
	
	public String queryBinaryTree(String query) {
		BNode n = binaryTree.findNode(query);
		System.out.println("Query Binary: "+n);
		if (n != null)
			return n.getData();
		return null;
	}
	
	public String queryNAryTree(String query) {
		TreeNode n  = nAryTree.findNode(query);
		System.out.println("Query N-Ary: "+n);
		if (n != null)
			return n.getData();
		return null;
	}

}