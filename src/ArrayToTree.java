import java.util.Arrays;

/**
 * Transform sorted array to binary tree with minimal weight
 * July 2020
 */

public class ArrayToTree {

    public static void main(String[] args) {
        // Init empty tree
        BinaryTreeNode root = new BinaryTreeNode();
        // Recursive transfer array to tree
        arrayToTree(root, new int[]{1, 2, 3, 4, 5, 6});
        // Print result
        root.printTree();
    }

    // Recursive transfer array to tree
    static void arrayToTree(BinaryTreeNode treeNode, int[] array) {
        // Transfer middle of the array to node
        if (array.length == 0)
            return;
        int middleIdx = array.length / 2;
        treeNode.setData(array[middleIdx]);
        // Transfer left part of array to left subtree
        if (array.length == 1)
            return;
        BinaryTreeNode leftNode = new BinaryTreeNode();
        treeNode.setChildLeft(leftNode);
        arrayToTree(leftNode, Arrays.copyOfRange(array, 0, middleIdx));
        // Transfer right part of array to to right subtree
        if (array.length == 2)
            return;
        BinaryTreeNode rightNode = new BinaryTreeNode();
        treeNode.setChildRight(rightNode);
        arrayToTree(rightNode, Arrays.copyOfRange(array, middleIdx + 1, array.length));
    }

}
