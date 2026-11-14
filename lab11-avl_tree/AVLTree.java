// TODO: Implement the AVLNode class
class AVLNode {
    int key, height;
    AVLNode left, right;

    // Constructor
    AVLNode(int key) {
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {

    AVLNode root;

    // TODO: Return height of a node
    int height(AVLNode N) {
        // If node is empty, height is 0 so return 0
        if (N == null){
            return 0;
        }
        // else return height
        return N.height;
    }

    // TODO: Return maximum of two integers
    int max(int a, int b) {
        //  find bigger number between a and b
        if (a > b){
            return a;
        }
        else {
            return b;
        }
    }

    // TODO: Compute balance factor
    int getBalance(AVLNode N) {
        // If there is no node, return 0
        if (N == null){
            return 0;
        }

        //Subtract right height from left height to get balance
        return height(N.left) - height(N.right);
    }

    // TODO: Right rotation
    AVLNode rightRotate(AVLNode y) {
        // Move left child above and save right child of x
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;

        // Change heights after rotation
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // TODO: Left rotation
    AVLNode leftRotate(AVLNode x) {
        // Move right child above and save left child of y
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;

        // Change heights after rotation
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // TODO: Left-Right rotation
    AVLNode leftRightRotate(AVLNode z) {
        // Rotate left child to the left, and then rotate main node right
        z.left = leftRotate(z.left);

        return rightRotate(z);
    }

    // TODO: Right-Left rotation
    AVLNode rightLeftRotate(AVLNode y) {
        // Rotate right child to the right, and then main node to the left
        y.right = rightRotate(y.right);

        return leftRotate(y);
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // TODO: Recursive insertion with rebalancing
    private AVLNode insert(AVLNode node, int key) {
        // Checks if node is empty to create node
        if (node == null){
            return new AVLNode(key);
        }

        // If new number is smaller go left
        if (key < node.key){
            node.left = insert(node.left, key);
        }

        // If new number is bigger go right
        else if (key > node.key){
            node.right = insert(node.right, key);
        }
        else{
            return node;
        }
        // Update height
        node.height = 1 + max(height(node.left), height(node.right));
        // CHeck balance for rotation
        int balance = getBalance(node);
        // If left-left case perform right rotation
        if (balance > 1 && key < node.left.key){
            return rightRotate(node);
        }
        // If right-right case perform left rotation
        if (balance < -1 && key > node.right.key){
            return leftRotate(node);
        }
        // If left-right case perform left right rotation
        if (balance > 1 && key > node.left.key){
            return leftRightRotate(node);
        }
        // If right-left case perform right left rotation
        if (balance < -1 && key < node.right.key){
            return rightLeftRotate(node);
        }

        // If not imbalanced return node
        return node;
    }

    // TODO: Traversal methods
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        // If node isn't empty print left side, current node then right
        if (node != null){
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        // Print current node first before traverse
        if (node != null){
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        // Print children before current node
        if (node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
}