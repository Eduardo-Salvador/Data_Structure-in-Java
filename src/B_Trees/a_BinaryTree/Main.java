package B_Trees.a_BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();
        integerBinaryTree.insert(5);
        integerBinaryTree.insert(3);
        integerBinaryTree.insert(2);
        integerBinaryTree.insert(1);
        integerBinaryTree.insert(4);
        integerBinaryTree.insert(6);
        integerBinaryTree.insert(7);
        integerBinaryTree.insert(8);
        integerBinaryTree.insert(9);
        integerBinaryTree.insert(10);
        System.out.println("Size: " + integerBinaryTree.size());
    }
}