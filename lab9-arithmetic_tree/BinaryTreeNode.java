public class BinaryTreeNode {
    String value; // Can be an operator "+" or an operand "3"
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }


    /**
     * Performs a preorder traversal starting from this node.
     * (Visit Parent, then Left, then Right)
     * This should output Prefix notation.
     */
    public void traversePreorder() {
        // Preorder print name first
        System.out.println(value);

        // If loop for left side recursive call
        if (left != null){
            left.traversePreorder();
        }

        // If loop for right side
        if (right != null){
            right.traversePreorder();
        }
    }

    /**
     * Performs an inorder traversal starting from this node.
     * (Visit Left, then Parent, then Right)
     * This should output Infix notation (you can add parentheses for clarity).
     */
    public void traverseInorder() {

        // Left side recursive
        if (left != null){
            left.traverseInorder();
        }

        // Print line in middle
        System.out.println(value);

        // Right side recursive
        if (right != null){
            right.traverseInorder();
        }
    }

    /**
     * Performs a postorder traversal starting from this node.
     * (Visit Left, then Right, then Parent)
     * This should output Postfix (RPN) notation.
     */
    public void traversePostorder() {

        // Left recursive
        if (left != null){
            left.traversePostorder();
        }

        // Right recursive

        if (right != null){
            right.traversePostorder();
        }

        //Print last
        System.out.println(value);
    }
}
