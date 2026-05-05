package Trees.BinarySearchTree;
import Trees.BinaryTree.Color;
import Trees.BinaryTree.Node;

public class RedBlackTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    private Node<T> nullNode = new Node<>(null);

    public RedBlackTree() {
        super();
        height = 0;
        nullNode.setColor(Color.BLACK);
    }

    @Override
    public void insert(T value) {
        root = insert(root, value);
        root.setColor(Color.BLACK);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            Node<T> newNode = new Node<>(value);
            newNode.setColor(Color.RED);
            size++;
            return newNode;
        }

        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(insert(node.getRight(), value));
        }
        node = fixInsert(node);
        return node;
    }

    private Node<T> fixInsert(Node<T> node) {
        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            node.setColor(Color.RED);
            node.getLeft().setColor(Color.BLACK);
            node.getRight().setColor(Color.BLACK);
        }
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
            node.setColor(Color.BLACK);
            node.getRight().setColor(Color.RED);
        }

        return node;
    }

    private boolean isRed(Node<T> node) {
        if (node == null) return false;
        return node.getColor() == Color.RED;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> temp = node.getLeft();
        node.setLeft(temp.getRight());
        temp.setRight(node);
        return temp;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> temp = node.getRight();
        node.setRight(temp.getLeft());
        temp.setLeft(node);
        return temp;
    }
}