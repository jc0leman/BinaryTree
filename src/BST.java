import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here Jackson Coleman
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i< nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    // Jackson Coleman
// This method searches for a given value in the binary search tree using recursion
// It takes in a value to search for and returns true if it is found, false otherwise
// It calls the recursive helper method recSearch with the root of the tree and the value to search for
    public boolean search(int val) {
        return recSearch(this.root, val);
    }

    // This is a helper method for the search method that performs the actual search
// It takes in the current node and the value to search for
// If the current node is null, it returns false (value not found)
// If the current node has the value, it returns true (value found)
// Otherwise, it calls itself recursively on the left and right subtrees and returns the result of the OR operation between them
    public boolean recSearch(BSTNode root, int val) {
        if (root == null) {
            return false;
        }
        if (root.getVal() == val) {
            return true;
        }
        return recSearch(root.getLeft(), val) || recSearch(root.getRight(), val);
    }

    /**

     @return ArrayList of BSTNodes in inorder
     */
// This method returns an ArrayList of the nodes in the binary search tree in inorder traversal
// It calls the recursive helper method recInOrder with the root of the tree and an empty ArrayList
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> theNodes = new ArrayList<BSTNode>();
        return recInOrder(root, theNodes);
    }
    // This is a recursive helper method for the getInorder method that performs the actual inorder traversal
// It takes in the current node and an ArrayList to store the nodes in
// It calls itself recursively on the left subtree, adds the current node to the ArrayList, and then calls itself recursively on the right subtree
// It returns the ArrayList
    public ArrayList<BSTNode> recInOrder(BSTNode root,ArrayList<BSTNode> nodes) {
        if(root.getLeft() != null)
        {
            recInOrder(root.getLeft(), nodes);
        }
        nodes.add(root);
        if(root.getRight() != null) {
            recInOrder(root.getRight(), nodes);
        }
        return nodes;
    }

    /**

     @return ArrayList of BSTNodes in preorder
     */
// This method returns an ArrayList of the nodes in the binary search tree in preorder traversal
// It calls the recursive helper method recPreOrder with an empty ArrayList and the root of the tree
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        return recPreOrder(nodes, root);
    }
    // This is a recursive helper method for the getPreorder method that performs the actual preorder traversal
// It takes in an ArrayList to store the nodes in and the current node
// It adds the current node to the ArrayList, then calls itself recursively on the left and right subtrees
// It returns the ArrayList
    public ArrayList<BSTNode> recPreOrder(ArrayList<BSTNode> nodes ,BSTNode root)
    {
        nodes.add(root);
        if(root.getLeft() != null)
        {
            recPreOrder(nodes, root.getLeft());
        }
        if(root.getRight() != null)
        {
            recPreOrder(nodes, root.getRight());
        }
        return nodes;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        return recPostOrder(nodes, root);
    }
    public ArrayList<BSTNode> recPostOrder(ArrayList<BSTNode> nodes, BSTNode root)
    {
        // Recursively traverse left subtree
        if(root.getLeft() != null)
        {
            recPostOrder(nodes, root.getLeft());
        }
        // Recursively traverse right subtree
        if(root.getRight() != null)
        {
            recPostOrder(nodes, root.getRight());
        }
        // Add the root node to the list
        nodes.add(root);
        return nodes;
    }

    /**
     * Inserts a value into the binary search tree.
     * @param val The value to insert.
     */
    public void insert(int val) {
        // Create a new node with the given value
        BSTNode node = new BSTNode(val);
        // Recursively insert the new node into the tree
        recInsert(root, node);
    }

    private void recInsert(BSTNode root, BSTNode node)
    {
        // If the value of the new node is less than the value of the current node
        if(root.getVal() > node.getVal())
        {
            // If there is no left child, set the new node as the left child
            if(root.getLeft() == null)
            {
                root.setLeft(node);
                return;
            }
            // Recursively insert the new node into the left subtree
            recInsert(root.getLeft(), node);
        }
        // If the value of the new node is greater than the value of the current node
        if(root.getVal() < node.getVal())
        {
            // If there is no right child, set the new node as the right child
            if(root.getRight() == null)
            {
                root.setRight(node);
                return;
            }
            // Recursively insert the new node into the right subtree hee hee
            recInsert(root.getRight(), node);
        }
    }


    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
