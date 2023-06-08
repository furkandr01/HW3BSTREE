//Abdurrahman Furkan ADAR
//200316012
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        bst.insert(70);
        bst.insert(45);
        bst.insert(87);
        bst.insert(32);
        bst.insert(56);
        bst.insert(77);
        bst.insert(92);
        bst.insert(21);
        bst.insert(40);
        bst.insert(46);
        bst.insert(68);
        bst.insert(73);
        bst.insert(80);
        bst.insert(89);
        bst.insert(99);
        bst.insert(13);
        bst.insert(27);
        bst.insert(79);
        bst.insert(82);

        List<Integer> preorderOutput = bst.preorderTraversal();
        System.out.println("Preorder output: " + preorderOutput);

        Node lowestCommonAncestor = bst.findLowestCommonAncestor(21, 92);
        System.out.println("Lowest common ancestor of (21, 92): " + lowestCommonAncestor.data);

        lowestCommonAncestor = bst.findLowestCommonAncestor(77, 89);
        System.out.println("Lowest common ancestor of (77, 89): " + lowestCommonAncestor.data);

        bst.deleteNode(40);
        List<Integer> levelOrderOutput = bst.levelOrderTraversal();
        System.out.println("Level order traversal after deleting node 32: " + levelOrderOutput);
    }
}