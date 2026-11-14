import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Simplified node structure
class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    // Check if node is full (3 keys)
    public boolean isFull() {
        return keys.size() == 3;
    }

    // Find correct child to descend for a given key
    public TwoFourNode getNextChild(int key) {
        // TODO: Implement traversal logic
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // Insert a key into this node (assume node not full)
    public void insertKey(int key) {
        // TODO: Add key and sort
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // 1. Descend to the leaf node
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // 2. Insert key in leaf
        node.insertKey(key);

        // 3. Handle overflow by splitting
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        // TODO: Implement split logic
        System.out.println("Splitting node with keys: " + node.keys);
        // Creating a new node for the right side
        TwoFourNode rightNode = new TwoFourNode();
        //  Get middle key that will move up
        int middleKey = node.keys.get(2);
        // Put the last key into new right node, while keeping two keys in original node
        rightNode.keys.add(node.keys.get(3));
        node.keys.remove(3);
        node.keys.remove(2);

        // Check node for children
        if (!node.children.isEmpty()){
            //MOve the last two to the new right node
            rightNode.children.add(node.children.remove(3));
            rightNode.children.add(node.children.remove(2));
        }

        // Update parent of the moved children
        for (TwoFourNode child : rightNode.children){
            child.parent = rightNode;
        }

        // Check to see if node being split is root
        if (node.parent == null){
            // Create new root and move middle key into new root
            TwoFourNode newRoot = new TwoFourNode();
            newRoot.keys.add(middleKey);

            // Add two split nodes as children to new root
            newRoot.children.add(node);
            newRoot.children.add(rightNode);

            // Update parent pointers
            node.parent = newRoot;
            rightNode.parent = newRoot;
            root = newRoot;
        }
        else{
            // Grab parent of node being split
            TwoFourNode parent = node.parent;
            // Grab index of where the original node is in parent and add middle key
            int index = parent.children.indexOf(node);
            parent.keys.add(index, middleKey);
            parent.children.add( index + 1, rightNode);
            // Set new right node'ss parent
            rightNode.parent = parent;
        }
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    inorder(node.children.get(i));
                }
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) {
                inorder(node.children.get(i));
            }
        }
    }
}