public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // TODO: Insert test values
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        // TODO: Add more insertions to test all 4 rotation cases

        // Test right rotation inserting numbers to the left
        tree.insert(6);
        tree.insert(5);

        // Test left-right rotation
        tree.insert(8);

        // Test right-left rotation
        tree.insert(25);

        //Test left rotation
        tree.insert(50);
        tree.insert(60);

        // TODO: Print traversals
        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();

        // TODO: Add expected results as comments for verification

        // Expected Inorder: 5, 6, 8, 10, 20, 25, 30, 50, 60
        // Expected Preorder: 10, 6, 5, 8, 25, 20, 50, 30, 60
        // Expected Postorder: 5, 8, 6, 20, 30, 60, 50, 25, 10
    }
}