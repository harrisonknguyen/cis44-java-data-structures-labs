import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name; // Employee name or department title
    GeneralTreeNode parent;
    List children;

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    // Method to add a child to this node
    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }

    // --- TO BE COMPLETED BY STUDENT ---

    /**
     * Performs a preorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit Parent, then visit children)
     */
    public void traversePreorder() {
        //Print name of each node visited must be done before
        System.out.println(name);
        // For loop to visit each child, preorder to visit parents first
        for (int i = 0; i < children.size(); i++){
            ((GeneralTreeNode) children.get(i)).traversePreorder();
        }
    }


    /**
     * Performs a postorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit children, then visit Parent)
     */
    public void traversePostorder() {
        // For loop to visit each parent, postorder to visit children first
        for (int i = 0; i < children.size(); i++){
            ((GeneralTreeNode) children.get(i)).traversePostorder();
        }
        //Print name of each node visited
        System.out.println(name);
    }
}