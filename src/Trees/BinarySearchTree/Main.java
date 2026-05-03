package Trees.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        System.out.println("Binary Search Tree");
        System.out.println("------------------");

        BinarySearchTree<Integer> integerBinarySearchTree = new BinarySearchTree<>();
        integerBinarySearchTree.insert(10);
        integerBinarySearchTree.insert(4);
        integerBinarySearchTree.insert(30);
        integerBinarySearchTree.insert(11);
        integerBinarySearchTree.insert(32);
        integerBinarySearchTree.insert(7);
        integerBinarySearchTree.insert(11);
        integerBinarySearchTree.insert(12);
        integerBinarySearchTree.insert(13);

        integerBinarySearchTree.preOrder();
        System.out.println("------------------");
        integerBinarySearchTree.inOrder();
        System.out.println("------------------");
        integerBinarySearchTree.postOrder();
        System.out.println("------------------");
        System.out.println("Value 20 exists? " + integerBinarySearchTree.contains(20));
        System.out.println("------------------");
        System.out.println("Value 30 exists? " + integerBinarySearchTree.contains(30));
        System.out.println("------------------");
        System.out.println("Value 100 exists? " + integerBinarySearchTree.contains(100));
        System.out.println("------------------");
        System.out.println("Max value: " + integerBinarySearchTree.findMax());
        System.out.println("------------------");
        System.out.println("Min value: " + integerBinarySearchTree.findMin());
        System.out.println("------------------");
    }
}